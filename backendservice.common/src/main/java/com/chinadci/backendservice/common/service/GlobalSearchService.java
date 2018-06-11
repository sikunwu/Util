package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.data.model.ConfigGlobalsearch;
import com.chinadci.backendservice.data.model.extend.ConfigGlobalsearchExt;
import com.chinadci.backendservice.model.ServiceListResult;
import com.chinadci.backendservice.model.ServiceObjectResult;
import com.chinadci.backendservice.model.ServiceResult;

public interface GlobalSearchService {
    ServiceResult Insert(ConfigGlobalsearch record);

    ServiceResult Update(ConfigGlobalsearch record);

    ServiceResult Delete(Short id);

    ServiceListResult<ConfigGlobalsearchExt> GetAllRecord();

    ServiceObjectResult<ConfigGlobalsearch> GetRecordByID(Short id);
}
