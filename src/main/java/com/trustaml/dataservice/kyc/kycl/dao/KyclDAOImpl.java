package com.trustaml.dataservice.kyc.kycl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.kyc.kycl.model.Kycl;


@Repository
@Transactional
public class KyclDAOImpl implements IKyclDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional(readOnly = true)
	public Kycl findById(Long id) {

		return entityManager.find(Kycl.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Kycl> findAllKycl() {
		List<Kycl> kycl = entityManager.createQuery("SELECT r FROM Kycl r ORDER BY r.id ASC").getResultList();
		return kycl;
	}

	@Override
	public Long saveOrUpdate(Kycl kycl) {
		if (kycl.getId() == null) {
			entityManager.persist(kycl);
			entityManager.flush();
			return kycl.getId();
		} else {
			entityManager.merge(kycl);
			return null;
		}

	}

}
