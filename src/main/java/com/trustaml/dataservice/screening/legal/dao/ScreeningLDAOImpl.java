package com.trustaml.dataservice.screening.legal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.screening.legal.model.ScreeningLRequest;


@Repository
@Transactional
public class ScreeningLDAOImpl implements IScreeningLDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Long saveOrUpdate(ScreeningLRequest screening) {

		if (screening.getId() == null) {
			entityManager.persist(screening);
			entityManager.flush();
			return screening.getId();
		} else {
			entityManager.merge(screening);
			return null;

		}

	}

	@Override
	public void deleteScreeningL(ScreeningLRequest screening) {

	}

	@Override
	@Transactional(readOnly = true)
	public ScreeningLRequest findById(Long id) {
		return entityManager.find(ScreeningLRequest.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ScreeningLRequest> findAll() {
		List<ScreeningLRequest> screeningList = entityManager
				.createQuery("SELECT sr FROM ScreeningLRequest sr ORDER BY sr.id ASC").getResultList();
		return screeningList;
	}

}
