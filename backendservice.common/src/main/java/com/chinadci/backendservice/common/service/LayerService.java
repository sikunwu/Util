package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.data.model.Fieldinfo;
import com.chinadci.backendservice.data.model.Layerinfo;
import com.chinadci.backendservice.model.ServiceListResult;
import com.chinadci.backendservice.model.ServiceResult;

import java.math.BigDecimal;
import java.util.List;

public interface LayerService {
    ServiceResult updateLayer(List<Layerinfo> layerinfoList);

    ServiceListResult<Fieldinfo> getAllField(BigDecimal layerid);

    ServiceResult updateFields(List<Fieldinfo> fields);
}
