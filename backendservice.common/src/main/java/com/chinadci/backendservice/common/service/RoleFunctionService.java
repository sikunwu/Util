package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.data.model.RoleFunction;
import com.chinadci.backendservice.model.RoleFunctionIds;
import com.chinadci.backendservice.model.ServiceListResult;
import com.chinadci.backendservice.model.ServiceResult;

public interface RoleFunctionService
{
  ServiceListResult<RoleFunction> getRoleFunction(String roleid,String syskey);
  ServiceResult updateRoleFunction(RoleFunctionIds functionIds);
}
