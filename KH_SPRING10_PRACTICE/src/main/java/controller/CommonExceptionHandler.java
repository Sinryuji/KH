package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("KH_SPRING08")
public class CommonExceptionHandler {
	
//	@ExceptionHandler(Exception.class)
	public String handleException() {
		return "error/commonException";
	}
}
