package com.onlineauction.onlineauctionservlet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.onlineauction.onlineauctionservlet.exceptions.UserNotFoundException;
import com.onlineauction.onlineauctionservlet.model.beans.User;
import com.onlineauction.onlineauctionservlet.utility.DBConnection;
import com.onlineauction.onlineauctionservlet.utility.PasswordEncrypter;

/**
 * 
 * Implementation of User DAO from User Interface DAO
 *
 */
public class UserDaoImpl implements UserDao {
	static Connection conn = null;
	@Override
	public int addUser(User user) {
		int status=0;
		boolean ifUserExist = getUserIfExist(user.getUsername(), user.getEmail());
		
		/**
		 * If the user does not exist then insert its details
		 */
		if(!ifUserExist) {
			Connection conn = DBConnection.getConnectionId();
			PreparedStatement ps;
			try {
				Random random = new Random();
				int id = random.nextInt(5000);
				//Query for inserting the details into the database
				ps = conn.prepareStatement("insert into Usertable values (?,?,?,?,?,?,?,?,?,?)");
				ps.setInt(1,id);
				ps.setString(2, user.getName());
				ps.setDate(3,  java.sql.Date.valueOf(user.getDob()));
				ps.setString(4, user.getEmail());
				ps.setString(5, user.getPhonenumber());
				ps.setString(6, user.getUsername());
				ps.setString(7, user.getPassword());
				ps.setString(8, user.getAddress());
				ps.setInt(9, user.getUserType());
				ps.setDouble(10, user.getWallet());
				status = ps.executeUpdate();
				System.out.println("Register status::"+status);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		}
		return status;
	}

	/**
	 * Function to get the user object based on username and password
	 */
	@Override
	public User getUser(String username, String password) throws UserNotFoundException {
		conn = DBConnection.getConnectionId();
		ResultSet rs = null;
		User u = new User();
		try {	
			//Query to get the user
			String getQuery = "select * from usertable where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(getQuery);
			ps.setString(1, username.toLowerCase());
			ps.setString(2, PasswordEncrypter.getSHA(password));
			rs = ps.executeQuery();
			while(rs.next()) {
				u.setUserid(rs.getInt("userid"));
				u.setName(rs.getString("Name"));
				u.setDob(rs.getDate("dob").toLocalDate());
				u.setEmail(rs.getString("email"));
				u.setPhonenumber(rs.getString("phonenumber"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setAddress(rs.getString("address"));
				u.setUserType(rs.getInt("user_type"));
				u.setWallet(rs.getDouble("wallet"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("u.getuuu:"+u.getUserid());
		if(u.getUserid()!=0)
			return u;
		else
		 throw new UserNotFoundException("User not found in DB");
	}


	@Override
	public int updateUser() {
		 
		return 0;
	}


	@Override
	public int deleteUser() {
		 
		return 0;
	}
	/*
	 * Function to get user if the user exists
	 */
	@Override
	public boolean getUserIfExist(String username, String email){
		conn = DBConnection.getConnectionId();
		ResultSet rs = null;
		User u = new User();
		try {	
			String getQuery = "select * from usertable where username=?";
			PreparedStatement ps = conn.prepareStatement(getQuery);
			ps.setString(1, username.toLowerCase());
			rs = ps.executeQuery();
			while(rs.next()) {
				u.setUserid(rs.getInt("userid"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		try {	
			String getQuery = "select * from usertable where email=?";
			PreparedStatement ps = conn.prepareStatement(getQuery);
			ps.setString(1, email.toLowerCase());
			rs = ps.executeQuery();
			while(rs.next()) {
				u.setUserid(rs.getInt("userid"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		if(u.getUserid()!=0)
			return true;
		else
		 return false;
	}

}
