package com.trustaml.dataservice.hotlist.audit;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.hotlist.model.HotList;

@Repository
@Transactional
public class HotListAuditImpl implements IHotListAudit{
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<HotList> findHotListLog(Long id) throws Exception {
		List<HotList> hotList = AuditReaderFactory.get(entityManager).createQuery()
				.forRevisionsOfEntity(HotList.class, true, true).add(AuditEntity.id().eq(id)).getResultList();
		hotList.stream().filter(Objects::nonNull).forEach(System.out::println);
		return hotList;
	}

}
