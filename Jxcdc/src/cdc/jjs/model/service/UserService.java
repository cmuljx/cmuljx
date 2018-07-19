package cdc.jjs.model.service;

import java.util.List;

import cdc.jjs.model.domain.User;

public interface UserService {
	
	public boolean isCorrectUser(String username , String password);
	
	public List<User> findUser(String username , String password);
	
	public void add(User user);
	
	public boolean isFindUsername(String username);

}
