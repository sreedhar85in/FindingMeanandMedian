package com.datastructures.maths.meanmedian.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class JWTFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		log.debug("Initiating filter");
		
		String path = request.getServletPath();
		
		if(path.contains("swagger")||path.contains("docs")) {
			
			log.debug("swagger page detected hence bypassing the filter, path is " + " "+ path);
			filterChain.doFilter(request, response);
		}
		
		else {
			
			log.debug("Implement the filter logic to verify the access token");
			filterChain.doFilter(request, response);
		}
		
	}
	
	

}
