package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.common.entity.ReturnCountAndObjects;
import com.chinadci.backendservice.data.model.*;
import com.chinadci.backendservice.model.*;
import com.chinadci.backendservice.data.model.Featurefile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface FeatureService {
    ServiceListResult<Systemdefine> getAllInnerSystem(Short identification,Short mobile);

    ServiceListResult<Systemdefine> getSubSystem(String syskey);

    ServiceListResult<Featureinfo> getAllFeature(String internalsystemid);

    ServiceListResult<Featureinfo> getFeatureForUser(String userid, String internalsystemid);

    ServiceObjectResult<Featureinfo> getFeature(BigDecimal featureid);

    ServiceObjectResult<Featureinfo> addFeature(Featureinfo feature);

    ServiceObjectResult<Featureinfo> updateFeature(Featureinfo feature);

    ServiceResult deleteFeature(Featureinfo feature);

    ServiceListResult<FeatureLayerRelation> getFeatureLayerUrlById(BigDecimal featureid);

    ServiceListResult<FeatureLayerRelation> getFeatureLayerById(BigDecimal featureid);

    ServiceListResult<FeatureLayerResource> getLayerForFeature(Short featureid);

    ServiceResult addFeatureLayer(AddFeatureLayer addFeatureLayer);

    ServiceResult deleteFeatureLayer(List<FeatureLayerNodeId> featureLayerNodeId);

    ServiceResult updateSindex(BigDecimal id, BigDecimal targetpId, BigDecimal targetIndex);

    ServiceListResult<ReturnKeyAndValues<String>> MultiCategoryList(BigDecimal parentID, String levelStr, Boolean overlay, Boolean islevelStr);

    ServiceListResult<Featureinfo> verifyFeatureRename(String fName, BigDecimal pId);

    ServiceResult copyFeature(Boolean overlay, BigDecimal resourceId, BigDecimal targetId);

    int uploadFeatureFile(Featurefile featurefile);

    ServiceListResult<Featurefile> getFeatureFiles(BigDecimal featureId, String tagName);

    ServiceResult updateFile(BigDecimal featurefileid, String tagName, String userid);

    ServiceResult deleteFeatureFiles(List<Featurefile> list);

    ServiceResult chooseDocFiles(BigDecimal featureid, String docid, String userid);

    ServiceResult addFeatureTag(BigDecimal featureid, String tagName);

    ServiceResult deleteFeatureTag(Featurefilewithtag featurefilewithtag);

    ServiceListResult<Featurefilewithtag> getFeatureTagList(BigDecimal featureid);

    ServiceListResult<Featurefilewithtag> getFeatureTagList(BigDecimal featureid, String tagName);

    ServiceListResult<String> getMapResoDataBase(String type, String name);

    ServiceResult exportTopicData(BigDecimal resourceId) throws IOException;
}
