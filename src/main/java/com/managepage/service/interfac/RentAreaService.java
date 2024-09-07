package com.managepage.service.interfac;

import java.util.List;

import com.managepage.dto.reponse.RentAreaReponseDTO;

public interface RentAreaService {

	List<RentAreaReponseDTO> findAll(Long buildingId);
}
