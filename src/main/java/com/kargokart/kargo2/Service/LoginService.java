package com.kargokart.kargo2.Service;

import org.springframework.stereotype.Service;

import com.kargokart.kargo2.Model.User;
@Service
public interface LoginService {

	User findByUsername(String username);

	User findBypassword(String password);

}
