package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.cinema.model.AreaVo;
import com.stylefeng.guns.rest.common.persistence.model.MtimeAreaDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 地域信息表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-10-14
 */
public interface MtimeAreaDictTMapper extends BaseMapper<MtimeAreaDictT> {
   List<AreaVo> getArea();
}
