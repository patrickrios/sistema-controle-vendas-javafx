package view.exception;

public class BackspaceInputException extends Exception{
	
	public BackspaceInputException() {
		this.toString();
	}
	
	@Override
	public String toString() {
		return "Last character removed.";
	}

}
