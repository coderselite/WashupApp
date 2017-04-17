package com.coders.elite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coders.elite.bean.Users;
import com.coders.elite.service.UserService;

//@CrossOrigin(origins="http://localhost:8100", maxAge=4800, allowCredentials="False") 
@RestController
public class UserController {
 
	 @Autowired
	 UserService userService;
	 
	 /*
	  * Service used to validateUser. It generatesValidOtp and sends it to the specified mobile number.
	  * Checks if its an existing user or newUser.
	  * If existing user then it updates the new otp in the otp table.
	  * If new user then it inserts a new entry with the otp in the table.
	  * Returns a flag stating if the user is a "registered user" or a "New User".
	  * ValidOtpGeneration, sendingOtp, updateOtp/AddOtp all activities are performed here.
	  */
	 @RequestMapping(value = "/validateUser/mobile/{mobile}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public String validateUser(@PathVariable String mobile) {
	  return userService.validateUser(mobile);
	 }
	 
	 /*
	  * Service for getting all the users from the users table.
	  */
	 @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List<Users> getUsers() {	  
		 List<Users> listOfUsers = userService.getAllUsers();
		 return listOfUsers;
	 }
	 
	 /*
	  * Service to get a User object for the specified userid.
	  */
	 @RequestMapping(value = "/getUser/id/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public Users getUserById(@PathVariable Integer id) {
		 return userService.getUser(id);
	 }
	 
	 /*
	  * Service to get a User object for the specified mobile number.
	  */
	 @RequestMapping(value = "/getUser/mobile/{mobile}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public Users getUserByMobile(@PathVariable String mobile) {
		 return userService.getUser(mobile);
	 }
	 
	 /*
	  * Service to add a new User object.
	  */
	 @RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addUser(@RequestBody Users User) { 
		 System.out.println("inside addUser controller");
		 userService.addUser(User);
	  
	 }
	 
	 /*
	  * Service to update an existing user in the table.
	  */
	 @RequestMapping(value = "/updateUser", method = RequestMethod.PUT, headers = "Accept=application/json")
	 public void updateUser(@RequestBody Users User) {
		 userService.updateUser(User);
	 }
	 
	 /*
	  * Service to delete a user specified b the userid from the table.
	  */
	 @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteUser(@PathVariable("id") int id) {
		 userService.deleteUser(id);  
	 }
}
