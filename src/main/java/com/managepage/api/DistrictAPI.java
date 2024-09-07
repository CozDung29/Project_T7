package com.managepage.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.managepage.dto.reponse.DistrictReponseDTO;
import com.managepage.service.interfac.DistrictService;

@RestController
public class DistrictAPI {
	
	@Autowired
	private DistrictService districtService;
	
	@GetMapping(value="/api/districts")
	public Object getDistrictById(@RequestParam(name = "id", required = false) Long id) {
		DistrictReponseDTO districtReponseDTO = districtService.findById(id);
		return districtReponseDTO;
	}
	
	@DeleteMapping(value="/api/districts")
	public void deleteDistrictByCode(@RequestParam(name = "code", required = false) String code) {
		districtService.deleteDistrictByCode(code);
	}
	
	@PostMapping(value="/api/districts")
	public DistrictReponseDTO createDistrict(@RequestBody DistrictReponseDTO districtReponseDTO) {
//		return districtService.save(districtReponseDTO);
		return null;
	}
}
