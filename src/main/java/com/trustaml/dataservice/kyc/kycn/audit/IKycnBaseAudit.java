package com.trustaml.dataservice.kyc.kycn.audit;

import java.util.List;

import com.trustaml.dataservice.kyc.kycn.model.KycnBase;

public interface IKycnBaseAudit {
	
	public List<KycnBase> findAllKycn(Long id);

}
