package com.trustaml.dataservice.kyc.kycl.audit;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.kyc.kycl.model.KycLegal;
import com.trustaml.dataservice.kyc.kycl.model.Kycl;

@Repository
@Transactional
public class KyclAuditImpl implements IKyclAudit {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Kycl> findAllKycl(Long id) {

		List<Kycl> baseList = AuditReaderFactory.get(entityManager).createQuery()
				.forRevisionsOfEntity(Kycl.class, true, true).add(AuditEntity.id().eq(id)).getResultList();

		baseList.stream().filter(Objects::nonNull).forEach(System.out::println);
		return baseList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KycLegal> findPersonalLegal(Long id) {
		List<KycLegal> legal = AuditReaderFactory.get(entityManager).createQuery()
				.forRevisionsOfEntity(KycLegal.class, true, true).add(AuditEntity.id().eq(id)).getResultList();

		legal.stream().filter(Objects::nonNull).forEach(System.out::println);
		return legal;
	}

}
