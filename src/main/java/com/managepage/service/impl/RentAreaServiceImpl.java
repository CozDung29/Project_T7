package com.managepage.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managepage.dto.reponse.RentAreaReponseDTO;
import com.managepage.repository.entities.BuildingEntity;
import com.managepage.repository.entities.RentAreaEntity;
import com.managepage.repository.interfac.BuildingRepository;
import com.managepage.repository.interfac.RentAreaRepository;
import com.managepage.service.interfac.RentAreaService;

@Service
public class RentAreaServiceImpl implements RentAreaService{

	@Autowired
	private RentAreaRepository rentAreaRepository;

	
	@Override
	public List<RentAreaReponseDTO> findAll(Long buildingId) {
		List<RentAreaEntity> rentAreaEntities = rentAreaRepository.findAll(buildingId);
		
		List<RentAreaReponseDTO> rentAreaReponseDTOs = new ArrayList<RentAreaReponseDTO>();
		for(RentAreaEntity item : rentAreaEntities) {
			RentAreaReponseDTO rentAreaReponseDTO = new RentAreaReponseDTO();
			rentAreaReponseDTO.setId(item.getId());
			rentAreaReponseDTO.setBuildingId(item.getBuildingId());
			rentAreaReponseDTO.setValue(item.getValue());
			
			rentAreaReponseDTOs.add(rentAreaReponseDTO);
		}
		return rentAreaReponseDTOs;
	}

}
