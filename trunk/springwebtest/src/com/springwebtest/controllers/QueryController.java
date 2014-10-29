package com.springwebtest.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/queries")
public class QueryController {
	@RequestMapping(value="/home", method=RequestMethod.POST)
	public String sUserLoginPst(HttpServletRequest request, ModelMap model){
		System.out.println("=======>In post sUserLoginPst..");
		return "views/jsps/queryhome.jspx";
	}
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String sUserLoginGt(HttpServletRequest request, HttpServletResponse response, ModelMap model, Principal principal){
		System.out.println("=======>In post sUserLoginGt..");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		if(principal!=null)
			System.out.println("=======>User name is: " + principal.getName());
		else
			{
				System.out.println("=======>No User..!!\n=======>Redirecting to login page...!");
				return "redirect:/userMgmt/slogin";
			}			
		return "views/jsps/queryhome.jspx";
	}
}
