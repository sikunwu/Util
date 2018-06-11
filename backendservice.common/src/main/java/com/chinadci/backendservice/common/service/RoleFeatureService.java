package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.data.model.RoleFeature;
import com.chinadci.backendservice.model.RoleFeatureIds;
import com.chinadci.backendservice.model.ServiceListResult;
import com.chinadci.backendservice.model.ServiceResult;

public interface RoleFeatureService
{
  ServiceListResult<RoleFeature> getRoleFeature(String roleId,String syskey);
  ServiceResult updateRoleFeature(RoleFeatureIds featureIds);
}
