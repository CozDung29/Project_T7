package com.managepage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managepage.dto.reponse.RentTypeReponseDTO;
import com.managepage.repository.entities.RentTypeEntity;
import com.managepage.repository.interfac.RentTypeRepository;
import com.managepage.service.interfac.RentTypeService;

@Service
public class RentTypeServiceImpl implements RentTypeService{

	@Autowired
	private RentTypeRepository rentTypeRepository;
	
	@Override
	public RentTypeReponseDTO findById(Long id) {
		RentTypeEntity rentTypeEntity = rentTypeRepository.findById(id);
		
		RentTypeReponseDTO rentTypeReponseDTO = new RentTypeReponseDTO();
		
		rentTypeReponseDTO.setId(rentTypeEntity.getId());
		rentTypeReponseDTO.setCode(rentTypeEntity.getCode());
		rentTypeReponseDTO.setName(rentTypeEntity.getName());
		
		return rentTypeReponseDTO;
	}

}
