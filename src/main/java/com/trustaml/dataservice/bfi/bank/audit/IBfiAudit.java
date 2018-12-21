package com.trustaml.dataservice.bfi.bank.audit;

import java.util.List;

import com.trustaml.dataservice.bfi.bank.model.Bfi;

public interface IBfiAudit {

	public List<Bfi> findBfiLog(Long id) throws Exception;
}
