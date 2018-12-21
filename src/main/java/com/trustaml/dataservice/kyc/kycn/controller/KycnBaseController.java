package com.trustaml.dataservice.kyc.kycn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trustaml.dataservice.exception.response.TrustAmlApiResponse;
import com.trustaml.dataservice.kyc.kycn.audit.IKycnBaseAudit;
import com.trustaml.dataservice.kyc.kycn.model.KycnBase;
import com.trustaml.dataservice.kyc.kycn.service.IKycnService;

@RestController
@RequestMapping("/api/kycn")
public class KycnBaseController {
	
	@Autowired
	IKycnService kycnService;
	
	@Autowired
	IKycnBaseAudit kycnAudit;
	
	@RequestMapping(value="/create", method= RequestMethod.POST, consumes="application/json")
	public ResponseEntity<TrustAmlApiResponse> createKycn(@RequestBody KycnBase kycnBase) throws Exception{
		if(kycnBase == null)
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST,"Invalid Input"), HttpStatus.BAD_REQUEST);

		Long kycnId = kycnService.save(kycnBase);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.CREATED,"Your kyc_id is: "+kycnId),HttpStatus.OK);
	}

	
	@RequestMapping(value="/update", method= RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<TrustAmlApiResponse> updateKycn(@RequestBody KycnBase kycnBase)throws Exception{
		
		if(kycnBase == null)
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST,"Invalid Input"), HttpStatus.BAD_REQUEST);

		kycnService.save(kycnBase);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.OK), HttpStatus.OK);
	}
	
	@RequestMapping(value="/retrive/", method = RequestMethod.GET, produces ="application/json")
	public ResponseEntity<TrustAmlApiResponse> getById(@RequestParam("id") Long id)throws Exception{
		
		if(kycnService.findById(id) == null){
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setKycn(kycnService.findById(id));
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="/all", method= RequestMethod.GET, produces="application/json")
	public ResponseEntity<TrustAmlApiResponse> findAll() throws Exception{
		
		if( kycnService.findAllKycn().isEmpty()){
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setKycnList(kycnService.findAllKycn());
		return new ResponseEntity<TrustAmlApiResponse>( response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/log/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<TrustAmlApiResponse> findLogsById(@RequestParam("id") Long id) {
		if (kycnAudit.findAllKycn(id).isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT,"Empty"),HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setKycnList(kycnAudit.findAllKycn(id));
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}
}
