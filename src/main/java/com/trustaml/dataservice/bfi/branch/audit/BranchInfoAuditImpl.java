package com.trustaml.dataservice.bfi.branch.audit;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.bfi.branch.model.DetailBranchInfo;

@Repository
@Transactional
public class BranchInfoAuditImpl implements IBranchInfoAudit{
	
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<DetailBranchInfo> findBranchInfoById(Long id) {
		List<DetailBranchInfo> branchList = AuditReaderFactory.get(entityManager).createQuery()
				.forRevisionsOfEntity(DetailBranchInfo.class, true, true).add(AuditEntity.id().eq(id)).getResultList();
		branchList.stream().filter(Objects::nonNull).forEach(System.out::println);
		
		return branchList;
	}

}
