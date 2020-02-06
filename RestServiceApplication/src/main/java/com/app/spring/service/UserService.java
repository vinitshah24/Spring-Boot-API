package com.app.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.spring.dao.UserDao;
import com.app.spring.model.User;

@Service
public class UserService {

	private UserDao userDao;

	@Autowired
	public UserService(@Qualifier("HARDCODED-DB") UserDao userDao) {
		this.userDao = userDao;
	}

	public int addUser(User user) {
		return userDao.insertUser(user);
	}

	public List<User> getUsers() {
		return userDao.getUsers();
	}

	public int deleteUser(int id) {
		return userDao.deleteUser(id);
	}

	public int updateUser(int id, User user) {
		return userDao.updateUserById(id, user);
	}

	public User selectUser(int id) {
		return userDao.selectUser(id);
	}
}
