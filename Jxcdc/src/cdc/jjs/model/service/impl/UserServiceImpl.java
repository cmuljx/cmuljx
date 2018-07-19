package cdc.jjs.model.service.impl;

import java.util.List;

import cdc.jjs.model.dao.UserDao;
import cdc.jjs.model.domain.User;
import cdc.jjs.model.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public boolean isCorrectUser(String username , String password) {
	
		return userDao.containUser(username, password);
		
	}
	
	public List<User> findUser(String username , String password){
		
		return userDao.findUser(username , password);
				
	}
	
	public void add(User user) {
		userDao.save(user);
	}
	
	public boolean isFindUsername(String username) {
		
		return userDao.containUsername(username);
		
	}

}
