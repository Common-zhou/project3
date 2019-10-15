package com.stylefeng.guns.rest.cinema.model;

import java.io.Serializable;
import java.util.List;

public class ConditionVo implements Serializable {

    private static final long serialVersionUID = -8931734548370592139L;
    private List<AreaVo> areaList;
    private List<BrandVo> brandList;
    private List<HallTypeVo> hallTypeList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<AreaVo> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<AreaVo> areaList) {
        this.areaList = areaList;
    }

    public List<BrandVo> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<BrandVo> brandList) {
        this.brandList = brandList;
    }

    public List<HallTypeVo> getHallTypeList() {
        return hallTypeList;
    }

    public void setHallTypeList(List<HallTypeVo> hallTypeList) {
        this.hallTypeList = hallTypeList;
    }
}
