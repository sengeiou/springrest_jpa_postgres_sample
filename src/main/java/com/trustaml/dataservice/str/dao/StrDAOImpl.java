package com.trustaml.dataservice.str.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.str.model.StrBase;

@Repository
@Transactional
public class StrDAOImpl implements IStrDAO{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public StrBase findById(Long id) {
		return entityManager.find(StrBase.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StrBase> findAll() {
		List<StrBase> strList = entityManager.createQuery("SELECT r FROM StrBase r ORDER BY r.id ASC").getResultList();
		return strList;
	}

	@Override
	public void saveOrUpdate(StrBase str) {
		if(str.getId() == null){
			entityManager.persist(str);
		}else{
			entityManager.merge(str);
		}
		
	}

}
