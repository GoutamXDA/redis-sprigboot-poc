package com.redis_poc.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redis_poc.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
