package com.trustaml.dataservice.ttr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.ttr.model.TtrBase;

@Repository
@Transactional
public class TtrDAOImpl implements ITtrDAO{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public TtrBase findById(Long id) {
		return entityManager.find(TtrBase.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TtrBase> findAll() {
		List<TtrBase> ttrList = entityManager.createQuery("SELECT r FROM TtrBase r ORDER BY r.id ASC").getResultList();
		return ttrList;
	}

	@Override
	public void saveOrUpdate(TtrBase ttr) {
		if(ttr.getId() == null){
			entityManager.persist(ttr);
		}else{
			entityManager.merge(ttr);
		}
		
	}

}
