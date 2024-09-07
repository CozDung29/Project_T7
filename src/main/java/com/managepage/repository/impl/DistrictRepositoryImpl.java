 package com.managepage.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.managepage.repository.entities.DistrictEntity;
import com.managepage.repository.interfac.DistrictRepository;
import com.managepage.utils.ConnectionUtil;


@Repository
public class DistrictRepositoryImpl implements DistrictRepository{
	
	@Override
	public List<DistrictEntity> findAll(Long id, String name, String code) {
		StringBuilder sql = new StringBuilder("SELECT d.id, d.name, d.code FROM district d WHERE 1=1");
		if (id > 0) {
			sql.append(" AND d.id = " + id);
		}
		else {
			if (name!=null && !name.equals("")) {
				sql.append(" AND d.name = '%" + name + "%'");
			}
			if (code!=null && !code.equals("")) {
				sql.append(" AND d.code = '%" + code + "%'");
			}
		}
		
		List<DistrictEntity> districtEntities = new ArrayList<DistrictEntity>();
		try(Connection conn = ConnectionUtil.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql.toString());
				){
			while(rs.next()) {
				DistrictEntity district = new DistrictEntity();
				district.setId(rs.getLong("id"));
				district.setName(rs.getString("name"));
				district.setCode(rs.getString("code"));
				districtEntities.add(district);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return districtEntities;
	}



	@Override
	public DistrictEntity findById(Long id) {
		StringBuilder sql = new StringBuilder("SELECT * FROM district d WHERE d.id = " + id);
		try(Connection conn = ConnectionUtil.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql.toString())){
			if(rs.next()) {
				DistrictEntity district = new DistrictEntity();
				district.setId(rs.getLong("id"));
				district.setName(rs.getString("name"));
				district.setCode(rs.getString("code"));
				return district;
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void deleteDistrictByCode(String code) {
		StringBuilder sql = new StringBuilder("DELETE d FROM district d WHERE 1=1");
		if (code!=null && !code.equals("")) {
			sql.append(" AND d.code = '" + code + "'");
		}
		try(Connection conn = ConnectionUtil.getConnection();
				Statement st = conn.createStatement()){
			st.executeUpdate(sql.toString());
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}