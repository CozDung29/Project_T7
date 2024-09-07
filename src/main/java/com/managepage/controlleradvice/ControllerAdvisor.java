package com.managepage.controlleradvice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.managepage.dto.error.ErrorReponseDTO;

@ControllerAdvice
public class ControllerAdvisor {
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<ErrorReponseDTO> handleSQLException(SQLException ex){
		ErrorReponseDTO errorReponseDTO = new ErrorReponseDTO();
		errorReponseDTO.setErrorMessage("Sorri");
		List<String> details = new ArrayList<String>();
		details.add(ex.getMessage());
		errorReponseDTO.setErrorDetails(details);
		return new ResponseEntity<>(errorReponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
