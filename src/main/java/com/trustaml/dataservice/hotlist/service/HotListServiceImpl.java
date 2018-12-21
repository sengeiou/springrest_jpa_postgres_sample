package com.trustaml.dataservice.hotlist.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustaml.dataservice.hotlist.dao.IHotListDAO;
import com.trustaml.dataservice.hotlist.model.HotList;

@Service("hotListServiceO")
public class HotListServiceImpl implements IHotListService{
	
	@Autowired
	IHotListDAO hotListDao;

	@Override
	public HotList findById(Long id) throws Exception {
		return hotListDao.findById(id);
	}

	@Override
	public List<HotList> findAll() throws Exception {
		return hotListDao.findAll();
	}

	@Override
	public void save(HotList hotList) throws Exception {
		if(hotList.getPersonalInfo() != null)
			hotList.getPersonalInfo().setHotList(hotList);
		if(hotList.getUser() != null)
			hotList.getUser().setHotList(hotList);
		
		hotList.getAttachment().stream().filter(Objects::nonNull).forEach(r -> r.setHotList(hotList));
		hotList.getHotListAddressInfo().stream().filter(Objects::nonNull).forEach(r -> r.setHotList(hotList));
		hotList.getHotListFamilyInfos().stream().filter(Objects::nonNull).forEach(r -> r.setHotList(hotList));
		hotList.getHotListOfficeInfo().stream().filter(Objects::nonNull).forEach(r -> r.setHotList(hotList));
		hotList.getInvestigationMediaInfo().stream().filter(Objects::nonNull).forEach(r -> r.setHotList(hotList));
		
		hotListDao.saveOrUpdate(hotList);
		
	}

}
