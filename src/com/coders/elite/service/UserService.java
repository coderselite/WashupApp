package com.coders.elite.service;

import java.util.List;

import com.coders.elite.bean.Users;

public interface UserService {
	public List<Users> getAllUsers();
	public Users getUser(Integer id);
	public Users getUser(String mobile);
	public void addUser(Users user);
	public void updateUser(Users user);
	public void deleteUser(int id);
	public String validateUser(String mobile);
	public String generateReferralCode();
	public String verifyReferralCode();
}

