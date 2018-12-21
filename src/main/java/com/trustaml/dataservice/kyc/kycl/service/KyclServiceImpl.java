package com.trustaml.dataservice.kyc.kycl.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustaml.dataservice.kyc.kycl.dao.IKyclDAO;
import com.trustaml.dataservice.kyc.kycl.model.Kycl;

@Service("kyclService")
public class KyclServiceImpl implements IKyclService {

	@Autowired
	IKyclDAO kyclDao;

	@Override
	public Kycl findById(Long id) throws Exception {
		return kyclDao.findById(id);
	}

	@Override
	public List<Kycl> findAllKycl() throws Exception {
		return kyclDao.findAllKycl();
	}

	@Override
	public Long save(Kycl kycl) throws Exception {

		if (kycl.getComplianceInfo() != null)
			kycl.getComplianceInfo().setKycl(kycl);

		if (kycl.getFinancialInfo() != null)
			kycl.getFinancialInfo().setKycl(kycl);

		if (kycl.getLegal() != null)
			kycl.getLegal().setKycl(kycl);

		if (kycl.getUser() != null)
			kycl.getUser().setKycl(kycl);

		kycl.getListAccountInfo().stream().filter(Objects::nonNull).forEach(r -> r.setKycl(kycl));
		kycl.getListAddress().stream().filter(Objects::nonNull).forEach(r -> r.setKycl(kycl));
		kycl.getListAuditInfo().stream().filter(Objects::nonNull).forEach(r -> r.setKycl(kycl));
		kycl.getListBusinessInfo().stream().filter(Objects::nonNull).forEach(r -> r.setKycl(kycl));
		kycl.getListDocumentStatus().stream().filter(Objects::nonNull).forEach(r -> r.setKycl(kycl));
		kycl.getListLandlordAddress().stream().filter(Objects::nonNull).forEach(r -> r.setKycl(kycl));
		kycl.getListRegistrationAddress().stream().filter(Objects::nonNull).forEach(r -> r.setKycl(kycl));
		kycl.getListRegistrationInfo().stream().filter(Objects::nonNull).forEach(r -> r.setKycl(kycl));
		kycl.getListRelatedEntityInfo().stream().filter(Objects::nonNull).forEach(r -> r.setKycl(kycl));
		kycl.getListRelatedPerson().stream().filter(Objects::nonNull).forEach(r -> r.setKycl(kycl));
		return kyclDao.saveOrUpdate(kycl);

	}

}
