package com.trustaml.dataservice.adversemedia.audit;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.adversemedia.model.AdverseMedia;

@Repository
@Transactional
public class AdverseMediaAuditImpl implements IAdverseMediaAudit{
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<AdverseMedia> mediaList(Long id) throws Exception {
	
		List<AdverseMedia> mediaList = AuditReaderFactory.get(entityManager).createQuery()
				.forRevisionsOfEntity(AdverseMedia.class, true, true).add(AuditEntity.id().eq(id)).getResultList();
	
		mediaList.stream().filter(Objects::nonNull).forEach(System.out:: println);
		return mediaList;
	}

}
