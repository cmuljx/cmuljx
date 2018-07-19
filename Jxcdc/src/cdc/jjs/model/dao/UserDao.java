package cdc.jjs.model.dao;

import java.util.List;

import cdc.jjs.model.domain.User;

public interface UserDao extends BaseDao<User>{
	
	public boolean containUser(String username , String password);
	
	public List<User> findUser(String username , String password);
	
	public boolean containUsername(String username);

}
