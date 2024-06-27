package com.kargokart.kargo2.Serviceiml;

import org.springframework.beans.factory.annotation.Autowired;

import com.kargokart.kargo2.Model.User;
import com.kargokart.kargo2.Repository.UserRepository;

public class loginServiceImpl implements com.kargokart.kargo2.Service.LoginService{
@Autowired
private UserRepository userrepository;
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userrepository.findByUsername(username);
		
	}
	@Override
	public User findBypassword(String password) {
		// TODO Auto-generated method stub
		return userrepository.findBypassword(password);
	}

}
