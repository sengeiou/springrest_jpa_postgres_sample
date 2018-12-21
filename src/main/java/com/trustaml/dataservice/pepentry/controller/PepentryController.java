package com.trustaml.dataservice.pepentry.controller;

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
import com.trustaml.dataservice.pepentry.audit.IPepentryAudit;
import com.trustaml.dataservice.pepentry.model.Pepentry;
import com.trustaml.dataservice.pepentry.service.IPepentryService;

@RestController
@RequestMapping("api/pepentry")
public class PepentryController {
	@Autowired
	IPepentryService pepentryService;
	
	@Autowired
	IPepentryAudit pepentryAudit;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	private ResponseEntity<TrustAmlApiResponse> createPepentry(@RequestBody Pepentry pepentry) throws Exception {
		if (pepentry == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST,"Invalid Input"),HttpStatus.BAD_REQUEST);
		}
		pepentryService.save(pepentry);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.CREATED),HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	private ResponseEntity<TrustAmlApiResponse> updatePepentry(@RequestBody Pepentry pepentry) throws Exception {
		if (pepentry == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST,"Invalid Input"),HttpStatus.BAD_REQUEST);
		}
		pepentryService.save(pepentry);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.OK),HttpStatus.OK);
	}

	@RequestMapping(value = "/retrive/", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<TrustAmlApiResponse> findById(@RequestParam("id") Long id) throws Exception {

		Pepentry pepentry = pepentryService.findById(id);
		if (pepentry == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setPepentry(pepentry);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<TrustAmlApiResponse> findAll() throws Exception {

		List<Pepentry> pepentry = pepentryService.findAll();
		if (pepentry.isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setPepentryList(pepentry);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);

	}

	
	@RequestMapping(value = "/log/", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<TrustAmlApiResponse> findLogById(@RequestParam("id") Long id) throws Exception{

		List<Pepentry> pepentry = pepentryAudit.findPepentryLog(id);
		if (pepentry.isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT,"Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setPepentryList(pepentry);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);

	}

}
