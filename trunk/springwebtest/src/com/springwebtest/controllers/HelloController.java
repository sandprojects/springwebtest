package com.springwebtest.controllers;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

import com.springwebtest.beans.testbeans.TestMSG;

@Controller
@RequestMapping("/")
public class HelloController{
	public static Logger logger=Logger.getLogger(HelloController.class.getName());
	
	public TestMSG testMSG;
	
	@Inject
	public HelloController(TestMSG testMSG){
		this.testMSG=testMSG;
	}
	
   @RequestMapping(/* value="/hello", */method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      logger.debug("HelloController saying: Initiating model packing...!");
	  //model.addAttribute("message", "Hello Spring MVC Framework!");
	  model.addAttribute("message", this.testMSG.getMSG());
	  logger.info("HelloController saying: Packing of model completed...!");
	  return "hello";
   }
   
   @RequestMapping(value="/index", method = RequestMethod.GET)
   public String printLang(HttpServletRequest request, HttpServletResponse respons) {
//      HttpSession sess;
//      Locale locale;
      ModelMap model = new ModelMap();
      model.addAttribute("message", "Index Message - Hello Spring MVC Framework!");
//      printHello(model);
//      String lng=(String)request.getParameter("language");
//      locale=request.getLocale();
//      logger.info("Param Locale: "+lng);
//      logger.info("Request Locale: "+locale.getDisplayName());
//      System.out.println("====>Param Locale: "+lng);
//      System.out.println("====>Request Locale: "+locale.getDisplayName());
//      sess=request.getSession();
//      sess.setAttribute("language", lng);
      return "index";
   }
   
   @RequestMapping(value="/error")
   public void exceptionTestMethod() throws Exception{
		throw new Exception("Test Exception..!");
   }
   
   @ExceptionHandler(Exception.class)
   public String genEx(Exception ex){
	   return "errorpages/errorgen";
   }
   
}