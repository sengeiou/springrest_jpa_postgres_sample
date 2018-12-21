package com.trustaml.dataservice.investigation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trustaml.dataservice.exception.response.TrustAmlApiResponse;
import com.trustaml.dataservice.investigation.audit.IInvestigationAudit;
import com.trustaml.dataservice.investigation.model.Investigation;
import com.trustaml.dataservice.investigation.service.IInvestigationService;

@RestController
@RequestMapping("api/investigation")
public class InvestigationController {

	@Autowired
	IInvestigationService investigationService;
	
	@Autowired
	IInvestigationAudit investigationAudit;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	private ResponseEntity<TrustAmlApiResponse> createInvestigation(@RequestBody Investigation investigation) throws Exception {
		if (investigation == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST,"Invalid Input"),HttpStatus.BAD_REQUEST);
		}
		investigationService.save(investigation);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.CREATED),HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	private ResponseEntity<TrustAmlApiResponse> updateInvestigation(@RequestBody Investigation investigation) throws Exception {
		if (investigation == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST,"Invalid Input"),HttpStatus.BAD_REQUEST);
		}
		investigationService.save(investigation);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.OK),HttpStatus.OK);
	}

	@RequestMapping(value = "/retrive/", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<TrustAmlApiResponse> findById(@RequestParam("id") Long id) throws Exception {

		Investigation investigation = investigationService.findById(id);
		if (investigation == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setInvestigation(investigation);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<TrustAmlApiResponse> findAll() throws Exception {

		List<Investigation> investigation = investigationService.findAll();
		if (investigation.isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response=  new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setInvestigationList(investigation);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);

	}

	
	@RequestMapping(value = "/log/", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<TrustAmlApiResponse> findLogById(@RequestParam("id") Long id) throws Exception{

		List<Investigation> investigation = investigationAudit.findAllLogs(id);
		if (investigation.isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setInvestigationList(investigation);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);

	}
}
