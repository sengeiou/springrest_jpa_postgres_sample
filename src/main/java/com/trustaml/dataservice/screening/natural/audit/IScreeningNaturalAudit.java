package com.trustaml.dataservice.screening.natural.audit;

import java.util.List;

import com.trustaml.dataservice.screening.natural.model.ScreeningNRequest;

public interface IScreeningNaturalAudit {
	public List<ScreeningNRequest> getScreeningNaturalLog(Long id);

}
