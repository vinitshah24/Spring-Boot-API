package com.app.spring.dao;

import java.util.List;

import com.app.spring.model.User;

public interface UserDao {

	int insertUser(int id, User user);

	default int insertUser(User user) {
		int id = (int) (Math.random() * ((100 - 1) + 1)) + 1;
		return insertUser(id, user);
	}

	List<User> getUsers();

	int deleteUser(int id);

	int updateUserById(int id, User user);

	User selectUser(int id);
}
