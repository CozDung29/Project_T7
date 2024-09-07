package com.managepage.repository.interfac;

import java.util.List;

import com.managepage.repository.entities.RentAreaEntity;

public interface RentAreaRepository {
	List<RentAreaEntity> findAll(Long id);
}
