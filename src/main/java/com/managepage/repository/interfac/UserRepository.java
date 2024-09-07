package com.managepage.repository.interfac;

import com.managepage.repository.entities.UserEntity;

public interface UserRepository {
	UserEntity findById(Long buildingId);
}