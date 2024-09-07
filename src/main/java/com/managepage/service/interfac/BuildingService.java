package com.managepage.service.interfac;

import java.util.List;
import java.util.Map;

import com.managepage.dto.reponse.BuildingReponseDTO;

public interface BuildingService {
	List<BuildingReponseDTO> findAll(Map<String, Object> params, List<String> rentTypeCode);
}
