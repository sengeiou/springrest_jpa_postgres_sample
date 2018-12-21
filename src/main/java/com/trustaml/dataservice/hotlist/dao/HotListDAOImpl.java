package com.trustaml.dataservice.hotlist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.hotlist.model.HotList;

@Repository
@Transactional
public class HotListDAOImpl implements IHotListDAO{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public HotList findById(Long id) {
		return entityManager.find(HotList.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HotList> findAll() {
		List<HotList> hotList = entityManager.createQuery("SELECT r FROM HotList r ORDER BY r.id ASC").getResultList();
		return hotList;
	}

	
	@Override
	public void saveOrUpdate(HotList hotList) {
		if(hotList == null){
			entityManager.persist(hotList);
		}else{
			entityManager.merge(hotList);
		}
		
	}
	

}
