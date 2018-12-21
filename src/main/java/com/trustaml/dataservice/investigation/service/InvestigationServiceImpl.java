package com.trustaml.dataservice.investigation.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustaml.dataservice.investigation.dao.IInvestigationDAO;
import com.trustaml.dataservice.investigation.model.Investigation;

@Service("investigationService")
public class InvestigationServiceImpl implements IInvestigationService{
	@Autowired
	IInvestigationDAO investigationDao;

	@Override
	public Investigation findById(Long id) throws Exception {
		return investigationDao.findById(id);
	}

	@Override
	public List<Investigation> findAll() throws Exception {
		return investigationDao.findAll();
	}

	@Override
	public void save(Investigation investigation) throws Exception {
	 if(investigation.getPersonalInfo() != null)	 
		 investigation.getPersonalInfo().setInvestigation(investigation);
	 
	 investigation.getAddressInfo().stream().filter(Objects::nonNull).forEach(r -> r.setInvestigation(investigation));
	 investigation.getFamilyInfo().stream().filter(Objects::nonNull).forEach(r -> r.setInvestigation(investigation));
	 investigation.getInvestigationMediaInfo().stream().filter(Objects::nonNull).forEach(r -> r.setInvestigation(investigation));
	 investigation.getOfficeInfo().stream().filter(Objects::nonNull).forEach(r -> r.setInvestigation(investigation));
	 
	investigationDao.saveOrUpdate(investigation);
		
	}

}
