package by.htp.ll.bean;

import java.io.Serializable;

public class UserLoginationInfo implements Serializable{
	private static final long serialVersionUID = 2512803626825146465L;
	
	private String login;
	private String password;
	
	public UserLoginationInfo() {}
	
	public UserLoginationInfo(String login, String password) {
		super();
		this.login = login;
		this.password = password;		
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
