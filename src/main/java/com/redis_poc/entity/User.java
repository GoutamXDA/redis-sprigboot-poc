package com.redis_poc.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(columnDefinition = "VARCHAR(36)")
	private UUID id;
	private String name;
	private int age;

}
