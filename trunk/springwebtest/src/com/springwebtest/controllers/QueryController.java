package com.springwebtest.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springwebtest.beans.testbeans.City;
import com.springwebtest.beans.testbeans.CityService;

@Controller
@RequestMapping("/queries")
public class QueryController {
	
	public List<City> cit;
	CityService cS;
	ApplicationContext ac;
	
	@RequestMapping(value="/home", method=RequestMethod.POST)
	public String sUserLoginPst(HttpServletRequest request, ModelMap model){
		System.out.println("=======>In post sUserLoginPst..");
		String optStr = request.getParameter("selCity");
		System.out.println("=======>optStr: " + optStr);
		ac=new ClassPathXmlApplicationContext("com/springwebtest/configurations/testbeans-config.xml");
		cS=(CityService)ac.getBean("cityService");
		cit=cS.getCties();
		model.addAttribute("selSelct", optStr);
		model.addAttribute("selopt", cS.getSeloption());//cties
		//cit.retainAll(new List<City>().add((City)ac.getBean(optStr.toLowerCase())))
		model.addAttribute("cties", cit);//cties
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
		//model.addAttribute("seloption", CityService.getSeloption());
		ac=new ClassPathXmlApplicationContext("com/springwebtest/configurations/testbeans-config.xml");
		cS=(CityService)ac.getBean("cityService");
		cit=cS.getCties();
		
		if(cit==null){
			System.out.println("=======>cit is blank...");
		}
		else
		{
			System.out.println("=======>cit is not blank...");
			/*Iterator it=cit.iterator();
			for(City curCity:it){
				
			}*/
		}
		model.addAttribute("selopt", cS.getSeloption());//cties
		model.addAttribute("cties", cit);//cties
		return "views/jsps/queryhome.jspx";
	}
}
