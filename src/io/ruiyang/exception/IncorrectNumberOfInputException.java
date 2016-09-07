/**
 * @author rui yang
 * Date: 07.09.2016
 */
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