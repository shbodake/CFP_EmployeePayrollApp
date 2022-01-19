package com.bridgelabz.employeepayrollapp.exceptions;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionalHandler {
	
	private static final String message = "Exception While Processing REST Request";
	/**
	 * Method to handle any Exception thrown
	 * @param exception
	 * @return : ResponseEntity of Exception
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        List<ObjectError> errorList = methodArgumentNotValidException.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objErr->objErr.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO(message,errMsg,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

	/**
	 * Method to handle when user Id not found
	 * @param exception
	 * @return : Response Entity of Exception and HttpStatus
	 */
	 @ExceptionHandler(EmployeePayrollException.class)
	    public ResponseEntity<ResponseDTO> handlerPersonException(EmployeePayrollException exception){
	        ResponseDTO responseDTO = new ResponseDTO(message,EmployeePayrollException.class ,HttpStatus.BAD_REQUEST);
	        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	    }
	
}
