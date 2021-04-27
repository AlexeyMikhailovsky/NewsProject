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
	
	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + (( login == null) ? 0 : login.hashCode());
        return result;    	    
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
            return true;
        }

        if (!(obj instanceof News)) {
			return false;
		}
			
		UserLoginationInfo userLoginationInfo = (UserLoginationInfo) obj;

		return login != null && login.equals(userLoginationInfo.login);
	}

	@Override
	public String toString() {
		return "login: " + this.login+ "\n" +
	           "password:" + this.password + "\n";
	}
}
