package com.trustaml.dataservice.screening.natural.dao;

import com.trustaml.dataservice.screening.natural.model.ScreeningRelatedRequest;

public interface IScreeningRelatedPersonDAO {
	ScreeningRelatedRequest findById(Long id);

//	ScreeningNRequest findRequestById(Long id);
}
