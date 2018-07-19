package cdc.jjs.model.dao.impl;

import java.util.List;

import cdc.jjs.model.dao.UserDao;
import cdc.jjs.model.domain.User;

public class UserDaoHibernate extends BaseDaoHibernate<User> implements UserDao {
	
	public boolean containUser(String username , String password) {
		
		List<User> list = find("select u from User u where u.username=?0 and u.password=?1",username,password);
		
		return !list.isEmpty();					
	}
	
	public List<User> findUser(String username , String password) {
		
		return find("select u from User u where u.username=?0 and u.password=?1",username,password);
					
	}
	
	public boolean containUsername(String username){
		
		List<User> list = find("select u from User u where u.username=?0",username);
		
		return !list.isEmpty();			
	}

}