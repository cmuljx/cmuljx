package cdc.jjs.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userID;
	
	@Column(name="username" , nullable=false , unique=true)
	private String username;
	
	@Column(name="password" , nullable=false)
	private String password;
	
	public User() {
		
	}
	
	public User(String username , String password) {
		this.username = username;
		this.password = password;	
	}

	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
