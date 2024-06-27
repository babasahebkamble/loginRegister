package com.kargokart.kargo2.Serviceiml;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kargokart.kargo2.Model.User;
import com.kargokart.kargo2.Repository.UserRepository;
import com.kargokart.kargo2.Service.UserService;
@Service
public class UserserviceImpl implements UserService {
@Autowired
private UserRepository userrepository;


//============================================
	@Override
	public String registrationmsg() {
		// TODO Auto-generated method stub
		String SuccessMsg="USER REGISTRED SUCESSFULY";
		return SuccessMsg;
	}

	@Override
	public String saveNewUser(User userdata) {
		// TODO Auto-generated method stub
        User user = new User();
        user.setUsername(userdata.getUsername());
        //display the user pwd
        String pwd=userdata.getPassword();
        //encode the pwd
        String encodedpwd = Base64.getEncoder().encodeToString(pwd.getBytes());
        System.out.println("Encode data is----->"+encodedpwd);
      //decode the pwd
        byte[] base64DecodedBytes = Base64.getDecoder().decode(encodedpwd);
        String decodedString = new String(base64DecodedBytes);
       // System.out.println( "after decode "+decodedString);        
        user.setPassword(encodedpwd);
        user.setEmail(userdata.getEmail());
        user.setUserRole("NEW USER");
        user.setUserStatus("NOT APPROVED");       
       
       userrepository.save(user);
       return sucessfull();

	}
private String sucessfull() {
		// TODO Auto-generated method stub
	String SuccessMsg="USER REGISTRED SUCESSFULY";
	return SuccessMsg;
	}


	@Override
	public List<User> getAllRecord() {
		// TODO Auto-generated method stub
			return userrepository.findAll();
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userrepository.findByUsername(username);
	}

	@Override
	public User findByPassword(String password) {
		System.out.println("'Enter user pwd is-->"+password);
		String encodedpwd = Base64.getEncoder().encodeToString(password.getBytes());
		System.out.println("'after convert the pwd-->"+encodedpwd);
		return userrepository.findByUsername(encodedpwd);

			}
	
}
