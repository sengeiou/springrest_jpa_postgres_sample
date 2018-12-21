package com.trustaml.dataservice.pepentry.audit;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.pepentry.model.Pepentry;

@Repository
@Transactional
public class PepentryAuditImpl implements IPepentryAudit{
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Pepentry> findPepentryLog(Long id) throws Exception {
		List<Pepentry> pepentry = AuditReaderFactory.get(entityManager).createQuery()
				.forRevisionsOfEntity(Pepentry.class, true, true).add(AuditEntity.id().eq(id)).getResultList();
		pepentry.stream().filter(Objects::nonNull).forEach(System.out::println);
		return pepentry;
	}

}
