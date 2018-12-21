package com.trustaml.dataservice.hotlist.dao;

import java.util.List;

import com.trustaml.dataservice.hotlist.model.HotList;

public interface IHotListDAO {

	public HotList findById(Long id);
	public List<HotList>  findAll();
	public void saveOrUpdate(HotList hotList);
}
