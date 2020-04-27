package com.datastructures.maths.meanmedian.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastructures.maths.meanmedian.model.MeanMedRequest;
import com.datastructures.maths.meanmedian.model.MeanMedianResponse;
import com.datastructures.maths.meanmedian.service.MeanMedianService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/MeanMedian")
public class MeanMedianController {
	
	@Autowired
	MeanMedianService meanMedianService;
	
	@ApiOperation(value = "", notes="")
	@PostMapping("/mean")
	public ResponseEntity findMedian(HttpServletRequest req, @RequestBody MeanMedRequest req2) {
		
		
		MeanMedianResponse response = meanMedianService.findmedianmean(req2.getGivenNumbers());
		
		return new ResponseEntity(response,HttpStatus.OK);
		
		
	}

}
