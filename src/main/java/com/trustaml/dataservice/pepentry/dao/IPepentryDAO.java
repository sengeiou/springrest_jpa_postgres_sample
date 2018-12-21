package com.trustaml.dataservice.pepentry.dao;

import java.util.List;

import com.trustaml.dataservice.pepentry.model.Pepentry;

public interface IPepentryDAO {

	public Pepentry findById(Long id);
	public List<Pepentry>  findAll();
	public void saveOrUpdate(Pepentry pepentry);
}
