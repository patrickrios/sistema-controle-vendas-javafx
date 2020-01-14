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
    private Label labelInvalidChar;
    
    private String inputs[] = new String[6];
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	initiInputValidations();
	}
    
    private void initiInputValidations() {
    	labelInvalidChar.setVisible(false);
    	validateInput(textfieldName, new TextInputValidation(TextInputValidation.TEXT),0);
    	validateInput(textfieldCode, new TextInputValidation(TextInputValidation.NUMERIC),1);
    	validateInput(textfieldCostPrice,new TextInputValidation(TextInputValidation.DECIMAL),2);
    	validateInput(textfieldSalePrice,new TextInputValidation(TextInputValidation.DECIMAL),3);
    	validateInput(textfieldQuantity, new TextInputValidation(TextInputValidation.NUMERIC),4);
    	validateInput(textfieldMinInv, new TextInputValidation(TextInputValidation.NUMERIC),5);
    }
    
    private void validateInput(TextField txtfield, TextInputValidation valid, int index) {
    	inputs[index] = "";
    	txtfield.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
    	    @Override
    	    public void handle(KeyEvent event) {
    	        String character = event.getCharacter();    
    	        
    	        try {
					valid.validate(character);
					valid.backspaceCharacter(character);
					inputs[index] += character;
					labelInvalidChar.setVisible(false);
				} 
    	        catch (InvaliCharacterException e) {
    	        	event.consume();
    	        	textfieldAfterInvalidInput(txtfield,inputs[index]);
				} 
    	        catch (BackspaceInputException bse) {
    	        	removeLastChar(index);
    	        	txtfield.setText(inputs[index]);
    	        	txtfield.end();
				}
    	   }
    	});
    }
    
    @FXML
    void saveNewProduct() {
    	System.out.println("Product{");
    	System.out.println("\tname: "+inputs[0]);
    	System.out.println("\tcode: "+inputs[1]);
    	System.out.println("\tcost: "+inputs[2]);
    	System.out.println("\tprice: "+inputs[3]);
    	System.out.println("\tquant.: "+inputs[4]);
    	System.out.println("\tmin. inv.: "+inputs[5]);
    	System.out.println("}");
    }
    
    private void removeLastChar(int i) {
    	if( inputs[i] != null && inputs[i].length() > 0 )
    		inputs[i] = inputs[i].substring(0, inputs[i].length()-1);
    }
    
    private void textfieldAfterInvalidInput(TextField txtfield,String value) {
    	txtfield.clear();
    	txtfield.setText(value);
    	txtfield.end();
    	moveInvalidExceptionWarning(txtfield);
    }
    
    private void moveInvalidExceptionWarning(TextField tf) {
    	double x = tf.getLayoutX()+(tf.getWidth()-labelInvalidChar.getWidth());
    	double y = tf.getLayoutY();
    	
    	this.labelInvalidChar.setLayoutX(x);
    	this.labelInvalidChar.setLayoutY(y+50);
    	this.labelInvalidChar.setVisible(true);
    }
}