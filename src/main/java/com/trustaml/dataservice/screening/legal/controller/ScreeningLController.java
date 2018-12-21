package com.trustaml.dataservice.screening.legal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trustaml.dataservice.exception.response.TrustAmlApiResponse;
import com.trustaml.dataservice.screening.common.ScreeningAction;
import com.trustaml.dataservice.screening.legal.audit.IScreeningLegalAudit;
import com.trustaml.dataservice.screening.legal.model.ScreeningLRequest;
import com.trustaml.dataservice.screening.legal.service.IScreeningLegalService;

@RestController
@RequestMapping("/api/screening_l")
public class ScreeningLController {

	@Autowired
	IScreeningLegalService screeningService;

	@Autowired
	IScreeningLegalAudit legalAudit;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<TrustAmlApiResponse> listAllUsers() throws Exception{

		if (screeningService.findAll().isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"),HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setScreeningLRequestList(screeningService.findAll());
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<TrustAmlApiResponse> createLegal(@RequestBody ScreeningLRequest screening) throws Exception{
		if(screening == null)
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST, "Invalid input"), HttpStatus.BAD_REQUEST);
		Long screeningId = screeningService.save(screening);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.CREATED,"Your screening_id is: "+ screeningId),HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<TrustAmlApiResponse> updateLegal(@RequestBody ScreeningLRequest screening) throws Exception{
		if(screening == null)
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST, "Invalid input"), HttpStatus.BAD_REQUEST);
		screeningService.save(screening);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.OK),HttpStatus.OK);
	}

	@RequestMapping(value = "/retrive/", method = RequestMethod.GET)
	public ResponseEntity<TrustAmlApiResponse> findById(@RequestParam("id") Long id) throws Exception{
		ScreeningLRequest screen = screeningService.findById(id);
		if (screen == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"),HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setScreeningLRequest(screen);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/log/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<TrustAmlApiResponse> findLogsById(@RequestParam("id") Long id) throws Exception {

		if (legalAudit.findLegalById(id).isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"),HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setScreeningLRequestList(legalAudit.findLegalById(id));
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/action/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TrustAmlApiResponse> updateNaturalAction(@RequestBody ScreeningAction action,
			@RequestParam("id") Long screeningId) throws Exception {
		screeningService.screeningActionUpdate(action, screeningId);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.OK),HttpStatus.OK);
	}
}
