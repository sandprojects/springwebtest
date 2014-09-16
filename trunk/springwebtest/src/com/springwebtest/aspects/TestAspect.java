package com.springwebtest.aspects;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
	public static Logger logger=Logger.getLogger(TestAspect.class.getName());
	
	HttpServletRequest request;
	HttpServletResponse respons;
	/*com.testweb.beans.testbeans getMSG printHello*/
	@Pointcut("execution(* *.printLang(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)) && args(request, respons)")
	public void pntMthd(HttpServletRequest request, HttpServletResponse respons){
		this.request=request;
		this.respons=respons;
	}
	
	@Before("pntMthd(request, respons)")
	public void beforHomeController(HttpServletRequest request, HttpServletResponse respons){
		System.out.println("===>Going for get on default url path..!");
		String lng=null;
		lng=(String)request.getParameter("language");
		if (lng!=null){
			System.out.println("====>Param Locale: "+lng);
			logger.info("Param Locale: "+lng);
		}
		Locale locale;
		locale=request.getLocale();
      
      logger.info("Request Locale: "+locale.getDisplayName());

      System.out.println("====>Request Locale: "+locale.getDisplayName());
	  logger.info("Going for get on default url path..!");
	}
	
	@After("pntMthd(request, respons)")
	public void afterHomeController(HttpServletRequest request, HttpServletResponse respons){
		System.out.println("===>Returning back from get on default url path..!");
		logger.info("Returning back from get on default url path..!");
	}
	
	@AfterReturning("pntMthd(request, respons)")
	public void successOnHomeController(HttpServletRequest request, HttpServletResponse respons){
		System.out.println("===>Successfull return back from get on default url path..!");
		logger.info("Successfull return back from get on default url path..!");
	}
	
	@AfterThrowing("pntMthd(request, respons)")
	public void exceptionHomeController(HttpServletRequest request, HttpServletResponse respons){
		logger.debug("Exception on going to get on default url path..!");
	}
}
