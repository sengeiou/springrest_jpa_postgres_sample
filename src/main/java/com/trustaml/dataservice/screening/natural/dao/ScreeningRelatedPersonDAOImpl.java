package com.trustaml.dataservice.screening.natural.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trustaml.dataservice.screening.natural.model.ScreeningRelatedRequest;

@Service("screeningRelatedPersonDAO")
@Repository
@Transactional
public class ScreeningRelatedPersonDAOImpl extends AbstractDao<Long, ScreeningRelatedRequest>
		implements IScreeningRelatedPersonDAO {

	@Override
	public ScreeningRelatedRequest findById(Long id) {

		return entityManager.find(ScreeningRelatedRequest.class, id);
	}


	
}
