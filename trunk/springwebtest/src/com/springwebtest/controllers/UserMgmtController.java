package com.springwebtest.controllers;

import java.io.File;
import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
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
	@RequestMapping(value="/slogout", method=RequestMethod.GET)
	public String sUserLogOut(){
		return "views/jsps/login.jspx";
	}
	@RequestMapping(value="/slogin", method=RequestMethod.GET)
	public String sUserLoginGet(@RequestParam(value="login_error", required=false) String login_error, ModelMap model){
		//model.addAttribute(new UserLogin());
		/*if (login_error == "t") {
			// Assign an error message
			model.put("login_error", "You have entered an invalid username or password!");
		} else {
			model.put("login_error", "");
		}*/
		System.out.println("=======>In SLogin..");
		return "views/jsps/logins.jspx";
	}
	@RequestMapping(value="/mylogin", method=RequestMethod.POST)
	public String sUserLoginPst(HttpServletRequest request, ModelMap model){
		System.out.println("=======>In post sUserLoginPst..");
		return "views/jsps/queryhome.jspx";
	}
	@RequestMapping(value="/mylogin", method=RequestMethod.GET)
	public String sUserLoginGt(HttpServletRequest request, HttpServletResponse response, ModelMap model, Principal principal){
		System.out.println("=======>In post sUserLoginGt..");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		//HttpSession hs=request.getSession(false);
		if(principal!=null)
			System.out.println("=======>User name is: " + principal.getName());
		else
			{
				System.out.println("=======>No User..!!\n=======>Redirecting to login page...!");
				return "redirect:/userMgmt/slogin";
			}			
		return "views/jsps/queryhome.jspx";
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
