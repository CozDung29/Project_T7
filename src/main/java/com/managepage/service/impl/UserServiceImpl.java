package com.managepage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.managepage.dto.reponse.UserReponseDTO;
import com.managepage.repository.entities.UserEntity;
import com.managepage.repository.interfac.UserRepository;
import com.managepage.service.interfac.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserReponseDTO findById(Long id) {
		UserEntity userEntity = userRepository.findById(id);
		
		UserReponseDTO userReponseDTO = new UserReponseDTO();
		userReponseDTO.setEmail(userEntity.getEmail());
		userReponseDTO.setFullName(userEntity.getFullName());
		userReponseDTO.setId(userEntity.getId());
		userReponseDTO.setPassword(userEntity.getPassword());
		userReponseDTO.setPhone(userEntity.getPhone());
		userReponseDTO.setStatus(userEntity.getStatus());
		userReponseDTO.setUserName(userEntity.getUserName());
		
		return userReponseDTO;
	}

}
