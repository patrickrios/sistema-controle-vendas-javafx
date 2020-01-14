package view.util;

import view.exception.BackspaceInputException;
import view.exception.InvaliCharacterException;

public class TextInputValidation {
	private String type = "";
	public static String TEXT = "\\/[]{}";
	public static String NUMERIC = "0123456789";
	public static String DECIMAL = NUMERIC+",";
	
	public TextInputValidation(String validationType) {
		this.type = validationType;
	}
	
	public void validate(String c) throws InvaliCharacterException{
		char input = c.charAt(0);
		
		if(input !='\b') {
			if(this.type.equals(TEXT)) {
				if(textValidation(input))
					throw new InvaliCharacterException(c);
			}
			else if(this.type.equals(NUMERIC)) {
				if(numericValidation(input,NUMERIC))
					throw new InvaliCharacterException(c);
			}
			else{
				if(numericValidation(input, DECIMAL))
				throw new InvaliCharacterException(c);
			}	
		}
	}
	
	public void backspaceCharacter(String c) throws BackspaceInputException {
		char in = c.charAt(0);
		
		if(in == '\b')
			throw new BackspaceInputException();
	}
	
	private boolean textValidation(char c){
		boolean exist = false;
		
		for(int i=0; i<TEXT.length(); i++) {
			if(c == TEXT.charAt(i)) {
				exist = true;
				break;
			}
		}
		return exist;
	}
	
	private boolean numericValidation(char c, String type) {
		boolean notexist = true;
		
		for(int i=0; i<type.length();i++){
			if(c == type.charAt(i)) {
				notexist = false;
			}
		}
		return notexist;
	}
}