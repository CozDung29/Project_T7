package com.managepage.api;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.managepage.dto.reponse.BuildingReponseDTO;
import com.managepage.service.interfac.BuildingService;

@RestController
public class BuildingAPI {
	
	@Autowired
	private BuildingService buildingService;
	
	@GetMapping(value="/api/buildings")
	public Object getBuilding(@RequestParam Map<String, Object> params,
								@RequestParam (name="rentTypeId", required = false) List<String> rentTypeCode) {
		List<BuildingReponseDTO> BuildingReponseDTOs = buildingService.findAll(params, rentTypeCode);
		return BuildingReponseDTOs;
	}
}
