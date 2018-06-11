package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.data.model.FieldsSys;
import com.chinadci.backendservice.data.model.LayersSys;
import com.chinadci.backendservice.data.model.Resourceinfo;
import com.chinadci.backendservice.model.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface GrantService {
    ServiceListResult<GrantOfSys> getAllGrantByRIdAndName(BigDecimal resourceId, String sysName, Short identification);

    ServiceObjectResult<LayersSys> getGrantOfLayer(BigDecimal resourceId, String syskey);

    ServiceObjectResult<FieldsSys> getGrantOfField(BigDecimal layerId ,String syskey);

    ServiceResult addSys(SysLayerField sysLayerField) throws IOException;

    ServiceListResult<Resourceinfo> getAllResource(String syskey);

    Boolean isGrantOfSystem(String enname, String syskey);

    Boolean isGrantOfLayer(String enname, String sindex, String syskey);

    Boolean isGrantOfLayerQueryAble(String enname, String sindex, String syskey);

    Boolean isGrantOfFields(String enname, String sindex, String fieldname, String syskey);

    String getLayers(String enname, String syskey);

    String getFields(String enname,BigDecimal sindex, String syskey);

    List<GrantFieldinfo> getGrantFieldList(String enname, String syskey);
}
