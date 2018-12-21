package com.trustaml.dataservice.hotlist.service;

import java.util.List;

import com.trustaml.dataservice.hotlist.model.HotList;

public interface IHotListService {

	public HotList findById(Long id) throws Exception;
	public List<HotList>  findAll() throws Exception;
	public void save(HotList hotList) throws Exception;
}
