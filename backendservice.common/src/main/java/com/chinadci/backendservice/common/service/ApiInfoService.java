package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.common.entity.ReturnCountAndObjects;
import com.chinadci.backendservice.data.model.ApiauthSysname;
import com.chinadci.backendservice.data.model.Apiauthorization;
import com.chinadci.backendservice.data.model.Apiinfo;
import com.chinadci.backendservice.data.model.Systemdefine;
import com.chinadci.backendservice.model.ApiinfoStatus;
import com.chinadci.backendservice.model.ServiceListResult;
import com.chinadci.backendservice.model.ServiceObjectResult;
import com.chinadci.backendservice.model.ServiceResult;

import java.util.List;

public interface ApiInfoService {
    ServiceListResult<Systemdefine> getAllSystem();

    ServiceObjectResult<ReturnCountAndObjects<ApiinfoStatus>> getApiBySystem(int pageNum, int pageSize, String condition, String syskey, String userId, String requestUrl);

    ServiceResult addApiInfo(Apiinfo apiinfo);

    ServiceResult updateApiInfo(Apiinfo apiinfo);

    ServiceObjectResult<ApiinfoStatus> getApiInfo(Short apiid, String userId, String requestUrl);

    ServiceResult deleteApiInfo(Apiinfo apiinfo);

    ServiceResult deleteApiinfos(List<Apiinfo> list);

    ServiceListResult<ApiauthSysname> getApiauthorization();

    ServiceListResult<ApiauthSysname> getApiauthById(Short apiid);

    ServiceResult addApply(Apiinfo apiinfo, String userId);

    ServiceObjectResult<Integer> updateStatus(Apiauthorization apiauthorization);
}
