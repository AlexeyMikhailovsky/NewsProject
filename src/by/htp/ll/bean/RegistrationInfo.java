package by.htp.ll.bean;

import java.io.Serializable;

public class RegistrationInfo implements Serializable{ 

	private static final long serialVersionUID = -8465583870160572116L;
	
	private String login;
	private String password;
	private String email;
	private String nickname;
	
	public RegistrationInfo() {
	}
	
	public RegistrationInfo(String login, String password, String email, String nickname) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.nickname = nickname;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	
}
