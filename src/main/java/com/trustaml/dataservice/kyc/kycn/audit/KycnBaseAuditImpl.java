package com.trustaml.dataservice.kyc.kycn.audit;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.kyc.kycn.model.KycnBase;

@Repository
@Transactional
public class KycnBaseAuditImpl implements IKycnBaseAudit {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<KycnBase> findAllKycn(Long id) {

		List<KycnBase> baseList = AuditReaderFactory.get(entityManager).createQuery()
				.forRevisionsOfEntity(KycnBase.class, true, true).add(AuditEntity.id().eq(id)).getResultList();

		baseList.stream().filter(Objects::nonNull).forEach(System.out::println);
		return baseList;
	}

}
