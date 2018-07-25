package com.hing.service;

import java.util.List;


import com.hing.pojo.User;

public interface UserService {
	public void addUser(User user);
	
	public void deleteUserById(long id);
	
	public void updateUser(User user);
	
	public User getUserById(long id);
	
	public List<User> showAllUser();
	
	public User getUserByUserName(String name);
	
	public boolean isExist(String name);
}
