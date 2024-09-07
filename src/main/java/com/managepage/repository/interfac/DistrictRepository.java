package com.managepage.repository.interfac;

import java.util.List;

import com.managepage.repository.entities.DistrictEntity;

public interface DistrictRepository {
	List<DistrictEntity> findAll(Long id, String name, String code);
	
	void deleteDistrictByCode(String code);

	DistrictEntity findById(Long id);
	
}
