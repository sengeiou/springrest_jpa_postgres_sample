package com.trustaml.dataservice.kyc.kycn.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.kyc.kycn.model.KycnBase;


@Repository
@Transactional
public class KycnBaseDAOImpl implements IKycnBaseDAO {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional(readOnly = true)
	public KycnBase findById(Long id) {
		return entityManager.find(KycnBase.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<KycnBase> findAllKycn() {
		List<KycnBase> baseList = entityManager.createQuery("SELECT r FROM KycnBase r ORDER BY r.id ASC")
				.getResultList();
		return baseList;
	}

	@Override
	public Long saveOrUpdate(KycnBase kycnBase) {			
		if (kycnBase.getId() == null) {
			entityManager.persist(kycnBase);
			entityManager.flush();
			return kycnBase.getId();
		} else {
			entityManager.merge(kycnBase);
			return null;
		}

	}

}
