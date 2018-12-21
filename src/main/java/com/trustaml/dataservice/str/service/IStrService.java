package com.trustaml.dataservice.str.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.trustaml.dataservice.str.model.StrBase;


public interface IStrService {

	public StrBase findById(Long id) throws Exception;

	public List<StrBase> findAll() throws Exception;

	public void save(JSONObject jsonObject) throws Exception;
}
