package com.trustaml.dataservice.bfi.branch.dao;

import java.util.List;

import com.trustaml.dataservice.bfi.branch.model.DetailBranchInfo;

public interface IDetailBranchInfoDAO {
	

	public DetailBranchInfo findById(Long id);
	public List<DetailBranchInfo> findAllBranchInfo();
	public void saveOrUpdate(DetailBranchInfo branchInfo);
}
