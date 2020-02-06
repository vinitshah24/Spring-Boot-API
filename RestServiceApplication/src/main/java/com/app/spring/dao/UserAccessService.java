package com.app.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.spring.model.User;

@Repository("HARDCODED-DB")
public class UserAccessService implements UserDao {

	private static List<User> DB = new ArrayList<>();

	@Override
	public int insertUser(int id, User user) {
		DB.add(new User(id, user.getName()));
		return id;
	}

	@Override
	public List<User> getUsers() {
		return DB;
	}

	@Override
	public int deleteUser(int id) {
		int i = 0;
		while (i < DB.size()) {
			if (DB.get(i).getId() == id) {
				DB.remove(i);
				return 0;
			}
		}
		return -1;
	}

	@Override
	public int updateUserById(int id, User user) {
		for (User u : DB) {
			if (u.getId() == id) {
				String updatedName = user.getName();
				u.setName(updatedName);
				return 0;
			}
		}
		return 1;
	}

	@Override
	public User selectUser(int id) {
		for (User user : DB) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
