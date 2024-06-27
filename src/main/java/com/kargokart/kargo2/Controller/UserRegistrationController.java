package com.kargokart.kargo2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kargokart.kargo2.Model.User;
import com.kargokart.kargo2.Service.UserService;
@RestController
@RequestMapping("/UserRegistrationApi")
public class UserRegistrationController {
	@Autowired
private  UserService userservice;
@GetMapping("/msg")
public String successMsg()
{	
	return userservice.registrationmsg();
}
@PostMapping("/store")
public String saveUserData(@RequestBody User userdata)
{
    User existing = userservice.findByUsername(userdata.getUsername());

    if (existing != null) {
        return userexit();
        
    }
    return userservice.saveNewUser(userdata);
}	


@GetMapping("/GetData")
public List<User> GetUserData()
{
	return userservice.getAllRecord();
	
}
//======================static method============================
private String userexit() {
	// TODO Auto-generated method stub
	String str ="There is already an account registered with that username";
	return str;
}
}
