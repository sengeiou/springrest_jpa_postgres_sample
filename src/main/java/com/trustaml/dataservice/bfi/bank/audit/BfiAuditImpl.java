package com.trustaml.dataservice.bfi.bank.audit;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.bfi.bank.model.Bfi;

@Repository
@Transactional
public class BfiAuditImpl implements IBfiAudit{

	
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Bfi> findBfiLog(Long id) {
		List<Bfi> bfiList = AuditReaderFactory.get(entityManager).createQuery()
				.forRevisionsOfEntity(Bfi.class, true, true).add(AuditEntity.id().eq(id)).getResultList();
		
		bfiList.stream().filter(Objects::nonNull).forEach(System.out::println);
		return bfiList;
	}

}
