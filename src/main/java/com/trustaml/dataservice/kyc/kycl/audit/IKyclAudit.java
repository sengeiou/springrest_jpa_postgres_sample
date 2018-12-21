package com.trustaml.dataservice.kyc.kycl.audit;

import java.util.List;

import com.trustaml.dataservice.kyc.kycl.model.KycLegal;
import com.trustaml.dataservice.kyc.kycl.model.Kycl;

public interface IKyclAudit {
	
	public List<Kycl> findAllKycl(Long id) throws Exception;
	public List<KycLegal> findPersonalLegal(Long id) throws Exception;

}
