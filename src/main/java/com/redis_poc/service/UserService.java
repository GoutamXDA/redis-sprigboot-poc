package com.redis_poc.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.redis_poc.entity.User;
import com.redis_poc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Cacheable(value = "users", key = "#id")
	public Optional<User> getUserById(UUID id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}

	@Caching(evict = { @CacheEvict(value = "users", key = "#user.id"),
			@CacheEvict(value = "users", allEntries = true) })
	public User createUser(User user) {
		if (user.getId() == null) {
			user.setId(UUID.randomUUID());
		}
		return userRepository.save(user);
	}

	@Cacheable(value = "users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@CacheEvict(value = "users", key = "#id")
	public void deleteUser(UUID id) {
		userRepository.deleteById(id);
	}

}
