package com.trustaml.dataservice.bfi.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.bfi.bank.model.Bfi;

@Repository
@Transactional
public class BfiDAOImpl implements IBfiDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Bfi findById(Long id) {

		return entityManager.find(Bfi.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bfi> findAll() {
		List<Bfi> bfiList = entityManager.createQuery("SELECT r FROM Bfi r ORDER BY r.id ASC").getResultList();
		return bfiList;
	}

	@Override
	public void saveOrUpdate(Bfi bfi) {
		if (bfi.getId() == null) {
			entityManager.persist(bfi);
		} else {
			entityManager.merge(bfi);
		}

	}

}
