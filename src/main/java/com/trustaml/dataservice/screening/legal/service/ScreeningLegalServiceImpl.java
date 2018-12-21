package com.trustaml.dataservice.screening.legal.service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustaml.dataservice.screening.common.ScreeningAction;
import com.trustaml.dataservice.screening.legal.dao.IScreeningLDAO;
import com.trustaml.dataservice.screening.legal.model.ScreeningLRequest;

@Service("screeningLegalService")
public class ScreeningLegalServiceImpl implements IScreeningLegalService {

	@Autowired
	IScreeningLDAO screeningDao;

	@Override
	public Long save(ScreeningLRequest screening) throws Exception {
		
		screening.getListOfRelated().stream().filter(Objects::nonNull).forEach(related -> {
			
			
			related.getAttachment().stream().filter(Objects:: nonNull).forEach(r -> r.setScreeningNRelated(related));
			related.getScreeningNMatchInfo().stream().filter(Objects::nonNull).forEach(r -> r.setScreeningNRelated(related));
			
			
		});
		screening.getRelatedEntityRequestData().stream().filter(Objects::nonNull).forEach(entity ->{
			String searchText = new StringBuffer(entity.getNameOfInstitution()).append(" ")
					.append(entity.getTypeOfIndustry()).toString();
			entity.setSearchText(searchText);
			entity.setScreeningLRequest(screening);
			entity.getMatchInfo().stream().filter(Objects::nonNull).forEach(r -> r.setRequestRelatedEntityRequestData(entity));
			
		});
		screening.getScreeningLRequestData().setScreeningLRequest(screening);
		screening.getAttachment().stream().filter(Objects::nonNull).forEach(r -> r.setScreeningLRequest(screening));
		screening.getScreeningLMatchInfo().stream().filter(Objects:: nonNull).forEach(r -> r.setScreeningLRequest(screening));
		screening.getScreeningLAction().stream().filter(Objects:: nonNull).forEach(r -> r.setScreeningLRequest(screening));

	
		
		return screeningDao.saveOrUpdate(screening);

	}

	@Override
	public ScreeningLRequest findById(Long id) throws Exception {
		return screeningDao.findById(id);
	}

	@Override
	public List<ScreeningLRequest> findAll() throws Exception {
		return screeningDao.findAll();
	}

	@Override
	public void screeningActionUpdate(ScreeningAction action, Long screeningId) throws Exception {
		ScreeningLRequest screeningL = findById(screeningId);
		Set<ScreeningAction> actionList = new HashSet<>();
		actionList.add(action);
		screeningL.setScreeningLAction(actionList);
		save(screeningL);
		
	}

}
