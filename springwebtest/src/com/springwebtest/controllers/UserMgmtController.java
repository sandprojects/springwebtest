package com.springwebtest.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springwebtest.beans.testbeans.User;

@Component
@RequestMapping("/userMgmt")
public class UserMgmtController {
	
	@RequestMapping(value="/addUser", method=RequestMethod.GET)
	   public String addNewUser(Model model){
		   model.addAttribute(new User());
		   System.out.println("=======>Got request...!!!!");
		   return "views/jsps/userRegistration.jspx";
	   }
	
	   @RequestMapping(value="/addUser", method=RequestMethod.POST)
	   public String addUserForm(@Valid User user, BindingResult bindingResult, @RequestParam(value="image",required=false) MultipartFile image){
		   System.out.println("=======>In post..");
	       if(bindingResult.hasErrors()){
              System.out.println("=======>In post error..");
	          return "views/jsps/userRegistration.jspx";
	       }
	       System.out.println("=======>In post success..");
	       return "redirect:/hello/";
	   }
}
