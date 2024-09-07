package com.managepage.service.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managepage.dto.reponse.BuildingReponseDTO;
import com.managepage.dto.reponse.RentAreaReponseDTO;
import com.managepage.repository.entities.BuildingEntity;
import com.managepage.repository.entities.DistrictEntity;
import com.managepage.repository.entities.RentAreaEntity;
import com.managepage.repository.interfac.BuildingRepository;
import com.managepage.repository.interfac.DistrictRepository;
import com.managepage.repository.interfac.RentAreaRepository;
import com.managepage.service.interfac.BuildingService;
import com.managepage.service.interfac.RentAreaService;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingRepository buildingRepository; // hứng dữ liệu từ data access layer

	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private RentAreaRepository rentAreaRepository;

	@Override
	public List<BuildingReponseDTO> findAll(Map<String, Object> params, List<String> rentTypeCode) {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(params, rentTypeCode);

		// filter
		List<BuildingReponseDTO> buildingReponseDTOs = new ArrayList<BuildingReponseDTO>();
		for (BuildingEntity item : buildingEntities) {
			DistrictEntity districtEntity = districtRepository.findById(item.getDistrictId());
			
			List<RentAreaEntity> rentAreaEntities = rentAreaRepository.findAll(item.getId());
            StringJoiner rentAreaJoiner = new StringJoiner(", ");
            for (RentAreaEntity rentArea : rentAreaEntities) {
                rentAreaJoiner.add(String.valueOf(rentArea.getValue()));
            }
            String rentAreaString = rentAreaJoiner.toString();
			

			BuildingReponseDTO buildingReponseDTO = new BuildingReponseDTO();
			buildingReponseDTO.setName(item.getName());
			buildingReponseDTO.setAddress(item.getStreet() + ", " + item.getWard() + ", " + districtEntity.getName());
			buildingReponseDTO.setNumberOfBasement(item.getNumberOfBasement());
			buildingReponseDTO.setManagerName(item.getManagerName());
			buildingReponseDTO.setManagerPhoneNumber(item.getManagerPhonenumber());
			buildingReponseDTO.setFloorArea(item.getFloorArea());
			buildingReponseDTO.setFreeArea(null);
			buildingReponseDTO.setRentArea(rentAreaString);
			buildingReponseDTO.setRentPrice(item.getRentPrice());
			buildingReponseDTO.setMediumFee(null);
			buildingReponseDTO.setServiceFee(item.getServiceFee());

			buildingReponseDTOs.add(buildingReponseDTO);
		}

		return buildingReponseDTOs;
	}

}
