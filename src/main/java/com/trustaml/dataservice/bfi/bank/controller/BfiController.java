package com.trustaml.dataservice.bfi.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trustaml.dataservice.bfi.bank.audit.IBfiAudit;
import com.trustaml.dataservice.bfi.bank.model.Bfi;
import com.trustaml.dataservice.bfi.bank.service.IBfiService;
import com.trustaml.dataservice.exception.response.TrustAmlApiResponse;

@RestController
@RequestMapping("api/bfi")
public class BfiController {

	@Autowired
	IBfiService bfisService;
	
	@Autowired
	IBfiAudit bfiAudit;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	private ResponseEntity<TrustAmlApiResponse> createBfi(@RequestBody Bfi bfi) throws Exception {
		if (bfi == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST, "Invalid input"),HttpStatus.BAD_REQUEST);
		}
		bfisService.saveOrUpdate(bfi);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.CREATED), HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	private ResponseEntity<TrustAmlApiResponse> updateBfi(@RequestBody Bfi bfi) throws Exception {
		if (bfi == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST,"Error while updating"),HttpStatus.BAD_REQUEST);
		}
		bfisService.saveOrUpdate(bfi);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.OK),HttpStatus.OK);
	}

	@RequestMapping(value = "/retrive/", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<TrustAmlApiResponse> findById(@RequestParam("id") Long id) throws Exception {

		Bfi bfi = bfisService.findById(id);
		if (bfi == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT,"Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setBfi(bfi);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<TrustAmlApiResponse> findAll() throws Exception {

		List<Bfi> bfi = bfisService.findAll();
		if (bfi.isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setBfiList(bfi);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);

	}

	
	@RequestMapping(value = "/log/", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<TrustAmlApiResponse> findLogById(@RequestParam("id") Long id) throws Exception{

		List<Bfi> bfi = bfiAudit.findBfiLog(id);
		if (bfi.isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT,"Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setBfiList(bfi);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);

	}
}
