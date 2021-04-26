package by.htp.ll.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.ll.bean.RegistrationInfo;
import by.htp.ll.bean.User;
import by.htp.ll.dao.DAOException;
import by.htp.ll.dao.UserDAO;

public class SQLUserDAO implements UserDAO{

	static {
		MYSQLDriverLoader.getInstance();
	}
	
	@Override
	public User authorization(String login, String password) throws DAOException {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		User user = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC"+
					"","root", "1111");
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM users WHERE login = '" + login + "' AND password = '" + password + "'");
			while(rs.next()) {
				user = new User();
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setNickname(rs.getString("nickname"));
				user.setRole(rs.getString("role"));
			}

		}catch (SQLException e) {
			throw new DAOException("Can't authorize user: DB error", e);
		}finally {
			try {
					con.close();
			} catch(SQLException e) {
				throw new DAOException("error with closing resources", e);
			}
		}
		return user;
		/*
		 * System.out.println("USER AUTHORIZATION"); return new User();
		 */
	}


	@Override
	public void registration(User userInfo) throws DAOException {
		Connection con = null;
		Statement st = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC"+
					"","root", "1111");
			st = con.createStatement();

			st.executeUpdate("INSERT INTO users (login, password, email, nickname, role) VALUES ('"+ userInfo.getLogin() + "', '" + userInfo.getPassword() +
					"', '" + userInfo.getEmail() + "', '" + userInfo.getNickname() + "', 'user')");   

		}catch (SQLException e) {
			throw new DAOException("can't create recording about user", e);
		}finally {
			try {
					con.close();
			} catch(SQLException e) {
				throw new DAOException("error with closing resources", e);
			}
		}
		
	}

}
