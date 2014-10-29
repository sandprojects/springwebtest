package com.springwebtest.controllers;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springwebtest.beans.pizza.domain.ImageUploadException;
import com.springwebtest.beans.testbeans.User;
import com.springwebtest.beans.testbeans.UserLogin;

	@Component
	@RequestMapping("/userMgmt")
	public class UserMgmtController {
	
	@Resource(name = "messageSource")
    private MessageSource messageSource;
		
	@RequestMapping(value="/slogout", method=RequestMethod.GET)
	public String sUserLogOut(){
		return "views/jsps/login.jspx";
	}
	@RequestMapping(value="/slogin", method=RequestMethod.GET)
	public String sUserLoginGet(HttpServletRequest request, @RequestParam(value="login_error", required=false) String login_error, ModelMap model){
		Locale locale = LocaleContextHolder.getLocale();
		if((String)request.getParameter("login_error")!=null){
			System.out.println("=======>In SLogin has error..");
			model.put("loginError", messageSource.getMessage("message.loginForm.invalidCredentialValidation", null, locale));
		}
		System.out.println("=======>In SLogin..");
		return "views/jsps/logins.jspx";
	}

//	@RequestMapping(value="/slogin", method=RequestMethod.POST)//
//	public String sUserLoginPost(HttpServletRequest request, @Valid UserLogin ulog, BindingResult bindingResult){
//		boolean vld = false;
//		if(bindingResult.hasErrors()){
//            System.out.println("=======>In post error..");
//	          return "views/jsps/logins.jspx";
//	       }
//		else if (!bindingResult.hasErrors() && !vld){
//			//bindingResult.rejectValue("username", "message.loginForm.invalidCredentialValidation", "Please enter valid login details");
//			//ObjectError error = new ObjectError("vlds","message.loginForm.invalidCredentialValidation");
//			//bindingResult.addError(error);
//			bindingResult.rejectValue("password", "message.loginForm.invalidCredentialValidation", "Please enter valid login details");
//		} 
//			return "views/jsps/logins.jspx";
//	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String userLoginGet(Model model){
		model.addAttribute(new UserLogin());
		return "views/jsps/login.jspx";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)//
	public String userLoginPost(HttpServletRequest request, @Valid UserLogin ulog, BindingResult bindingResult){
		boolean vld = false;
		if(bindingResult.hasErrors()){
            System.out.println("=======>In post error..");
	          return "views/jsps/login.jspx";
	       }
		else if (!bindingResult.hasErrors() && !vld){
			//bindingResult.rejectValue("username", "message.loginForm.invalidCredentialValidation", "Please enter valid login details");
			//ObjectError error = new ObjectError("vlds","message.loginForm.invalidCredentialValidation");
			//bindingResult.addError(error);
			bindingResult.rejectValue("password", "message.loginForm.invalidCredentialValidation", "Please enter valid login details");
		} 
			return "views/jsps/login.jspx";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.GET)
	   public String addNewUser(Model model){
		   model.addAttribute(new User());
		   System.out.println("=======>Got request...!!!!");
		   System.out.println("home :: " + System.getProperty("user.home"));
	       System.out.println("dir :: " + System.getProperty("user.dir"));
		   return "views/jsps/userRegistration.jspx";
	   }
	
	   @RequestMapping(value="/addUser", method=RequestMethod.POST)
	   public String addUserForm(HttpServletRequest request, @Valid User user, BindingResult bindingResult, @RequestParam(value="image",required=false) MultipartFile image){
		   System.out.println("=======>In post..");
		   System.out.println("webroot=======>" + request.getServletContext().getRealPath("/"));
	       if(bindingResult.hasErrors()){
              System.out.println("=======>In post error..");
	          return "views/jsps/userRegistration.jspx";
	       }
	       try {
	    	   if(!image.isEmpty()){
	    		   validateImage(image);
	    		   String fileName = "image_" + System.currentTimeMillis();
	    		   System.out.println("fileName===>"+fileName);
	    		   saveImage(fileName+".jpg",image);//
    	   }
    	   } catch(ImageUploadException e){
		    	   bindingResult.reject(e.getMessage());
		    	   return "views/jsps/userRegistration.jspx";
	       }
	       System.out.println("=======>In post success..");
	       return "redirect:/hello/";
	   }
	   private void validateImage(MultipartFile image) throws ImageUploadException{
		   if(!image.getContentType().equals("image/jpeg")){
			   throw new ImageUploadException("Only JPG images accepted");
		   	}
	   }
	   private void saveImage(String filename, MultipartFile image) throws ImageUploadException{
	   try {
		   File file=new File(System.getProperty("user.home")+"/resources/"+filename);
		   FileUtils.writeByteArrayToFile(file,image.getBytes());
	   	} catch(IOException e){
		   		throw new ImageUploadException("Unable to save image");
	   		}
	   }
}
