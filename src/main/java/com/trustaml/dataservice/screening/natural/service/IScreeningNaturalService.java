package com.trustaml.dataservice.screening.natural.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.trustaml.dataservice.screening.common.ScreeningAction;
import com.trustaml.dataservice.screening.natural.model.ScreeningNRequest;

public interface IScreeningNaturalService {

	public Long save(ScreeningNRequest screeningN) throws JsonMappingException, JsonParseException,JsonProcessingException;
	public ScreeningNRequest findById(Long id) throws Exception;
	public List<ScreeningNRequest> findAll() throws Exception;	
	public void screeningActionUpdate(ScreeningAction action, Long screeningId) throws Exception;
}
