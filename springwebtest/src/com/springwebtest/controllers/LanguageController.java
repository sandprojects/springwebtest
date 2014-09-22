package com.springwebtest.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
@RequestMapping("/pizza/**")
public class LanguageController {
	@RequestMapping(method=RequestMethod.GET, params="language")
	public String changeLanguage(HttpServletRequest request, HttpServletResponse respons){
		System.out.println("=======>In language changer...");
		HttpSession sess;
	      Locale locale;
	      String lng=(String)request.getParameter("language");
	      locale=request.getLocale();
	      if (lng==null){
	    	  lng = locale.getLanguage() + "_" + locale.getCountry();
	      }
	      System.out.println("====>Param Locale: "+lng);
	      System.out.println("====>Request Locale: "+locale.getDisplayName());
	      sess=request.getSession();
	      sess.setAttribute("language", lng);
		return "redirect:/pizza/";
	} 
}
