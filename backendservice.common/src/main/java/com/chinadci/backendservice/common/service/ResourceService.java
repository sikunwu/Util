package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.common.entity.ReturnCountAndObjects;
import com.chinadci.backendservice.data.model.*;
import com.chinadci.backendservice.model.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ResourceService {
    ServiceListResult<Layerinfo> getAllLayer();

    ServiceListResult<Resourcetype> getAllResourceType();

    ServiceListResult<Resourceinfo> getAllResource();

    ServiceListResult<Maintenanceunit> getAllMaintenanceunit();

    ServiceObjectResult<ReturnCountAndObjects<ResourceByFuzzy>> getResourcesByFuzzy(String unit, BigDecimal type, String name, String orderby, int number, int page);

    ServiceObjectResult<WMTSInfo> getWmtsInfo(String url);

    ServiceObjectResult<WMTSInfo> getWmtsInfoByid(BigDecimal id);

    ServiceResult updateResource(ChangeResourceLayers resource);

    ServiceResult updateResourceLock(Resourceinfo resourceinfo);

    ServiceResult deleteResource(Resourceinfo resourceinfo);

    ServiceResult deleteResources(List<Resourceinfo> list);

    ServiceListResult<Layerinfo> getLayersFromResourcceId(BigDecimal resourceId);

    ServiceObjectResult<Layerinfo> getLayer(BigDecimal layerId);

    ServiceObjectResult<Resourceinfo> getResource(BigDecimal resourceId);

    ServiceListResult<ResourceName> getResourceNameFromUserId(String userId);

    ServiceResult addWMTSResource(Resourceinfo resource);

    ServiceResult addTileResource(Resourceinfo resource);

    ServiceResult addDynamicResource(ResourceLayers res);

    ServiceResult verifyserverurl(String url);

    ServiceObjectResult<String> getResourceUrl(String ename,String urltype);
}
