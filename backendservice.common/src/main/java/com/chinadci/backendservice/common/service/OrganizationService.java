package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.data.model.Employeeinfo;
import com.chinadci.backendservice.data.model.Organizationinfo;
import com.chinadci.backendservice.model.*;

public interface OrganizationService {

    ServiceListResult<TreeListItem> getOrganazationTree();

    ServiceObjectResult<Organizationinfo> getOrganazationInfo(String orgId);

    ServiceObjectResult<Employeeinfo> getEmployeeInfo(String empId);

    ServiceObjectResult<TreeListItem> getNewOrganazationItem(String pOrgId, String curUserId);

    ServiceObjectResult<TreeListItem> postNewOrganazation(Organizationinfo orgInfo,String curUserId);

    ServiceObjectResult<TreeListItem> getNewEmployeeItem(String orgId);

    ServiceObjectResult<TreeListItem> postNewEmployee(NewEmpInfo empInfo);

    ServiceObjectResult<TreeListItem>updateOrgInfo(Organizationinfo orgInfo);

    ServiceObjectResult<TreeListItem> updateEmpInfo(Employeeinfo empInfo);

    ServiceObjectResult deleteOrgInfo(String orgId);

    ServiceObjectResult deleteEmpInfo(String empId);

    ServiceObjectResult postNewEmpOrg(String orgId, String empId);

    ServiceObjectResult postDeleteEmpOrg(String orgId, String empId);

    ServiceResult updateSindex(String id, String oripId, String targetpId, Short targetIndex, String dciitemtype);
}