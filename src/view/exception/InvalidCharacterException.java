package view.exception;

public class InvalidCharacterException extends Exception {
	private String character;
	
	public InvalidCharacterException(String c) {
		this.character = c;
	}
	
	@Override
	public String toString() {
		return character+" is invalid";
	}
}