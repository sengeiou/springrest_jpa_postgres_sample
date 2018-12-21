package com.trustaml.dataservice.kyc.kycn.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustaml.dataservice.kyc.kycn.dao.IKycnBaseDAO;
import com.trustaml.dataservice.kyc.kycn.model.KycnBase;
import com.trustaml.dataservice.kyc.kycn.model.KycnPersonalInfo;

@Service("kycnService")
public class KycnServiceImpl implements IKycnService {

	@Autowired
	IKycnBaseDAO kycnDao;

	@Override
	public KycnBase findById(Long id) throws Exception {
		return kycnDao.findById(id);
	}

	@Override
	public List<KycnBase> findAllKycn() throws Exception {
		return kycnDao.findAllKycn();
	}

	@Override
	public Long save(KycnBase kycnBase) throws Exception {
//		String searchText = "";

		kycnBase.getKycnAccountsInfo().stream().filter(Objects::nonNull).forEach(info -> info.setKycnBase(kycnBase));
		kycnBase.getKycnAddressInfo().stream().filter(Objects::nonNull).forEach(r -> r.setKycnBase(kycnBase));
		kycnBase.getKycnEducationInfo().stream().filter(Objects::nonNull).forEach(r -> r.setKycnBase(kycnBase));
		kycnBase.getKycnFinancialInfo().stream().filter(Objects:: nonNull).forEach(r -> r.setKycnBase(kycnBase));
		kycnBase.getKycnIdentificationInfo().stream().filter(Objects::nonNull).forEach(r -> r.setKycnBase(kycnBase));
		kycnBase.getKycnInvolvementInfo().stream().filter(Objects::nonNull).forEach(r -> r.setKycnBase(kycnBase));
		kycnBase.getKycnObservationInfo().stream().filter(Objects::nonNull).forEach(r -> r.setKycnBase(kycnBase));
		kycnBase.getKycnRelatedEntityInfo().stream().filter(Objects::nonNull).forEach(r -> r.setKycnBase(kycnBase));
		kycnBase.getKycnRelatedPersonInfo().stream().filter(Objects::nonNull).forEach(r -> r.setKycnBase(kycnBase));
		kycnBase.getKycnRelationInfo().stream().filter(Objects::nonNull).forEach(r -> r.setKycnBase(kycnBase));
		

		if (kycnBase.getKycnPersonalInfo() != null) {
			KycnPersonalInfo info = kycnBase.getKycnPersonalInfo();
			info.setKycnBase(kycnBase);
			if (info.getUser() != null) 
				info.getUser().setPersonalInfo(kycnBase.getKycnPersonalInfo());
			
		}
		return kycnDao.saveOrUpdate(kycnBase);

	}

}
