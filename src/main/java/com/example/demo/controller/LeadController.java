package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResponseEntity;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserException;
import com.example.demo.model.EmailDetails;
import com.example.demo.model.UserModel;
import com.example.demo.service.IUserService;
import com.example.demo.util.JavaEmailService;
import com.example.demo.util.TokenUtil;

//import antlr.collections.List;

	@RestController
	public class LeadController {
		@Autowired
		IUserService userService;
		@Autowired
		TokenUtil tokenutil;
		@Autowired
		private JavaEmailService emailService;

//		@GetMapping("/hello")
//		public String Lead() {
//			return "Hello";
//		}

	
		@PostMapping("/addUser")
		public ResponseEntity AddUser(@RequestBody UserModel user) throws UserException {
			ResponseEntity userModel = userService.add(user);
			System.out.println("User is added");
			return new ResponseEntity(userModel, "User added succesfully");
		}
		
		
//		@GetMapping("/listAll")
//		public ResponseEntity listAll() {
//			List<UserModel> users = userService.findAll();
//			System.out.println("Getting the list for all the user");
//			return new ResponseEntity(users, "user found");
//		}
//		@GetMapping("/user/{id}")
//		public ResponseEntity getUser(@PathVariable int id) throws UserException {
//			UserDto userDto = userService.findById(id);
//			System.out.println("Getting the user by id where Id is " + id);
//			return new ResponseEntity(userDto, "Get the user succesfully");
//		}
		
		@PostMapping("/registerUser")
		public ResponseEntity registerUser(@RequestBody UserDto user) throws UserException {
			UserDto registerUser = userService.register(user);
			System.out.println("Registration is done");
			return new ResponseEntity(registerUser, "User registered succesfully");
		}
		
//		@GetMapping("/userLogin")
//		public ResponseEntity getUserByLoginDto(@RequestBody LoginDto loginDto) throws UserException
//		{
//			//LoginDto loginUser= userService.getUserByLogin(loginDto);
//			System.out.println("Logged In");
//			return userService.getUserByLogin(loginDto);
//		}
		
//		@GetMapping("/GetUser/{token}")
//	    public UserModel getUserDetailsByToken(@PathVariable String token) {
//	        UserModel userData = userService.getUserDetailsByToken(token);
//	        return userData;
//	    }
		
		@PostMapping("/login")
        public String loginUser(@RequestBody LoginDto loginDTO) throws UserException {
            String response = userService.loginUser(loginDTO);
            return response;
		}
		
//		@PutMapping("/update/{email}")
//	    public ResponseEntity updateUserByEmailAddress(@PathVariable String email,@RequestBody UserDto userDTO)  throws UserException {
//	        UserDto userData = userService.updateDataByEmail(userDTO, email);
//	        return new ResponseEntity(userData, "Data updated succesfully");
//	    }
		
		@PostMapping("/logout/{token}")
        public String logoutuser(@PathVariable String token) throws UserException {
            String userData = userService.logoutuser(token);
            return userData;
        }
		
		@PutMapping("/updateByToken")
		public ResponseEntity updateByToken(@RequestBody UserModel user, @RequestHeader(value = "Authorization") String token) throws UserException
		{
			UserModel userModel= userService.updateByToken(user,token);
			System.out.println("it is printing");
			return new ResponseEntity(userModel, "update data successfully");
		}

		
//		@PutMapping("/updateUser/{id}")
//		public ResponseEntity updateUser(@RequestBody UserModel user, @PathVariable int id) {
//			userService.updateOneUser(user, id);
//			System.out.println("Update the user succesfully");
//			return new ResponseEntity(userService, "Update the user succesfully");
//		}

		@DeleteMapping("/deleteUser")
		public ResponseEntity deleteOneUser(@RequestParam int id) {
			userService.deleteById(id);
			System.out.println("Delete one user");
			return new ResponseEntity(userService, "Delete the user succesfully");
		}

//		@GetMapping("/searchUser")
//		public ResponseEntity getUserByName(@RequestParam String name) throws UserException {
//			Optional<UserModel> user = userService.getUserByName(name);
//			System.out.println("User fetched successfully");
//			return new ResponseEntity(user, "User fetched successfully");
//		}
//		
//			@PostMapping("/sendMail")
//		public String sendMail(@RequestBody EmailDetails details) {
//			String status = emailService.sendSimpleMail(details);
//			return status;
//		}
		

	}


