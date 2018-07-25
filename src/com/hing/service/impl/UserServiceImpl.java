package com.hing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hing.mapper.UserMapper;
import com.hing.pojo.User;
import com.hing.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;
	@Override
	public void addUser(User user) {
		user.setUSER_ID(System.currentTimeMillis());
		userMapper.add(user);
	}

	@Override
	public void deleteUserById(long id) {
		userMapper.delete(id);
	}

	@Override
	public void updateUser(User user) {
		userMapper.update(user);
	}

	@Override
	public User getUserById(long id) {
		return userMapper.get(id);
	}

	@Override
	public List<User> showAllUser() {
		return userMapper.list();
	}

	@Override
	public boolean isExist(String name) {
		User user = userMapper.getByUserName(name);
		if(user != null) {
			return true;
		}
		return false;
	}

	@Override
	public User getUserByUserName(String name) {
		return userMapper.getByUserName(name);
	}

}
