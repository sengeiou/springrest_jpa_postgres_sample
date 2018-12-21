package com.trustaml.dataservice.investigation.service;

import java.util.List;

import com.trustaml.dataservice.investigation.model.Investigation;

public interface IInvestigationService {

	public Investigation findById(Long id) throws Exception;
	public List<Investigation> findAll() throws Exception;
	public void save(Investigation investigation) throws Exception;
}
