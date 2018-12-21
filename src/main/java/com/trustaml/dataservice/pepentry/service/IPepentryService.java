package com.trustaml.dataservice.pepentry.service;

import java.util.List;

import com.trustaml.dataservice.pepentry.model.Pepentry;

public interface IPepentryService {

	public Pepentry findById(Long id) throws Exception;
	public List<Pepentry>  findAll() throws Exception;
	public void save(Pepentry pepentry) throws Exception;
}
