package com.managepage.repository.impl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.managepage.repository.entities.UserEntity;
import com.managepage.repository.interfac.UserRepository;
import com.managepage.utils.ConnectionUtil;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Override
	public UserEntity findById(Long id) {
		StringBuilder sql = new StringBuilder("SELECT u.* FROM user u WHERE u.id = " + id);
		
		UserEntity user = new UserEntity();
		try(Connection conn = ConnectionUtil.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql.toString())) {
			if(rs.next()) {
				user.setUserName(rs.getString("userName"));
				user.setEmail(rs.getString("email"));
				user.setId(rs.getLong("id"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setFullName(rs.getString("fullName"));
				user.setStatus(rs.getInt("status"));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return user;
	}

}
