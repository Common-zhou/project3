package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeHallFilmInfoT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 影厅电影信息表 Mapper 接口
 * </p>
 *
 * @author ywx
 * @since 2019-10-14
 */
public interface MtimeHallFilmInfoTMapper extends BaseMapper<MtimeHallFilmInfoT> {

    MtimeHallFilmInfoT selectByFilmId(Integer filmId);
}
