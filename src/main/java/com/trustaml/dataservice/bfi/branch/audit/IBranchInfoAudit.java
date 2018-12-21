package com.trustaml.dataservice.bfi.branch.audit;

import java.util.List;

import com.trustaml.dataservice.bfi.branch.model.DetailBranchInfo;

public interface IBranchInfoAudit {

	public List<DetailBranchInfo> findBranchInfoById(Long id) throws Exception;

}
