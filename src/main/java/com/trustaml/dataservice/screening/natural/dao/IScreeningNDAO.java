package com.trustaml.dataservice.screening.natural.dao;

import java.util.List;

import com.trustaml.dataservice.screening.common.ScreeningAction;
import com.trustaml.dataservice.screening.natural.model.ScreeningNRequest;

public interface IScreeningNDAO {

	public ScreeningNRequest findByFirstName(String firstName);
	public Long saveOrUpdate(ScreeningNRequest screeningN);
	public void deleteScreeningN(ScreeningNRequest screeningN);
	public ScreeningNRequest findById(Long id);
	public List<ScreeningNRequest> findAll();	
	public void screeningActionUpdate(ScreeningAction action, Long screeningId);
	}
