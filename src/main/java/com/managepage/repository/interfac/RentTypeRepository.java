package com.managepage.repository.interfac;

import com.managepage.repository.entities.RentTypeEntity;

public interface RentTypeRepository {
	RentTypeEntity findById(Long id);
}
