package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.common.entity.ReturnCountAndObjects;
import com.chinadci.backendservice.data.model.Appinfo;
import com.chinadci.backendservice.model.ServiceListResult;
import com.chinadci.backendservice.model.ServiceObjectResult;
import com.chinadci.backendservice.model.ServiceResult;

import java.util.List;

public interface AppService {
    ServiceObjectResult<ReturnCountAndObjects<Appinfo>> getAppList(Short index, Short size, String query);

    ServiceListResult<Appinfo> getAllAppInfo();

    ServiceObjectResult<Appinfo> getAppinfo(String id);

    ServiceResult addApp(Appinfo appinfo);

    ServiceResult updateApp(Appinfo appinfo);

    ServiceResult deleteApps(List<Appinfo> list);
}
