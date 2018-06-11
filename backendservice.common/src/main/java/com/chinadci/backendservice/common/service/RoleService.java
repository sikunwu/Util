package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.data.model.Roleinfo;
import com.chinadci.backendservice.model.ServiceListResult;
import com.chinadci.backendservice.model.ServiceObjectResult;
import com.chinadci.backendservice.model.ServiceResult;
import com.chinadci.backendservice.model.TreeListItem;

public interface RoleService {
    ServiceListResult<TreeListItem> getRoleTree();

    ServiceObjectResult<Roleinfo> getRoleInfo(String roleId);

    ServiceObjectResult<TreeListItem> postNewRole(Roleinfo roleInfo);

    ServiceObjectResult<TreeListItem> updateRoleInfo(Roleinfo roleInfo);

    ServiceObjectResult deleteRoleInfo(String roleId);

    ServiceListResult<TreeListItem> getAllUserList();

    ServiceListResult<TreeListItem> getUserListByRoleId(String roleId);

    ServiceObjectResult postNewUserRole(String roleId, String userId);

    ServiceObjectResult deleteUserRole(String roleId, String userId);

    ServiceObjectResult modifyPassWord(String userId, String newPassWord);

    ServiceListResult<Roleinfo> getRoleinfoByUserid(String userId);

    ServiceResult updateSindex(String id, String targetpId, Short targetIndex);
}
