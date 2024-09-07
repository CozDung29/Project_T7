package com.managepage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managepage.dto.reponse.DistrictReponseDTO;
import com.managepage.repository.entities.DistrictEntity;
import com.managepage.repository.interfac.DistrictRepository;
import com.managepage.service.interfac.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService{

	@Autowired
	private DistrictRepository districtRepository;
	
	@Override
	public List<DistrictReponseDTO> findAll(Long id, String name, String code) {
		List<DistrictEntity> districtEntities = districtRepository.findAll(id, name, code);
		
		//filter
		List<DistrictReponseDTO> districtReponseDTOs = new ArrayList<DistrictReponseDTO>();
		for(DistrictEntity item : districtEntities) {
			DistrictReponseDTO districtReponseDTO = new DistrictReponseDTO();
			districtReponseDTO.setId(item.getId());
			districtReponseDTO.setName(item.getName());
			districtReponseDTO.setCode(item.getCode());
			districtReponseDTOs.add(districtReponseDTO);
		}
		return districtReponseDTOs;
	}

	@Override
	public DistrictReponseDTO findById(Long id) {
		DistrictEntity districtEntity = districtRepository.findById(id);
		DistrictReponseDTO districtReponseDTO = new DistrictReponseDTO();
		districtReponseDTO.setId(districtEntity.getId());
		districtReponseDTO.setName(districtEntity.getName());
		districtReponseDTO.setCode(districtEntity.getCode());
		return districtReponseDTO;
	}
	
	@Override
	public void deleteDistrictByCode(String code) {
		districtRepository.deleteDistrictByCode(code);
	}

}
