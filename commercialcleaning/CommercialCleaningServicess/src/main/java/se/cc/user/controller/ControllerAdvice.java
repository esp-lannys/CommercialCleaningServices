package se.cc.user.controller;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	 
	 public String handleIOException(HttpRequestMethodNotSupportedException ex) {
	        return "redirect:/";
	    }
}
