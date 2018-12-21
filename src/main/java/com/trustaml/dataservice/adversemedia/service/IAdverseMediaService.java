package com.trustaml.dataservice.adversemedia.service;

import java.util.List;

import com.trustaml.dataservice.adversemedia.model.AdverseMedia;

public interface IAdverseMediaService {

	public AdverseMedia findById(Long id) throws Exception;
	public List<AdverseMedia> findAll() throws Exception;
	public Long save(AdverseMedia media) throws Exception;
}
