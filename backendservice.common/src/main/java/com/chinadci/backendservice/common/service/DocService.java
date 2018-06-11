package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.data.model.Doccategory;
import com.chinadci.backendservice.data.model.Docmanage;
import com.chinadci.backendservice.data.model.Docwithtag;
import com.chinadci.backendservice.model.ServiceListResult;
import com.chinadci.backendservice.model.ServiceResult;

import java.math.BigDecimal;
import java.util.List;

public interface DocService {
    ServiceListResult<Doccategory> getCategoryTreeList();

    ServiceResult addCategory(Doccategory doccategory);

    ServiceResult updateCategory(Doccategory doccategory);

    ServiceResult deleteCategory(Doccategory doccategory);

    ServiceResult updateSindex(BigDecimal id, BigDecimal targetpId, BigDecimal targetIndex);

    void uploadDoc(Docmanage docmanage, Short categoryid);

    ServiceListResult<Docmanage> getCateDocList(Short categoryid, String tagName);

    ServiceResult updateFile(Docmanage docmanage);

    ServiceResult deleteDocs(List<Docmanage> list);

    ServiceResult addDocTag(Short categoryid, String tagName);

    ServiceListResult<Docwithtag> getDocTagList(Short categoryid, String tagName);

    ServiceListResult<Docwithtag> getDocTagList(Short categoryid);

    ServiceResult deleteDocTag(Docwithtag docwithtag);
}
