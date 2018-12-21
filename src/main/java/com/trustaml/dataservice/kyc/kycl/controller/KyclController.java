package com.trustaml.dataservice.kyc.kycl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trustaml.dataservice.exception.response.TrustAmlApiResponse;
import com.trustaml.dataservice.kyc.kycl.audit.IKyclAudit;
import com.trustaml.dataservice.kyc.kycl.model.Kycl;
import com.trustaml.dataservice.kyc.kycl.service.IKyclService;

@RestController
@RequestMapping("api/kycl")
public class KyclController {

	@Autowired 
	IKyclService kyclService;
	
	@Autowired
	IKyclAudit kyclAudit;
	
	@RequestMapping(value="/create", method= RequestMethod.POST, consumes="application/json")
	public ResponseEntity<TrustAmlApiResponse> createKycl(@RequestBody Kycl kycl) throws Exception{
		if(kycl == null){
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Invalid input"), HttpStatus.NO_CONTENT);
		}
		Long id = kyclService.save(kycl);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.CREATED,"Your kyc_id is: "+ id),HttpStatus.OK);
	}

	
	@RequestMapping(value="/update", method= RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<TrustAmlApiResponse> updateKycl(@RequestBody Kycl kycl) throws Exception{
		if(kycl == null){
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Invalid input"), HttpStatus.NO_CONTENT);
		}
		kyclService.save(kycl);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.OK),HttpStatus.OK);
	}
	
	@RequestMapping(value="/retrive/", method = RequestMethod.GET, produces ="application/json")
	public ResponseEntity<TrustAmlApiResponse> getById(@RequestParam("id") Long id) throws Exception{
		if(kyclService.findById(id) == null){
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT,"Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setKycl(kyclService.findById(id));
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="/all", method= RequestMethod.GET, produces="application/json")
	public ResponseEntity<TrustAmlApiResponse> findAll() throws Exception{
		if(kyclService.findAllKycl().isEmpty()){
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT,"Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setKyclList(kyclService.findAllKycl());
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/log/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<TrustAmlApiResponse> findLogsById(@RequestParam("id") Long id) throws Exception{
		if (kyclAudit.findAllKycl(id).isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT,"Empty"),HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setKyclList(kyclAudit.findAllKycl(id));
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/log/legal/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<TrustAmlApiResponse> findLegalLogsById(@RequestParam("id") Long id) throws Exception{
		if (kyclAudit.findPersonalLegal(id).isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"),HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setKycLegalList(kyclAudit.findPersonalLegal(id));
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}
}
