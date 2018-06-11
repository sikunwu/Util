package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.data.model.Businesslayerdefine;
import com.chinadci.backendservice.data.model.FeatureLayerRelationFromOA;
import com.chinadci.backendservice.model.ReturnKeyAndObjectAndList;
import com.chinadci.backendservice.model.ServiceObjectResult;
import com.chinadci.backendservice.model.ServiceResult;

public interface LayerContrastService
{
  ServiceObjectResult<ReturnKeyAndObjectAndList<FeatureLayerRelationFromOA>> getOneBusinessFromOaMap(String id);
  ServiceObjectResult<Businesslayerdefine> getOneBusiness(String atmid);
  ServiceResult addOneBusiness(Businesslayerdefine bussiness);
  ServiceResult updateOneBusiness(Businesslayerdefine bussiness);
  ServiceResult deleteOneBusiness(String atmid);
}
