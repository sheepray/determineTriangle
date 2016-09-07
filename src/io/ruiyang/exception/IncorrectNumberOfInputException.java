package io.ruiyang.exception;

import io.ruiyang.Constants;

@SuppressWarnings("serial")
public class IncorrectNumberOfInputException extends InvalidInputException{
	
	public IncorrectNumberOfInputException() {
		super();
	}
	
	@Override
	public String getMessage() {
		return Constants.INCORRECT_NUMBER_OF_INPUT_EXE_MSG;
	}

}