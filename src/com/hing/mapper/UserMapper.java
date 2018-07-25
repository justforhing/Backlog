package com.hing.mapper;

import java.util.List;


import com.hing.pojo.User;

public interface UserMapper {
	public void add(User user);
	
	public void delete(long id);
	
	public void update(User user);
	
	public User get(long id);
	
	public User getByUserName(String name);
	
	public List<User> list();
}
