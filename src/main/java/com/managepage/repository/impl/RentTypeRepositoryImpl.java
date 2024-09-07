package com.managepage.repository.impl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.managepage.repository.entities.RentTypeEntity;
import com.managepage.repository.interfac.RentTypeRepository;
import com.managepage.utils.ConnectionUtil;

@Repository
public class RentTypeRepositoryImpl implements RentTypeRepository{

	@Override
	public RentTypeEntity findById(Long id) {
		StringBuilder sql = new StringBuilder("SELECT r.* FROM renttype r WHERE r.id =" + id);
		
		RentTypeEntity rentType = new RentTypeEntity();
		try(Connection conn = ConnectionUtil.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql.toString())) {
			if(rs.next()) {
				rentType.setId(rs.getLong("id"));
				rentType.setCode(rs.getString("code"));
				rentType.setName(rs.getString("name"));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return rentType;
	}

}
