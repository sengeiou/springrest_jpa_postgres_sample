package com.trustaml.dataservice.investigation.audit;

import java.util.List;

import com.trustaml.dataservice.investigation.model.Investigation;

public interface IInvestigationAudit {

	public List<Investigation>  findAllLogs(Long id);
}
