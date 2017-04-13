package com.coders.elite.dao;

import java.util.List;

import com.coders.elite.bean.Users;

public interface UserDAO {
	public List<Users> getAllUsers();
	public Users getUser(int id);
	public Users getUser(String mobile);
	public Users addUser(Users user);
	public void updateUser(Users user);
	public void deleteUser(int id);
	public Users verifyReferralCode( String referralCode );
}
