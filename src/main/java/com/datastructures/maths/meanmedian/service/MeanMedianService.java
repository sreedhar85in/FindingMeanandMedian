package com.datastructures.maths.meanmedian.service;

import org.springframework.stereotype.Service;

import com.datastructures.maths.meanmedian.model.MeanMedianResponse;

@Service
public class MeanMedianService {
	
	
	public MeanMedianResponse findmedianmean(int[] givenNumbers) {
		
		int lengthofgivenarray = givenNumbers.length;
		int sum = 0;
		
		for(int i = 0; i<lengthofgivenarray;i++) {
			
			sum = sum + givenNumbers[i];
			
		}
		
		int mean = sum/lengthofgivenarray;
		
		
		MeanMedianResponse response = new MeanMedianResponse();
		response.setOutcomeCode(200);
		response.setOutcomeMessage("Success");
		response.setMean(mean);
		return response;
	}
	
	public String findmedian(int[] givenNumbers) {
		
		int lengthofgivenarray = givenNumbers.length;
		
		//length
		
		
		
		return null;
		
	}
	
	
	

}
