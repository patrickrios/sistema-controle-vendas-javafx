package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import view.exception.BackspaceInputException;
import view.exception.EmptyInputException;
import view.exception.InvalidCharacterException;
import view.util.TextInputValidation;

public class NewProductController implements Initializable{
    @FXML
    private TextField inputName;
    @FXML
    private TextField inputCode;
    @FXML
    private ChoiceBox<?> choiceboxCategories;
    @FXML
    private TextField inputCostPrice;
    @FXML
    private TextField inputSalePrice;
    @FXML
    private TextField inputQuantity;
    @FXML
    private TextField inputMinimus;
    @FXML
    private Label labelCharEx;
    
    private String values[] = new String[6];
    private int quantityValue=1;
    private int minInventValue=10;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	initiInputValidations();
    	initiFields();
	}
    
    private void initiInputValidations() {
    	labelCharEx.setVisible(false);
    	validateInput(inputName, new TextInputValidation(TextInputValidation.TEXT),0);
    	validateInput(inputCode, new TextInputValidation(TextInputValidation.NUMERIC),1);
    	validateInput(inputCostPrice,new TextInputValidation(TextInputValidation.DECIMAL),2);
    	validateInput(inputSalePrice,new TextInputValidation(TextInputValidation.DECIMAL),3);
    	validateInput(inputQuantity, new TextInputValidation(TextInputValidation.NUMERIC),4);
    	validateInput(inputMinimus, new TextInputValidation(TextInputValidation.NUMERIC),5);
    }
    
    private void initiFields() {
    	this.inputQuantity.setText(""+this.quantityValue);
    	this.inputMinimus.setText(""+this.minInventValue);
    }
    
    @FXML
    void incrementQuantity() {
    	this.quantityValue++;
    	this.inputQuantity.setText(""+quantityValue);
    }
    
    @FXML
    void decrementQuantity() {
    	if(this.quantityValue > 1) {
    		this.quantityValue--;
    		this.inputQuantity.setText(""+quantityValue);
    	}
    }
    
    private void validateInput(TextField txtfield, TextInputValidation validator, int index) {
    	values[index] = "";
    	txtfield.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
    	    @Override
    	    public void handle(KeyEvent event) {
    	        String character = event.getCharacter();
    	        
    	        try {
					validator.validate(character);
					validator.backspaceCharacter(character);
					values[index] += character;
					labelCharEx.setVisible(false);
				} 
    	        catch (InvalidCharacterException e) {
    	        	event.consume();
    	        	textfieldAfterInvalidInput(txtfield,values[index]);
				} 
    	        catch (BackspaceInputException bse) {
    	        	removeLastChar(index);
    	        	txtfield.setText(values[index]);
    	        	txtfield.end();
				}
    	    }
    	});
    }
    
    private void removeLastChar(int i) {
    	if( values[i] != null && values[i].length() > 0 )
    		values[i] = values[i].substring(0, values[i].length()-1);
    }
    
    private void textfieldAfterInvalidInput(TextField txtfield,String value) {
    	txtfield.clear();
    	txtfield.setText(value);
    	txtfield.end();
    	moveInvalidExceptionWarning(txtfield);
    }
    
    private void moveInvalidExceptionWarning(TextField tf) {
    	double x = tf.getLayoutX()+(tf.getWidth()-labelCharEx.getWidth());
    	double y = tf.getLayoutY();
    	
    	this.labelCharEx.setLayoutX(x);
    	this.labelCharEx.setLayoutY(y+50);
    	this.labelCharEx.setVisible(true);
    }
    
    @FXML
    void saveNewProduct() {
    	try {
			verifyEmptyInput(inputName,inputCode,inputSalePrice,inputQuantity,inputMinimus);
			printStatus();
		} catch (EmptyInputException e) {
			System.out.println(e.toString());
		}
    }
    
    private void verifyEmptyInput(TextField...fields) throws EmptyInputException{
    	for(int i=0; i<fields.length; i++) {
    		if(fields[i].getText().isEmpty() || fields[i]==null) {
    			markAsEmpty(fields[i]);
    			throw new EmptyInputException(fields[i].getId());
    		}
    	}
    }
    
    private void markAsEmpty(TextField tf) {
    	tf.getStyleClass().add("textfield-empty");
    }
    
    private void unmarkAsEmpty(TextField tf) {
    	tf.getStyleClass().remove("textfield-empty");
    }
    
    //Just for test
    private void printStatus() {
    	System.out.println("Product{");
    	System.out.println("\tname: "+values[0]);
    	System.out.println("\tcode: "+values[1]);
    	System.out.println("\tcost: "+values[2]);
    	System.out.println("\tprice: "+values[3]);
    	System.out.println("\tquant.: "+values[4]);
    	System.out.println("\tmin. inv.: "+values[5]);
    	System.out.println("}");
    }
}