package com.trustaml.dataservice.adversemedia.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustaml.dataservice.adversemedia.dao.IAdverseMediaDAO;
import com.trustaml.dataservice.adversemedia.model.AdverseMedia;
import com.trustaml.dataservice.repository.IAdverseMediaRepository;

@Service("adverseMediaService")
public class AdverseMediaServiceImpl implements IAdverseMediaService {

	@Autowired
	IAdverseMediaDAO adverseDao;

	@Autowired
	IAdverseMediaRepository adverseRepository;

	@Override
	public AdverseMedia findById(Long id) throws Exception {
		// return adverseDao.findById(id);
		return adverseRepository.findOne(id);
	}

	@Override
	public List<AdverseMedia> findAll() throws Exception {
		 return adverseDao.findAll();
//		return adverseRepository.findAll();
	}

	@Override
	public Long save(AdverseMedia media) throws Exception {
		if (media.getPersonalInfo() != null)
			media.getPersonalInfo().setAdverseMedia(media);

		if (media.getUser() != null)
			media.getUser().setAdverseMedia(media);

		media.getAdverseAddressInfo().stream().filter(Objects::nonNull).forEach(r -> r.setAdverseMedia(media));
		media.getAdverseFamilyInfo().stream().filter(Objects::nonNull).forEach(r -> r.setAdverseMedia(media));
		media.getAdverseOfficeInfo().stream().filter(Objects::nonNull).forEach(r -> r.setAdverseMedia(media));
		media.getAttachment().stream().filter(Objects::nonNull).forEach(r -> r.setAdverseMedia(media));

		return adverseDao.saveOrUpdate(media);

	}

}
