package com.trustaml.dataservice.screening.natural.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.trustaml.dataservice.exception.response.TrustAmlApiResponse;
import com.trustaml.dataservice.screening.common.ScreeningAction;
import com.trustaml.dataservice.screening.natural.audit.IScreeningNaturalAudit;
import com.trustaml.dataservice.screening.natural.model.ScreeningNRequest;
import com.trustaml.dataservice.screening.natural.service.IScreeningNaturalService;

@RestController
@RequestMapping("/api/screening_n")
public class ScreeningNController {

	@Autowired
	IScreeningNaturalService screeningService;

	@Autowired
	IScreeningNaturalAudit naturalAudit;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<TrustAmlApiResponse> listAllUsers() throws Exception {

		if (screeningService.findAll().isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"),HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response  = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setScreeningNRequestList(screeningService.findAll());
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<TrustAmlApiResponse> createNatural(@RequestBody ScreeningNRequest screening)
			throws JsonMappingException, JsonParseException, JsonProcessingException {
		if(screening == null)
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST, "Invalid Input"), HttpStatus.BAD_REQUEST);
		
		Long screeningId = screeningService.save(screening);
		return new ResponseEntity<TrustAmlApiResponse>(
				new TrustAmlApiResponse(HttpStatus.CREATED, "Your screening_id is: " + screeningId), HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TrustAmlApiResponse> updateNatural(@RequestBody ScreeningNRequest screening) throws Exception {
		if(screening == null)
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST, "Invalid Input"), HttpStatus.BAD_REQUEST);
		System.out.println("jackpot");
		screeningService.save(screening);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.OK),HttpStatus.OK);
	}

	@RequestMapping(value = "/retrive/", method = RequestMethod.GET)
	public ResponseEntity<TrustAmlApiResponse> findById(@RequestParam("id") Long id) throws Exception {
		ScreeningNRequest screen = screeningService.findById(id);
		if (screen == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT,"Empty"),HttpStatus.NO_CONTENT);
		}

		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setScreeningNRequest(screen);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/log/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<TrustAmlApiResponse> findLogsById(@RequestParam("id") Long id) {
		List<ScreeningNRequest> screenList = naturalAudit.getScreeningNaturalLog(id);
		if (screenList.isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT,"Empty"),HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setScreeningNRequestList(screenList);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/action/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TrustAmlApiResponse> updateNaturalAction(@RequestBody ScreeningAction action,
			@RequestParam("id") Long screeningId) throws Exception {
		screeningService.screeningActionUpdate(action, screeningId);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.OK),HttpStatus.OK);
	}
}
