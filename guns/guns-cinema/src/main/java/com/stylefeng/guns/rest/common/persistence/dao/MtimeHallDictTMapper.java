package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.cinema.model.HallTypeVo;
import com.stylefeng.guns.rest.common.persistence.model.MtimeHallDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;


import com.stylefeng.guns.rest.common.persistence.model.MtimeHallDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 地域信息表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-10-14
 */
public interface MtimeHallDictTMapper extends BaseMapper<MtimeHallDictT> {
    List<HallTypeVo> getHallType();
}

