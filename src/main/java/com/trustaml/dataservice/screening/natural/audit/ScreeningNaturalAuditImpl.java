package com.trustaml.dataservice.screening.natural.audit;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.screening.natural.model.ScreeningNRequest;

@Repository
@Transactional
public class ScreeningNaturalAuditImpl implements IScreeningNaturalAudit {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<ScreeningNRequest> getScreeningNaturalLog(Long id) {
		List<ScreeningNRequest> screeningList = AuditReaderFactory.get(entityManager).createQuery()
				.forRevisionsOfEntity(ScreeningNRequest.class, true, true).add(AuditEntity.id().eq(id)).getResultList();

		screeningList.stream().filter(Objects::nonNull).forEach(System.out::println);
		return screeningList;
	}

}
