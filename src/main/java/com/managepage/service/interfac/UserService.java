package com.managepage.service.interfac;

import com.managepage.dto.reponse.UserReponseDTO;

public interface UserService {
	UserReponseDTO findById(Long buildingId);
}
