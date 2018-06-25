package com.instainsurance.insuranceappl.services;

import java.util.List;

import com.instainsurance.insuranceappl.models.User;

public interface UserServices {

	Boolean insertUser(User user);
	Boolean updateUser(User user);
	Boolean deleteUser(User user);
	User findByUserId(String id);
	List<User> getUsers();
	
}
