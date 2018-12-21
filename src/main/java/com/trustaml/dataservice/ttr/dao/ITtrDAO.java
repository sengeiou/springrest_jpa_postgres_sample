package com.trustaml.dataservice.ttr.dao;

import java.util.List;

import com.trustaml.dataservice.ttr.model.TtrBase;

public interface ITtrDAO {

	public TtrBase findById(Long id);

	public List<TtrBase> findAll();

	public void saveOrUpdate(TtrBase ttr);
}
