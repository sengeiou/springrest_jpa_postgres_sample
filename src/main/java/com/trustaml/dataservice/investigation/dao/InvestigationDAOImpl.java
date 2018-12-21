package com.trustaml.dataservice.investigation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.investigation.model.Investigation;

@Repository
@Transactional
public class InvestigationDAOImpl implements IInvestigationDAO{
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Investigation findById(Long id) {
		return entityManager.find(Investigation.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Investigation> findAll() {
		return entityManager.createQuery("SELECT r FROM Investigation r ORDER BY r.id ASC").getResultList();
	}

	@Override
	public void saveOrUpdate(Investigation investigation) {
	   if(investigation.getId() == null){
		   entityManager.persist(investigation);
	   }else{
		   entityManager.merge(investigation);
	   }
		
	}

}
