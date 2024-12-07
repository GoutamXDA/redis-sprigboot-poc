package com.redis_poc.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis_poc.entity.User;
import com.redis_poc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Optional<User> getUserById(UUID id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}

	public User createUser(User user) {
		if (user.getId() == null) {
			user.setId(UUID.randomUUID());
		}
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(UUID id) {
		userRepository.deleteById(id);
	}

}
