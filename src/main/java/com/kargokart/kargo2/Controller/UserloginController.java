package com.kargokart.kargo2.Controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kargokart.kargo2.Model.User;
import com.kargokart.kargo2.Service.LoginService;
import com.kargokart.kargo2.Service.UserService;
import com.kargokart.kargo2.constants.ConstantsData;
@RestController
public class UserloginController {
@Autowired(required = false)
	private LoginService loginservice;
@Autowired
private  UserService userservice;

@PostMapping("/Login")
public User userLogin(@RequestBody User userdata) {
	
	User existinguser = userservice.findByUsername(userdata.getUsername());	
	String backendwd=existinguser.getPassword();
	byte[] base64DecodedBytes = Base64.getDecoder().decode(backendwd);
    String decodedString = new String(base64DecodedBytes);
  //System.out.println("  before user is exisited- and his pwd is ->"+backendwd);
	//System.out.println("  After user is exisited- and his pwd is ->"+decodedString);
  int checkpwd=  decodedString.compareTo(userdata.getPassword());
  System.out.println(" compaire string-->"+checkpwd);
	
	    if (existinguser != null && checkpwd==0) {
	    	
	    	System.out.println(ConstantsData.authenticateUser);
	    	
	    	return existinguser;
        
    }
    else {
    	System.out.println(ConstantsData.invalidUserData);
    	return null;

}
}}
