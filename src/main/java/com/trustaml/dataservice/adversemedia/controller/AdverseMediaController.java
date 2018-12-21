package com.trustaml.dataservice.adversemedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trustaml.dataservice.adversemedia.audit.IAdverseMediaAudit;
import com.trustaml.dataservice.adversemedia.model.AdverseMedia;
import com.trustaml.dataservice.adversemedia.service.IAdverseMediaService;
import com.trustaml.dataservice.exception.response.TrustAmlApiResponse;

@RestController
@RequestMapping("api/adverse_media")
public class AdverseMediaController {

	@Autowired
	IAdverseMediaService adverseService;

	@Autowired
	IAdverseMediaAudit mediaAudit;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<TrustAmlApiResponse> createAdverse(@RequestBody AdverseMedia media) throws Exception {
		if (media == null) {

			return new ResponseEntity<TrustAmlApiResponse>(HttpStatus.BAD_REQUEST);
		} else {
			Long mediaId = adverseService.save(media);
			return new ResponseEntity<TrustAmlApiResponse>(
					new TrustAmlApiResponse(HttpStatus.CREATED, "Your adverseId is " + mediaId), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<TrustAmlApiResponse> updateAdverse(@RequestBody AdverseMedia media) throws Exception {

		adverseService.save(media);
		return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@RequestMapping(value = "/retrive/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<TrustAmlApiResponse> getById(@RequestParam("id") Long id) throws Exception {

		if (adverseService.findById(id) == null) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"),
					HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setAdverseMedia(adverseService.findById(id));
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<TrustAmlApiResponse> findAll() throws Exception {

		if (adverseService.findAll().isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "No Data"),
					HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setAdverseMediaList(adverseService.findAll());
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/log/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<TrustAmlApiResponse> findLogsById(@RequestParam("id") Long id) throws Exception {
		if (mediaAudit.mediaList(id).isEmpty()) {
			return new ResponseEntity<TrustAmlApiResponse>(new TrustAmlApiResponse(HttpStatus.NO_CONTENT, "Empty"),
					HttpStatus.NO_CONTENT);
		}
		TrustAmlApiResponse response = new TrustAmlApiResponse(HttpStatus.FOUND);
		response.setAdverseMediaList(mediaAudit.mediaList(id));
		return new ResponseEntity<TrustAmlApiResponse>(response, HttpStatus.OK);
	}

}
