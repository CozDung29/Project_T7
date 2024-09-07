package com.managepage.repository.interfac;

import java.util.List;
import java.util.Map;

import com.managepage.repository.entities.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll(Map<String, Object> params, List<String> rentTypeCode);
}
