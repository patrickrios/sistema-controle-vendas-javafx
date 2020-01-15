package view.exception;


public class EmptyInputException extends Exception{
	
	private String txtfieldID;
	
	public EmptyInputException(String txtfield) {
		this.txtfieldID = txtfield;
	}
	
	@Override
	public String toString() {
		return txtfieldID+" is empty.";
	}
}
