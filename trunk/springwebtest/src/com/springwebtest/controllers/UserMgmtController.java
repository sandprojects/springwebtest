package com.springwebtest.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springwebtest.beans.pizza.domain.ImageUploadException;
import com.springwebtest.beans.testbeans.User;

@Component
@RequestMapping("/userMgmt")
public class UserMgmtController {
	
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
