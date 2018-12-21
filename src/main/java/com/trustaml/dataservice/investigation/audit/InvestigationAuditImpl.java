package com.trustaml.dataservice.investigation.audit;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.investigation.model.Investigation;

@Repository
@Transactional
public class InvestigationAuditImpl implements IInvestigationAudit{
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Investigation> findAllLogs(Long id) {
		List<Investigation> investigationList = AuditReaderFactory.get(entityManager).createQuery()
				.forRevisionsOfEntity(Investigation.class, true, true).add(AuditEntity.id().eq(id)).getResultList();
		
		investigationList.stream().filter(Objects::nonNull).forEach(System.out::println);
		return investigationList;
	}

}
