package com.trustaml.dataservice.str.controller;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trustaml.dataservice.exception.response.TrustAmlApiResponse;
import com.trustaml.dataservice.str.model.StrBase;
import com.trustaml.dataservice.str.service.IStrService;




@RestController
@RequestMapping("api/str")
public class StrController {

	@Autowired
	IStrService strService;
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes="application/json")
	private ResponseEntity<TrustAmlApiResponse> createHotList(@RequestBody JSONObject jsonObject) throws Exception {
		if (jsonObject == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST, "Invalid Input"),HttpStatus.BAD_REQUEST);
		}
		strService.save(jsonObject);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.CREATED),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/retrive/", method = RequestMethod.GET)
	public ResponseEntity<TrustAmlApiResponse> findById(@RequestParam("id") Long id) throws Exception{
		StrBase str = strService.findById(id);
		if (str == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"),HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setStr(str);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}

}
