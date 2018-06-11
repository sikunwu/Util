package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.data.model.Area;
import com.chinadci.backendservice.model.ServiceListResult;
import com.chinadci.backendservice.model.ServiceObjectResult;
import com.chinadci.backendservice.model.ServiceResult;

import java.util.List;

public interface AreaService {
    ServiceListResult<Area> getCityList();

    ServiceListResult<Area> getList(String parentCode);

    ServiceResult addArea(Area area);

    ServiceResult updateArea(Area area);

    ServiceResult deleteArea(Area area);

    ServiceObjectResult<String> verifyName(Area area);

    ServiceObjectResult<String> getAreaName(String areacode);
}
