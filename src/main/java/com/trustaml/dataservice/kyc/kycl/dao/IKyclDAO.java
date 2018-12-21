package com.trustaml.dataservice.kyc.kycl.dao;

import java.util.List;

import com.trustaml.dataservice.kyc.kycl.model.Kycl;

public interface IKyclDAO {
	
	public Kycl findById(Long id);
	public List<Kycl> findAllKycl();
	public Long saveOrUpdate(Kycl kycl);

}
