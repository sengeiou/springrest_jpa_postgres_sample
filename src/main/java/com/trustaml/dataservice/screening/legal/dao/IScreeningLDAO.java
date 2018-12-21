package com.trustaml.dataservice.screening.legal.dao;

import java.util.List;

import com.trustaml.dataservice.screening.legal.model.ScreeningLRequest;

public interface IScreeningLDAO {

	
	public Long saveOrUpdate(ScreeningLRequest screening);	
	public void deleteScreeningL(ScreeningLRequest screening);
	public ScreeningLRequest findById(Long id);
	public List<ScreeningLRequest> findAll();

}
