package by.htp.ll.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import by.htp.ll.bean.News;
import by.htp.ll.dao.DAOException;
import by.htp.ll.dao.NewsDAO;
import java.sql.*;


public class SQLNewsDAO implements NewsDAO {

	static {
		MYSQLDriverLoader.getInstance();
	}
	
	@Override
	public List<News> all() throws DAOException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		List<News> news = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC"+
					"","root", "1111");
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM news");
			
			news = new ArrayList<News>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title"); 
				String brief = rs.getString("brief");
				News n = new News(id, title, brief);
				
				news.add(n);
	
			}
			
		} catch(SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		
		return news;
	}

	@Override
	public News takeOne(int id) throws DAOException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		News news = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC"+
					"","root", "1111");
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM news WHERE id =" + id);
			
			
			while(rs.next()) {
				int idNews = rs.getInt("id");
				String title = rs.getString("title"); 
				String brief = rs.getString("brief");
				String content = rs.getString("content");
				Date date = rs.getDate("date");
				news = new News(idNews, title, brief, content, date.toLocalDate());
			}
			
		} catch(SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		return news;
	}

	@Override
	public void updateNews(int id, String title, String brief, String content) throws DAOException {
		Connection con = null;
		Statement st = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC"+
					"","root", "1111");
			st = con.createStatement();
			st.executeUpdate("UPDATE news SET title='" + title + "', brief='" + brief + "', content='" + content + "' WHERE id=" + id);
			
		}catch (SQLException e) {
			throw new DAOException("sdsd", e);
		}finally {
			try {
				con.close();
			} catch(SQLException e) {
				throw new DAOException("sdsd", e);
			}
		}
	}

	@Override
	public void deleteNews(int id) throws DAOException {
		Connection con = null;
		Statement st = null;
				
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC"+
					"","root", "1111");
			st = con.createStatement();
		//	String query = "UPDATE news SET status = 'not active' WHERE id=" + id;
			String query = "DELETE FROM news WHERE id=" + id;
			st.executeUpdate(query);
			
		}catch (SQLException e) {
			throw new DAOException("can't delete the news: DB error", e);
		}finally {
			try {
					con.close();
			} catch(SQLException e) {
				throw new DAOException("error with closing resources", e);
			}
		}
		
	}
	
}
