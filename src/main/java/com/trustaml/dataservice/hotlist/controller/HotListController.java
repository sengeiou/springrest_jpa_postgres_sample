package com.trustaml.dataservice.hotlist.controller;

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
import com.trustaml.dataservice.hotlist.audit.IHotListAudit;
import com.trustaml.dataservice.hotlist.model.HotList;
import com.trustaml.dataservice.hotlist.service.IHotListService;

@RestController
@RequestMapping("api/hotlist")
public class HotListController {
	@Autowired
	IHotListService hotService;
	
	@Autowired
	IHotListAudit hotListAudit;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	private ResponseEntity<TrustAmlApiResponse> createHotList(@RequestBody HotList hotList) throws Exception {
		if (hotList == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST,"Invalid input"),HttpStatus.BAD_REQUEST);
		}
		hotService.save(hotList);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.CREATED),HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	private ResponseEntity<TrustAmlApiResponse> updateHotList(@RequestBody HotList hotList) throws Exception {
		if (hotList == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.BAD_REQUEST, "Invalid input"),HttpStatus.BAD_REQUEST);
		}
		hotService.save(hotList);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.OK),HttpStatus.OK);
	}

	@RequestMapping(value = "/retrive/", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<TrustAmlApiResponse> findById(@RequestParam("id") Long id) throws Exception {

		HotList hotList = hotService.findById(id);
		if (hotList == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setHotList(hotList);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<TrustAmlApiResponse> findAll() throws Exception {

		List<HotList> hotList = hotService.findAll();
		if (hotList.isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT,"Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setHotListList(hotList);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);

	}

	
	@RequestMapping(value = "/log/", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<TrustAmlApiResponse> findLogById(@RequestParam("id") Long id) throws Exception{

		List<HotList> hotList = hotListAudit.findHotListLog(id);
		if (hotList.isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"), HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setHotListList(hotList);
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);

	}

}
