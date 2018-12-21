package com.trustaml.dataservice.screening.natural.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trustaml.dataservice.screening.natural.dao.IScreeningRelatedPersonDAO;
import com.trustaml.dataservice.screening.natural.model.ScreeningRelatedRequest;

@RestController
@RequestMapping("api/screening_n/related")
public class ScreeningNRelatedController {
	
	@Autowired 
	IScreeningRelatedPersonDAO relatedDao;
	
	
	@RequestMapping(value= "/retrive/", method = RequestMethod.GET)
	public ResponseEntity<ScreeningRelatedRequest> findRelated(@RequestParam("id") Long id){
		
		
		ScreeningRelatedRequest screeningRelated = relatedDao.findById(id);
		
		//for bidirectional
//		for(ScreeningNRequest n: screeningRelated.getListOfNaturalRequest()){
//			n.setListOfRelated(null);
//		}
		
		if(screeningRelated == null){
			return new ResponseEntity<ScreeningRelatedRequest>(screeningRelated, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ScreeningRelatedRequest>(screeningRelated, HttpStatus.OK);
		
	}
//	
//	@RequestMapping(value= "/request/", method = RequestMethod.GET)
//	public ResponseEntity<ScreeningNRequest> findRelatedRequest(@RequestParam("id") Long id){
//		
//		
//		ScreeningNRequest screeningRelated = relatedDao.findRequestById(id);
//		
//		if(screeningRelated == null){
//			return new ResponseEntity<ScreeningNRequest>(screeningRelated, HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<ScreeningNRequest>(screeningRelated, HttpStatus.OK);
//		
//	}

}
