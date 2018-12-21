package com.trustaml.dataservice.bfi.bank.service;

import java.util.List;

import com.trustaml.dataservice.bfi.bank.model.Bfi;

public interface IBfiService {

	public Bfi findById(Long id) throws Exception;
	public List<Bfi> findAll() throws Exception;
	public void saveOrUpdate(Bfi bfi) throws Exception;
}
