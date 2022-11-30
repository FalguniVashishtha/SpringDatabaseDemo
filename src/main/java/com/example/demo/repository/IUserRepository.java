package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserModel;
public interface IUserRepository extends JpaRepository<UserModel, Integer> {

	Optional<UserModel> findByFirstName(String name);

	Optional<UserModel> findByEmail(String email);
	
	Optional<UserModel> findByEmailAndPassword(String email, String password);

}