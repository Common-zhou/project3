package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.modular.auth.util.JedisUtil;
import com.stylefeng.guns.rest.user.model.BaseUserResponseVO;
import com.stylefeng.guns.rest.user.model.BaseVo;
import com.stylefeng.guns.rest.user.model.MtimeUserInfo;
import com.stylefeng.guns.rest.user.model.UserRegister;
import com.stylefeng.guns.rest.user.service.MtimeUserTService;
import com.stylefeng.guns.rest.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2019/10/12
 * @Time 17:30
 */
@RestController
public class UserController {


    @Reference(interfaceClass = MtimeUserTService.class, check = false)
    MtimeUserTService mtimeUserTService;

    @Reference(interfaceClass = UserService.class, check = false)
    UserService userService;

    @Autowired
    JwtProperties jwtProperties;

    //    @Autowired
//    Jedis jedis;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    JedisUtil jedisUtil;

    @RequestMapping("/user")
    public String queryUserById(Integer id) {
        String username = userService.selectUserNameById(id);
        return username;
    }

    /*    @RequestMapping("test")
        public String test(){
            return "test";
        }*/
   /* @RequestMapping("auth")
    public String userLogin(String userName,String password) {

        if(mtimeUserTService.loginByUserNameAndPassword(userName,password)==1){
            return 1+"";
        }

        return 0+"";
    }*/

    @RequestMapping("/user/getUserInfo")
    public BaseVo getUserInfoByToken(HttpServletRequest request) {
//        jwtProperties.
        String userId = jedisUtil.getUserId(request);
        MtimeUserInfo userInfo = mtimeUserTService.selectUserInfoById(userId);
        return BaseVo.successVo(userInfo, null);
    }

    @RequestMapping("/user/check")
    public BaseUserResponseVO userCheck(String username) {
        BaseUserResponseVO VO = new BaseUserResponseVO();
        int i = userService.userCheck(username);
        if (i == 0) {//可以注册该用户名
            VO.setStatus(0);
            VO.setMsg("用户名不存在！");
        } else if (i == 1) {
            VO.setStatus(1);
            VO.setMsg("用户名已注册！");
        }
        return VO;
    }

    @RequestMapping("/user/register")
    public BaseUserResponseVO userRegister(UserRegister userRegister) {
        BaseUserResponseVO VO = new BaseUserResponseVO();
        int i = userService.userRegister(userRegister);
        if (i == 0) {//可以注册该用户名
            VO.setStatus(0);
            VO.setMsg("注册成功！");
        } else if (i == 1) {
            VO.setStatus(1);
            VO.setMsg("用户已经存在！");
        }
        return VO;
    }

    @RequestMapping("/user/updateUserInfo")
    public BaseVo userUpdate(MtimeUserInfo userInfo) {
        Integer result = userService.updateUserInfo(userInfo);
        if (result != null && result > 0)
            return BaseVo.successVo(userInfo, null);
        return BaseVo.errorVo(1, "修改用户信息失败");
    }

    ///user/logout
    @RequestMapping("/user/logout")
    public BaseVo logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String requestHeader = request.getHeader(jwtProperties.getHeader());
        String authToken = null;
        BaseVo baseVo = new BaseVo();
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);
//            String flag = jedis.get(authToken);
            String flag = redisTemplate.opsForValue().get(authToken);
//            if (flag == null) {
//                baseVo.setStatus(1);
//                baseVo.setMsg("退出失败，用户尚未登陆");
//                return baseVo;
//            }
//            jedis.del(authToken);
            redisTemplate.delete(authToken);
        }
//        }else{
//            BaseVo baseVo = new BaseVo();
//            baseVo.setStatus(1);
//            baseVo.setMsg("退出失败，用户尚未登陆");
//            return baseVo;
//        }

//        response.sendRedirect("/");
        baseVo.setStatus(0);
        baseVo.setMsg("退出成功");
        return baseVo;

    }


}
