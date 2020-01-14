package view.exception;

public class InvaliCharacterException extends Exception {
	private String character;
	
	public InvaliCharacterException(String c) {
		this.character = c;
	}
	
	@Override
	public String toString() {
		return character+" is invalid";
	}
}