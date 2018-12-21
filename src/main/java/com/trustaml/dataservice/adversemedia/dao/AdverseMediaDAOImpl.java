package com.trustaml.dataservice.adversemedia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.adversemedia.model.AdverseMedia;

@Repository
@Transactional
public class AdverseMediaDAOImpl implements IAdverseMediaDAO{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public AdverseMedia findById(Long id) {
		return entityManager.find(AdverseMedia.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdverseMedia> findAll() {
		List<AdverseMedia> mediaList = entityManager.createQuery("SELECT r FROM AdverseMedia r ORDER BY r.id ASC").getResultList();
		return mediaList;
	}

	@Override
	public Long saveOrUpdate(AdverseMedia media) {
		if(media.getId() == null){
			entityManager.persist(media);
			entityManager.flush();
			return media.getId();
		}else{
			entityManager.merge(media);
			return null;
		}
		
	}

}
