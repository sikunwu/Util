package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.data.model.Apiuserinfo;
import com.chinadci.backendservice.data.model.Systemdefineadmin;
import com.chinadci.backendservice.data.model.UserRole;
import com.chinadci.backendservice.data.model.Userinfo;
import com.chinadci.backendservice.model.ServiceListResult;
import com.chinadci.backendservice.model.ServiceObjectResult;

import java.util.List;

public interface UserService {
    Userinfo getUserInfo(String userId);

    void updateUserInfo(Userinfo userInfo);

    Userinfo addUserInfo(Userinfo userinfo);

    Boolean isSuperAdmin(String userid);

    ServiceObjectResult<Apiuserinfo> getApiUserinfo(String userid);

    ServiceListResult<UserRole> getRoleidsById(String userid);

    List<Systemdefineadmin> getSystemdefineadminById(String userid);
}
