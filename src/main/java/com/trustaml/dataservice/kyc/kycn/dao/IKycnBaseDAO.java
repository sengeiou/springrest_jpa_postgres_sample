package com.trustaml.dataservice.kyc.kycn.dao;

import java.util.List;

import com.trustaml.dataservice.kyc.kycn.model.KycnBase;

public interface IKycnBaseDAO {
	public KycnBase findById(Long id);
	public List<KycnBase> findAllKycn();
	public Long saveOrUpdate(KycnBase kycnBase);

}
