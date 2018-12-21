package com.trustaml.dataservice.kyc.kycl.service;

import java.util.List;

import com.trustaml.dataservice.kyc.kycl.model.Kycl;

public interface IKyclService {
	public Kycl findById(Long id) throws Exception;
	public List<Kycl> findAllKycl() throws Exception;
	public Long save(Kycl kycl) throws Exception;
}
