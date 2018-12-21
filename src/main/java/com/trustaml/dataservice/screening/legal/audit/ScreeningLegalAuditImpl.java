package com.trustaml.dataservice.screening.legal.audit;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.screening.legal.model.ScreeningLRequest;


@Repository
@Transactional
public class ScreeningLegalAuditImpl implements IScreeningLegalAudit{
	
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<ScreeningLRequest> findLegalById(Long id) {
		List<ScreeningLRequest> screeningList = AuditReaderFactory.get(entityManager).createQuery()
				.forRevisionsOfEntity(ScreeningLRequest.class, true, true).add(AuditEntity.id().eq(id)).getResultList();
		
		screeningList.stream().filter(Objects::nonNull).forEach(System.out::println);
		return screeningList;
	}

}
