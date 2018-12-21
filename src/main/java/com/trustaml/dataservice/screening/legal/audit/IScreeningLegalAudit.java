package com.trustaml.dataservice.screening.legal.audit;

import java.util.List;

import com.trustaml.dataservice.screening.legal.model.ScreeningLRequest;

public interface IScreeningLegalAudit {

	public List<ScreeningLRequest> findLegalById(Long id);
}
