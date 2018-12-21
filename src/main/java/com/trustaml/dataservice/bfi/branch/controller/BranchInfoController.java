package com.trustaml.dataservice.bfi.branch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trustaml.dataservice.bfi.branch.audit.IBranchInfoAudit;
import com.trustaml.dataservice.bfi.branch.model.DetailBranchInfo;
import com.trustaml.dataservice.bfi.branch.service.IBranchInfoService;
import com.trustaml.dataservice.exception.response.TrustAmlApiResponse;

@RestController
@RequestMapping("api/branch_info")
public class BranchInfoController {
	
	@Autowired
	IBranchInfoService branchInfoService;
	
	@Autowired
	IBranchInfoAudit branchInfoAudit;
	
	@RequestMapping(value="/create", method= RequestMethod.POST, consumes="application/json")
	public ResponseEntity<TrustAmlApiResponse> createBranchInfo(@RequestBody DetailBranchInfo info) throws Exception{
		if(info == null)
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST, "Invalid Input"), HttpStatus.BAD_REQUEST);
		branchInfoService.save(info);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.CREATED),HttpStatus.OK);
	}

	
	@RequestMapping(value="/update", method= RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<TrustAmlApiResponse> updateBranchInfo(@RequestBody DetailBranchInfo info) throws Exception{
		if(info == null)
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST, "Invalid Input"), HttpStatus.BAD_REQUEST);
		branchInfoService.save(info);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.OK),HttpStatus.OK);
	}
	
	@RequestMapping(value="/retrive/", method = RequestMethod.GET, produces ="application/json")
	public ResponseEntity<TrustAmlApiResponse> getById(@RequestParam("id") Long id) throws Exception{
		
		DetailBranchInfo branchInfo = branchInfoService.findById(id);
		if(branchInfo == null){
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT,"Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setDetailBranchInfo(branchInfo);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="/all", method= RequestMethod.GET, produces="application/json")
	public ResponseEntity<TrustAmlApiResponse> findAll() throws Exception{
		List<DetailBranchInfo> branchList = branchInfoService.findAllBranchInfo();
		if(branchList.isEmpty()){
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setDetailBranchInfoList(branchList);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="/log/", method = RequestMethod.GET, produces ="application/json")
	public ResponseEntity<TrustAmlApiResponse> getDetailLogById(@RequestParam("id") Long id) throws Exception{
		
		List<DetailBranchInfo> branchInfo = branchInfoAudit.findBranchInfoById(id);
		if(branchInfo == null){
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response= new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setDetailBranchInfoList(branchInfo);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}

}
