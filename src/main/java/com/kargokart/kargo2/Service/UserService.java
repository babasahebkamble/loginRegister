package com.kargokart.kargo2.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kargokart.kargo2.Model.User;

@Service
public interface UserService {

	String registrationmsg();

	String saveNewUser(User userdata);

	List<User> getAllRecord();

	User findByUsername(String username);

	User findByPassword(String password);

}
