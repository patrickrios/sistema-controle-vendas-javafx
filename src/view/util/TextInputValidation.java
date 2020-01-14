package view.util;

import view.exception.BackspaceInputException;
import view.exception.InvaliCharacterException;

public class TextInputValidation {
	private String characters;
	
	public TextInputValidation(String characters) {
		this.characters = characters;
	}
	
	public void validate(String c) throws InvaliCharacterException{
		char in = c.charAt(0);
		boolean notExist = true;
		
		if(in !='\b') {
			for(int i=0; i<this.characters.length(); i++) {
				if(this.characters.charAt(i) == in) {
					notExist = false;
					break;
				}
			}
			
			if(notExist) throw new InvaliCharacterException(c);
		}
	}
	
	public void backspaceCharacter(String c) throws BackspaceInputException {
		char in = c.charAt(0);
		
		if(in == '\b')
			throw new BackspaceInputException();
	}

}
