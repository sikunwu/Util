package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.common.entity.ReturnCountAndObjects;
import com.chinadci.backendservice.data.model.*;
import com.chinadci.backendservice.model.AddFunction;
import com.chinadci.backendservice.model.ServiceListResult;
import com.chinadci.backendservice.model.ServiceObjectResult;
import com.chinadci.backendservice.model.ServiceResult;

import java.math.BigDecimal;
import java.util.List;

public interface FunctionService {
    ServiceListResult<Functiontree> getFunctiontree(String syskey);

    ServiceObjectResult<FunctioninfoView> getFunction(BigDecimal functioninfoid);

    ServiceObjectResult<FunctiontreeView> getFunctiontreeByid(String id);

    ServiceObjectResult<Functiontree> addFunctiontree(Functiontree functiontree);

    ServiceResult updateFunctiontree(Functiontree functiontree);

    ServiceResult deleteFunctiontree(Functiontree functiontree);

    ServiceObjectResult<Functiontree> addFunction(AddFunction addFunction, String userid);

    ServiceResult updateFunction(AddFunction addFunction, String userid);

    ServiceListResult<TreeFunction> getTreeFunction(String syskey, String userid);

    ServiceListResult<TreeFunctionList> getTreeFunctionList(String syskey, String userid);

    ServiceResult isLdzmAcess(String userId);

    ServiceResult isManageAcess(String userId);

    ServiceResult updateSindex(String id, String targetpId, BigDecimal targetIndex);

    ServiceListResult<TreeFunction> getFunctionSystemForUser(String syskey, String userid);
}
