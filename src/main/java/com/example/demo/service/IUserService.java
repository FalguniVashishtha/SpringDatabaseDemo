
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.ResponseEntity;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserException;
import com.example.demo.model.EmailDetails;
import com.example.demo.model.UserModel;

public interface IUserService {
	
	ResponseEntity add(UserModel user) throws UserException;

//	List<UserModel> findAll();
//
//	UserDto findById(int id) throws UserException;
//	
	UserDto register(UserDto user) throws UserException;
	
//	LoginDto getUserByLogin(String email) throws UserException;

	void deleteById(int id);

//	UserModel updateOneUser(UserModel user, int id);

//	Optional<UserModel> getUserByName(String name) throws UserException;

//	ResponseEntity getUserByLogin(LoginDto loginDto) throws UserException;

	String loginUser(LoginDto loginDTO) throws UserException;

//	UserDto updateDataByEmail(UserDto userDTO, String email) throws UserException;

	String logoutuser(String token) throws UserException;

	// UserModel getUserDetailsByToken(String token);
	
	//String sendSimpleMail(EmailDetails details);

	UserModel updateByToken(UserModel user, String token) throws UserException;
}