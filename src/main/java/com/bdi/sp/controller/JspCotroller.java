package com.bdi.sp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JspCotroller {

	@RequestMapping(value="/uri/**", method = RequestMethod.GET)
	public String goPage(HttpServletRequest req) {
		String uri = req.getRequestURI();
		return uri.replace("/uri/", "");
	}
	
}
