package com.managepage.service.interfac;

import java.util.List;

import com.managepage.dto.reponse.DistrictReponseDTO;

public interface DistrictService {
	List <DistrictReponseDTO> findAll(Long id, String name, String code);
	
	void deleteDistrictByCode(String code);

	DistrictReponseDTO findById(Long id);
	
	
}
