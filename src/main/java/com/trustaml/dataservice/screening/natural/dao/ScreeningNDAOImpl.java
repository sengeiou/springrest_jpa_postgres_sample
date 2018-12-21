package com.trustaml.dataservice.screening.natural.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.screening.common.ScreeningAction;
import com.trustaml.dataservice.screening.natural.model.ScreeningNRequest;

@Repository
@Transactional
public class ScreeningNDAOImpl extends AbstractDao<Long, ScreeningNRequest> implements IScreeningNDAO {

	@Override
	public ScreeningNRequest findByFirstName(String firstName) {

		return null;
	}

	@Override
	public Long saveOrUpdate(ScreeningNRequest screeningN) {

		if (screeningN.getId() == null) {
			persist(screeningN);
			entityManager.flush();
			return screeningN.getId();

		} else {
			update(screeningN);
			return null;
		}

	}

	@Override
	public void deleteScreeningN(ScreeningNRequest screeningN) {

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<ScreeningNRequest> findAll() {
		List<ScreeningNRequest> screeningList = entityManager
				.createQuery("SELECT sr FROM ScreeningNRequest sr ORDER  BY sr.id ASC").getResultList();
		
		return screeningList;
	}

	@Override
	@Transactional(readOnly = true)
	public ScreeningNRequest findById(Long id) {
		ScreeningNRequest request = entityManager.find(ScreeningNRequest.class, id);

		// for(ScreeningRelatedRequest r: request.getListOfRelated()){
		// r.setListOfNaturalRequest(null);
		// }
		return request;

	}

	@Override
	public void screeningActionUpdate(ScreeningAction action, Long screeningId) {
		ScreeningNRequest screeningN = findById(screeningId);
		Set<ScreeningAction> actionList = new HashSet<>();
		actionList.add(action);
		screeningN.setScreeningNAction(actionList);
		saveOrUpdate(screeningN);

	}

}
