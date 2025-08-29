package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.UserDao;
import model.User;
import util.DBConnect;

public  class UserDaoImpl implements UserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public User get(String userName) {
		String sql = "SELECT * FROM Users WHERE userName = ?";
		try {
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt("userID"));
				user.setUserName(rs.getString("userName"));
				user.set_password(rs.getString("_passWord"));
				user.setEmail(rs.getString("email"));
				user.setFullName(rs.getString("fullName"));
				user.setRoleID(rs.getInt("roleid"));
				user.setPhone(rs.getString("phone"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return null;
	}

	@Override
	public boolean insert(User user) {
	    String sql = "INSERT INTO Users (userName, email, fullName,_password, phone) VALUES (?, ?, ?, ?, ?)";
	    try (Connection conn = DBConnect.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, user.getUserName());
	        ps.setString(2, user.getEmail());
	        ps.setString(3, user.getFullName());
	        ps.setString(4, user.get_password());
	        ps.setString(5, user.getPhone());
	        int rows = ps.executeUpdate();
	        return rows > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}


	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from Users where email = ?";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from Users where username = ?";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}
}
