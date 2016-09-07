package io.ruiyang.exception;

@SuppressWarnings("serial")
public abstract class InvalidInputException extends Exception{
	
	public abstract String getMessage();
	
	public InvalidInputException(){}
	
	public InvalidInputException(String msg){ 
		super(msg); 
	}
	
	public InvalidInputException(String msg, Throwable cause){
		super(msg, cause);
	}
}