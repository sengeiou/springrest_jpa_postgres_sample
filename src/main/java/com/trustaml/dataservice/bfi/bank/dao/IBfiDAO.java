package com.trustaml.dataservice.bfi.bank.dao;

import java.util.List;

import com.trustaml.dataservice.bfi.bank.model.Bfi;

public interface IBfiDAO {

	public Bfi findById(Long id);
	public List<Bfi> findAll();
	public void saveOrUpdate(Bfi bfi);
	
}
