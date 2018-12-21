package com.trustaml.dataservice.pepentry.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.pepentry.model.Pepentry;

@Repository
@Transactional
public class PepentryDAOImpl implements IPepentryDAO{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Pepentry findById(Long id) {
		return entityManager.find(Pepentry.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pepentry> findAll() {
		List<Pepentry> pepentry = entityManager.createQuery("SELECT r FROM Pepentry r ORDER BY r.id ASC").getResultList();
		return pepentry;
	}

	
	@Override
	public void saveOrUpdate(Pepentry pepentry) {
		if(pepentry == null){
			entityManager.persist(pepentry);
		}else{
			entityManager.merge(pepentry);
		}
		
	}
	

}
