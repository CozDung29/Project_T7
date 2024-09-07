package com.managepage.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.managepage.dto.reponse.RentAreaReponseDTO;
import com.managepage.service.interfac.RentAreaService;

@RestController
public class RentAreaAPI {
	
	@Autowired
	private RentAreaService rentAreaService;
	
	@GetMapping(value="/api/rentareas")
	public Object getAll(@RequestParam(name="buildingId", required = false) Long buildingId) {
		List<RentAreaReponseDTO> rentAreaReponseDTOs = rentAreaService.findAll(buildingId);
		return rentAreaReponseDTOs;
	}
}
