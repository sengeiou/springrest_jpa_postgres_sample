package com.trustaml.dataservice.screening.natural.service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustaml.dataservice.screening.common.ScreeningAction;
import com.trustaml.dataservice.screening.natural.dao.IScreeningNDAO;
import com.trustaml.dataservice.screening.natural.model.ScreeningNRequest;

@Service("screeningNaturalService")
public class ScreeningNaturalServiceImpl implements IScreeningNaturalService {

	@Autowired
	IScreeningNDAO screeningDao;

	@Override
	public Long save(ScreeningNRequest screeningN) {

		screeningN.getListOfRelated().stream().filter(Objects::nonNull).forEach(related -> {

			related.getScreeningNRequestData().setScreeningRelatedRequest(related);
			related.getAttachment().stream().forEach(attachment -> attachment.setScreeningNRelated(related));
			related.getScreeningNMatchInfo().stream().forEach(match -> match.setScreeningNRelated(related));

		}

		);

		screeningN.getRelatedEntityRequestData().stream().filter(Objects::nonNull).forEach(entity -> {
			String searchText = new StringBuffer(entity.getNameOfInstitution()).append(" ")
					.append(entity.getTypeOfIndustry()).toString();
			entity.setSearchText(searchText);
			entity.setScreeningNRequest(screeningN);
			entity.getMatchInfo().stream().forEach(r -> r.setRequestRelatedEntityRequestData(entity));
		});

		screeningN.getAttachment().stream().filter(Objects::nonNull).forEach(r -> r.setScreeningNRequest(screeningN));

		screeningN.getScreeningNMatchInfo().stream().filter(Objects::nonNull)
				.forEach(r -> r.setScreeningNRequest(screeningN));

		screeningN.getScreeningNAction().stream().filter(Objects::nonNull)
				.forEach(r -> r.setScreeningNRequest(screeningN));

		screeningN.getScreeningNRequestData().setScreeningNRequest(screeningN);
		return screeningDao.saveOrUpdate(screeningN);

	}

	@Override
	public ScreeningNRequest findById(Long id) {
		return screeningDao.findById(id);
	}

	@Override
	public List<ScreeningNRequest> findAll() {

		return screeningDao.findAll();
	}

	@Override
	public void screeningActionUpdate(ScreeningAction action, Long screeningId) {
		ScreeningNRequest screeningN = findById(screeningId);
		Set<ScreeningAction> actionList = new HashSet<>();
		actionList.add(action);
		screeningN.setScreeningNAction(actionList);
		save(screeningN);

	}

}
