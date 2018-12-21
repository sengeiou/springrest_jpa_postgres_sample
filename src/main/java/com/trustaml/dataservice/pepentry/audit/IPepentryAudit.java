package com.trustaml.dataservice.pepentry.audit;

import java.util.List;

import com.trustaml.dataservice.pepentry.model.Pepentry;

public interface IPepentryAudit {

	public List<Pepentry> findPepentryLog(Long id) throws Exception;

}
