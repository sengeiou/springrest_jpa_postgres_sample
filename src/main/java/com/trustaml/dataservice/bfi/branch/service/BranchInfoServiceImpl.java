package com.trustaml.dataservice.bfi.branch.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustaml.dataservice.bfi.branch.dao.IDetailBranchInfoDAO;
import com.trustaml.dataservice.bfi.branch.model.DetailBranchInfo;

@Service("branchInfoService")
public class BranchInfoServiceImpl implements IBranchInfoService{
	
	@Autowired
	IDetailBranchInfoDAO branchDao;

	@Override
	public DetailBranchInfo findById(Long id) throws Exception {
		return branchDao.findById(id);
	}

	@Override
	public List<DetailBranchInfo> findAllBranchInfo() throws Exception {
		return branchDao.findAllBranchInfo();
	}

	@Override
	public void save(DetailBranchInfo branchInfo) throws Exception {
		if(branchInfo.getBranchInfo() != null)
			branchInfo.getBranchInfo().setDetailBranchInfo(branchInfo);
		
		branchInfo.getListAddress().stream().filter(Objects::nonNull).forEach(r -> r.setDetailBranchInfo(branchInfo));
		branchInfo.getListContact().stream().filter(Objects::nonNull).forEach(r -> r.setDetailBranchInfo(branchInfo));
		branchInfo.getListEmail().stream().filter(Objects::nonNull).forEach(r -> r.setDetailBranchInfo(branchInfo));
		
		branchDao.saveOrUpdate(branchInfo);
		
	}

}
