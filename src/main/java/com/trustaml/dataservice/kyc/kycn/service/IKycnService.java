package com.trustaml.dataservice.kyc.kycn.service;

import java.util.List;

import com.trustaml.dataservice.kyc.kycn.model.KycnBase;

public interface IKycnService {
	public KycnBase findById(Long id) throws Exception;
	public List<KycnBase> findAllKycn() throws Exception;
	public Long save(KycnBase kycnBase) throws Exception;
}
