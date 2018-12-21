package com.trustaml.dataservice.pepentry.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustaml.dataservice.pepentry.dao.IPepentryDAO;
import com.trustaml.dataservice.pepentry.model.Pepentry;

@Service("pepentryService")
public class PepentryServiceImpl implements IPepentryService{
	
	@Autowired
	IPepentryDAO pepentryDao;

	@Override
	public Pepentry findById(Long id) throws Exception {
		return pepentryDao.findById(id);
	}

	@Override
	public List<Pepentry> findAll() throws Exception {
		return pepentryDao.findAll();
	}

	@Override
	public void save(Pepentry pepentry) throws Exception {
		if(pepentry.getPersonalInfo() != null)
			pepentry.getPersonalInfo().setPepentry(pepentry);
		
		pepentry.getAttachment().stream().filter(Objects::nonNull).forEach(r -> r.setPepentry(pepentry));
		pepentry.getPepentryAddressInfo().stream().filter(Objects::nonNull).forEach(r -> r.setPepentry(pepentry));
		pepentry.getPepentryFamilyInfos().stream().filter(Objects::nonNull).forEach(r -> r.setPepentry(pepentry));
		pepentry.getPepentryOfficeInfo().stream().filter(Objects::nonNull).forEach(r -> r.setPepentry(pepentry));
		
		pepentryDao.saveOrUpdate(pepentry);
		
	}

}
