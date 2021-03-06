package com.stylefeng.guns.rest.modular.auth.util;

import com.stylefeng.guns.rest.config.properties.JwtProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2019/10/15
 * @Time 20:55
 */
@Component
public class JedisUtil {
    @Autowired
    JwtProperties jwtProperties;

//    @Autowired
//    Jedis jedis;
    @Autowired
    private StringRedisTemplate redisTemplate;

    public String getUserId(HttpServletRequest request) {
        String requestHeader = request.getHeader(jwtProperties.getHeader());
        String authToken = null;
        if (requestHeader== null || requestHeader.length() == 0){
            return null;
        }
        authToken = requestHeader.substring(7);
//        String id = jedis.get(authToken);
        String id = redisTemplate.opsForValue().get(authToken);
        return id;
    }
}
