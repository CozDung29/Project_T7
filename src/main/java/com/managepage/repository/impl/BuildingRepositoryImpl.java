package com.managepage.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.managepage.repository.entities.BuildingEntity;
import com.managepage.repository.interfac.BuildingRepository;
import com.managepage.utils.ConnectionUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, List<String> rentTypeCode) {
		StringBuilder sqlJOIN = buildJoinClause(params, rentTypeCode);
		StringBuilder sqlCheckKey = buildWhereClause(params, rentTypeCode);
		
		StringBuilder sql = sqlJOIN.append(sqlCheckKey).append(" GROUP BY b.id");
		
		List<BuildingEntity> buildingEntities = new ArrayList<BuildingEntity>();
		try(Connection conn = ConnectionUtil.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql.toString())) {
			while(rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity();
				
				buildingEntity.setId(rs.getLong("id"));
			    buildingEntity.setName(rs.getString("name"));
			    buildingEntity.setStreet(rs.getString("street"));
			    buildingEntity.setWard(rs.getString("ward"));
			    buildingEntity.setDistrictId(rs.getLong("districtId"));
			    buildingEntity.setStructure(rs.getString("structure"));
			    buildingEntity.setNumberOfBasement(rs.getInt("numberOfBasement"));
			    buildingEntity.setFloorArea(rs.getInt("floorArea"));
			    buildingEntity.setDirection(rs.getString("direction"));
			    buildingEntity.setLevel(rs.getString("level"));
			    buildingEntity.setRentPrice(rs.getInt("rentPrice"));
			    buildingEntity.setRentPriceDescription(rs.getString("rentPriceDescription"));
			    buildingEntity.setServiceFee(rs.getString("serviceFee"));
			    buildingEntity.setCarFee(rs.getString("carFee"));
			    buildingEntity.setMotorbikeFee(rs.getString("motorbikeFee"));
			    buildingEntity.setOvertimeFee(rs.getString("overtimeFee"));
			    buildingEntity.setWaterFee(rs.getString("waterFee"));
			    buildingEntity.setElectricityFee(rs.getString("electricityFee"));
			    buildingEntity.setDeposit(rs.getString("deposit"));
			    buildingEntity.setPayment(rs.getString("payment"));
			    buildingEntity.setRentTime(rs.getString("rentTime"));
			    buildingEntity.setDecorationTime(rs.getString("decorationTime"));
			    buildingEntity.setNote(rs.getString("note"));
			    buildingEntity.setLinkOfBuilding(rs.getString("linkOfBuilding"));
			    buildingEntity.setMap(rs.getString("map"));
			    buildingEntity.setImage(rs.getString("image"));
			    buildingEntity.setCreatedBy(rs.getString("createdBy"));
			    buildingEntity.setModifiedBy(rs.getString("modifiedBy"));
			    buildingEntity.setManagerName(rs.getString("managerName"));
			    buildingEntity.setManagerPhonenumber(rs.getString("managerPhonenumber"));
				
				buildingEntities.add(buildingEntity);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return buildingEntities;
	}

	private StringBuilder buildJoinClause(Map<String, Object> params, List<String> rentTypeCode) {
		StringBuilder sqlJOIN = new StringBuilder("SELECT b.* FROM building b");
		if (rentTypeCode != null && !rentTypeCode.isEmpty()) {
            sqlJOIN.append(" JOIN BuildingRentType brt ON b.id = brt.buildingId");
            sqlJOIN.append(" JOIN rentType rt ra ON rt.id = ra.rentTypeId");
        }
		
		boolean[] rentAreaFlag = { false };
		params.forEach((key, value) -> {
			if (key.equals("staffId") && value != null) {
				sqlJOIN.append(" JOIN assignmentbuilding ab ON b.id = ab.buildingId");
			}
			if ((key.equals("rentAreaMin") || key.equals("rentAreaMax")) && value != null) {
				if (!rentAreaFlag[0]) {
					sqlJOIN.append(" JOIN rentarea ra ON b.id = ra.buildingId");
					rentAreaFlag[0] = true;
				}
			}
		});
		
		sqlJOIN.append(" WHERE 1=1");
		return sqlJOIN;
	}

	private StringBuilder buildWhereClause(Map<String, Object> params, List<String> rentTypeCode) {
		StringBuilder sqlCheckKey = new StringBuilder();
		params.forEach((key, value) -> {
			if (value != null && !value.equals("")) {
				if (key.equals("staffId")) {
					sqlCheckKey.append(" AND ab.").append(key).append(" = ").append(value); 
				} else if (key.equals("numberOfBasement")) {
					sqlCheckKey.append(" AND b.numberOfBasement").append(" = ").append(value);
				} else if (key.equals("rentPriceMin")) {
					sqlCheckKey.append(" AND b.rentPrice").append(" >= ").append(value);
				} else if (key.equals("rentPriceMax")) {
					sqlCheckKey.append(" AND b.rentPrice").append(" <= ").append(value);
				} else if (key.equals("rentAreaMin")) {
					sqlCheckKey.append(" AND ra.value").append(" >= ").append(value);
				} else if (key.equals("rentAreaMax")) {
					sqlCheckKey.append(" AND ra.value").append(" <= ").append(value);
				} else if (!key.equals("rentTypeCode")) {
					sqlCheckKey.append(" AND b.").append(key).append(" LIKE '%").append(value).append("%'");
				} 
			}
		});
		
		if (rentTypeCode != null && !rentTypeCode.isEmpty()) {
		    sqlCheckKey.append(" AND brt.code IN (");
		    sqlCheckKey.append(String.join(", ", rentTypeCode));
		    sqlCheckKey.append(")");
		}
		return sqlCheckKey;
	}

}
