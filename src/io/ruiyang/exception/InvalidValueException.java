/**
 * @author rui yang
 * Date: 07.09.2016
 */
package io.ruiyang.exception;

@SuppressWarnings("serial")
public class InvalidValueException extends InvalidInputException{
	
	String mMsg;
	
	public InvalidValueException(String msg){
		this.mMsg = msg;
	}

	@Override
	public String getMessage() {
		return this.mMsg;
	}

}
