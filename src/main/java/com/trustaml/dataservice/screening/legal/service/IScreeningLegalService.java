package com.trustaml.dataservice.screening.legal.service;

import java.util.List;

import com.trustaml.dataservice.screening.common.ScreeningAction;
import com.trustaml.dataservice.screening.legal.model.ScreeningLRequest;

public interface IScreeningLegalService {

	public Long save(ScreeningLRequest screening) throws Exception;	
	public ScreeningLRequest findById(Long id) throws Exception;
	public List<ScreeningLRequest> findAll() throws  Exception;
	public void screeningActionUpdate(ScreeningAction action, Long screeningId) throws Exception;
	
}
