package cdc.jjs.control.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cdc.jjs.model.domain.User;
import cdc.jjs.model.service.UserService;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 48L;

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private String username;
	private String password;
	private List<User> userList;

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

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String execute() throws Exception {
		if (userService.isCorrectUser(username, password)) {
			ActionContext.getContext().getSession().put(LoginState.USERNAME, username);
			ActionContext.getContext().getSession().put(LoginState.LOGINSTATE, "true");
			ActionContext.getContext().getSession().put(LoginState.LEVEL1, "true");
			return SUCCESS;
		} else {
			addActionMessage("请输入正确的用户名和密码");
			return INPUT;
		}
	}
	
	public String regist() throws Exception {
		if (userService.isFindUsername(username)) {
			addActionMessage("该用户名已经存在");
			return INPUT;
		} else {
			User user = new User(username,password);
			userService.add(user);
			addActionMessage("注册成功");
			return "regist";
		}
	}

	
	
	
}
