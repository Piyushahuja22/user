package com.instainsurance.insuranceappl.daos;

import java.util.List;

import com.instainsurance.insuranceappl.models.User;

public interface UserDao {

	Boolean insertUser(User user);
	Boolean updateUser(User user);
	Boolean deleteUser(User user);
	User findByUserId(String id);
	List<User> getUsers();
	
}
