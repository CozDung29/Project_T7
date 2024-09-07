package com.managepage.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.managepage.repository.entities.RentAreaEntity;
import com.managepage.repository.interfac.RentAreaRepository;
import com.managepage.utils.ConnectionUtil;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository{
	
	@Override
	public List<RentAreaEntity> findAll(Long buildingId) {
		StringBuilder sql = new StringBuilder("SELECT ra.* FROM rentArea ra WHERE 1=1");
		if (buildingId!=null) {
			sql.append(" AND ra.buildingId = " + buildingId);
		}

		List<RentAreaEntity> rentAreaEntities = new ArrayList<RentAreaEntity>();
		try(Connection conn = ConnectionUtil.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql.toString())) {
			while(rs.next()) {
				RentAreaEntity rentAreaEntity = new RentAreaEntity();
				rentAreaEntity.setId(rs.getLong("id"));
				rentAreaEntity.setBuildingId(rs.getLong("buildingId"));
				rentAreaEntity.setValue(rs.getLong("value"));
				
				rentAreaEntities.add(rentAreaEntity);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return rentAreaEntities;
	}

}
