package com.trustaml.dataservice.investigation.dao;

import java.util.List;

import com.trustaml.dataservice.investigation.model.Investigation;

public interface IInvestigationDAO {

	public Investigation findById(Long id);
	public List<Investigation> findAll();
	public void saveOrUpdate(Investigation investigation);
}
