package view.exception;

import javafx.scene.control.TextField;

public class EmptyInputException extends Exception{
	
	private TextField textfield;
	
	public EmptyInputException(TextField txtfield) {
		this.textfield = txtfield;
	}
	
	@Override
	public String toString() {
		return textfield.getId()+" is empty.";
	}
	
	public void markAsEmpty() {
    	this.textfield.getStyleClass().add("textfield-empty");
    }
}
