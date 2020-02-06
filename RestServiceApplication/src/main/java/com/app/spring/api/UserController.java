package com.app.spring.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.spring.model.User;
import com.app.spring.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public void adUser(@Valid @NotNull @RequestBody User user) {
		userService.addUser(user);
	}

	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping(path = "{id}")
	public User getUser(@PathVariable("id") int id) {
		if(userService.selectUser(id).equals(null) || userService.selectUser(id).equals("")) {
			return null;
		}
		return userService.selectUser(id);
	}
	
	@DeleteMapping(path = "{id}")
	public int deleteUser(@PathVariable("id") int id) {
		return userService.deleteUser(id);
	}

	@PutMapping(path = "{id}")
	public int updateUserById(@PathVariable("id") int id, @Valid @NotNull @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	
}