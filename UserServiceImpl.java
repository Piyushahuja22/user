package com.instainsurance.insuranceappl.services.impl;

import java.util.List;

import javax.annotation.Resource;

import com.instainsurance.insuranceappl.daos.UserDao;
import com.instainsurance.insuranceappl.models.User;
import com.instainsurance.insuranceappl.services.UserServices;

public class UserServiceImpl implements UserServices {

	@Resource
	private UserDao dao;
	
	@Override
	public Boolean insertUser(User user) {
		return dao.insertUser(user);
	}

	@Override
	public Boolean updateUser(User user) {
		return dao.updateUser(user);
	}

	@Override
	public Boolean deleteUser(User user) {
		return dao.deleteUser(user);
	}

	@Override
	public User findByUserId(String id) {
		return dao.findByUserId(id);
	}

	@Override
	public List<User> getUsers() {
		return dao.getUsers();
	}

}
