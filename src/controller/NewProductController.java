package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import view.exception.BackspaceInputException;
import view.exception.InvaliCharacterException;
import view.util.TextInputValidation;

public class NewProductController implements Initializable{
    @FXML
    private TextField textfieldName;
    @FXML
    private TextField textfieldCode;
    @FXML
    private ChoiceBox<?> choiceboxCategories;
    @FXML
    private TextField textfieldCostPrice;
    @FXML
    private TextField textfieldSalePrice;
    @FXML
    private TextField textfieldQuantity;
    @FXML
    private TextField textfieldMinInv;
    @FXML
    private Label name;
    
    private String inputs[] = new String[6];
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	validateInput(textfieldName, new TextInputValidation("abc"), 0);
	}
    
    private void validateInput(TextField tf, TextInputValidation valid, int index) {
    	inputs[index] = "";
    	tf.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
    	    @Override
    	    public void handle(KeyEvent event) {
    	        String character = event.getCharacter();    
    	        
    	        try {
					valid.validate(character);
					valid.backspaceCharacter(character);
					inputs[index] += character;
					System.out.println("Name: "+inputs[index]);
				} 
    	        catch (InvaliCharacterException e) {
    	        	textfieldName.setText(inputs[index]);
    	        	textfieldName.end();
    	        	System.out.println("Name: "+inputs[index]);
				} 
    	        catch (BackspaceInputException bse) {
    	        	removeLastChar(index);
    	        	//textfieldName.setText(inputs[0]);
    	        	textfieldName.end();
    	        	System.out.println("Name: "+inputs[index]);
				}
    	   }});
    }
    
    @FXML
    void saveNewProduct() {
    	this.name.setText(inputs[0]);
    }
    
    private void removeLastChar(int i) {
    	
    	if( inputs[i] != null && inputs[i].length() > 0 )
    		inputs[i] = inputs[i].substring(0, inputs[i].length()-1);
    }

}
