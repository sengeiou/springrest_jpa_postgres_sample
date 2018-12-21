package com.trustaml.dataservice.bfi.branch.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.bfi.branch.model.DetailBranchInfo;

@Repository
@Transactional
public class DetailBranchInfoDAOImpl implements IDetailBranchInfoDAO{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public DetailBranchInfo findById(Long id) {
		return entityManager.find(DetailBranchInfo.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<DetailBranchInfo> findAllBranchInfo() {
		List<DetailBranchInfo> branchList = entityManager.createQuery("SELECT r  FROM DetailBranchInfo r ORDER BY r.id ASC").getResultList();
		return branchList;
	}

	@Override
	public void saveOrUpdate(DetailBranchInfo branchInfo) {
		if(branchInfo.getId() == null){
			entityManager.persist(branchInfo);
		}else{
			entityManager.merge(branchInfo);
		}
		
		
	}

}
