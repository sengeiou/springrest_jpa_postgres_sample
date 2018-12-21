package com.trustaml.dataservice.bfi.branch.service;

import java.util.List;

import com.trustaml.dataservice.bfi.branch.model.DetailBranchInfo;

public interface IBranchInfoService {

	public DetailBranchInfo findById(Long id) throws Exception;
	public List<DetailBranchInfo> findAllBranchInfo() throws Exception;
	public void save(DetailBranchInfo branchInfo) throws Exception;
}
