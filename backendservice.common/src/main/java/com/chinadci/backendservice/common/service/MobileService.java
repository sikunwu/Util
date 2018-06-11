package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.data.model.AppDocSimple;
import com.chinadci.backendservice.data.model.AppFileSimple;
import com.chinadci.backendservice.data.model.Featurefile;
import com.chinadci.backendservice.model.*;

import java.util.List;

public interface MobileService
{
  ServiceResult addDevice(MobileDevice mobileDevice);
  ServiceListResult<DocCategoryDoc> getDocCategoryDoc(MobileDevice mobileDevice);
  ServiceListResult<AppFileSimple> getFeaturefile(MobileDevice mobileDevice);
  ServiceListResult<MapCategoryFeature> getFeatureData(MobileDevice mobileDevice);
  ServiceObjectResult<AppUpdateInfo> getAppUpdateInfo(String appid);
}
