package com.managepage.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.managepage.dto.reponse.RentTypeReponseDTO;
import com.managepage.service.interfac.RentTypeService;

@RestController
public class RentTypeAPI {
	
	@Autowired
	private RentTypeService rentTypeService;
	
	@GetMapping(value="/api/renttypes")
	public Object getRentType(@RequestParam(name="id") Long id) {
		RentTypeReponseDTO rentTypeReponseDTO = rentTypeService.findById(id);
		return rentTypeReponseDTO;
	}

}
