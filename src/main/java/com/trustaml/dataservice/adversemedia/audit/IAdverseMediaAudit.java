package com.trustaml.dataservice.adversemedia.audit;

import java.util.List;

import com.trustaml.dataservice.adversemedia.model.AdverseMedia;

public interface IAdverseMediaAudit {
 public List<AdverseMedia> mediaList(Long id) throws Exception;
}
