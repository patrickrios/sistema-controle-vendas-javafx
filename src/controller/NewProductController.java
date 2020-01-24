package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.entity.Category;
import model.entity.Product;
import model.exception.EntityAlreadyExistException;
import model.util.MoneyRealFormat;
import view.exception.BackspaceInputException;
import view.exception.EmptyInputException;
import view.exception.InvalidCharacterException;
import view.util.TextInputValidation;

public class NewProductController implements Initializable{
	@FXML
    private Label labelConfirmRegister;
	@FXML
    private ImageView imageviewConfirmIcon;
    @FXML
    private TextField inputName;
    @FXML
    private TextField inputCode;
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
    @FXML
    private AnchorPane anchorCategories;
    
    private String values[] = new String[6];
    private ArrayList<Category> categories = new ArrayList<>();
    private int quantityValue=1;
    private int minInventValue=10;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	initiInputValidations();
    	initiFields();
    	loadCategories();
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
    	this.labelConfirmRegister.setVisible(false);
    }
    
    private void loadCategories() {
    	//TODO
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLCategorySelection.fxml"));
    	try {
			Parent categorySelect = loader.load();
			CategorySelectionController c = loader.getController();
			c.initi(this.categories);
			anchorCategories.getChildren().setAll(categorySelect);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
    
    @FXML
    void saveNewProduct() {
    	try {
			verifyEmptyInput(inputName,inputCode,inputSalePrice,inputQuantity,inputMinimus);
			getProductFromForm().createIfNotExist();
			showSucessLabel("Cadastrado com sucesso");
			resetForm();
		} 
    	catch (EmptyInputException emptyEx) {
			emptyEx.markAsEmpty();
		} 
    	catch (EntityAlreadyExistException e) {
			showExceptionLabel(e.toString());
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
    	this.labelCharEx.setLayoutY(y+53);
    	this.labelCharEx.setVisible(true);
    }
    
    private void verifyEmptyInput(TextField...fields) throws EmptyInputException{
    	for(int i=0; i<fields.length; i++) {
    		if(fields[i].getText().isEmpty() || fields[i]==null) {
    			throw new EmptyInputException(fields[i]);
    		}
    	}
    }
    
    private void showSucessLabel(String message) {
    	labelConfirmRegister.getStyleClass().clear();
    	labelConfirmRegister.getStyleClass().addAll("label","label-confirm-sucess");
    	labelConfirmRegister.setText(message);
    	setConfirmIcon("/view/img/checked-icon.png");
    	labelConfirmRegister.setVisible(true);
    }
    
    private void showExceptionLabel(String exception) {
    	labelConfirmRegister.getStyleClass().clear();
    	labelConfirmRegister.getStyleClass().addAll("label","label-confirm-exception");
    	labelConfirmRegister.setText(exception);
    	setConfirmIcon("/view/img/failed-icon.png");
    	labelConfirmRegister.setVisible(true);
    }
    
    private Product getProductFromForm() {
    	String name = inputName.getText();
    	String code = inputCode.getText();
    	float  cost = MoneyRealFormat.realStringToFloat(inputCostPrice.getText());
    	float  price = MoneyRealFormat.realStringToFloat(inputSalePrice.getText());
    	int	   quant = Integer.parseInt(inputQuantity.getText());
    	int	   mini  = Integer.parseInt(inputMinimus.getText());
    	
    	return new Product(name,code,cost,price,quant,mini,categories);
    }
    
    private void setConfirmIcon(String path) {
    	this.imageviewConfirmIcon.setImage(new Image(getClass().getResourceAsStream(path)));
    }
    
    
    private void resetForm() {
    	this.inputCode.setText("");
    	this.inputCostPrice.setText("");
    	this.inputMinimus.setText("10");
    	this.inputName.setText("");
    	this.inputQuantity.setText("1");
    	this.inputSalePrice.setText("");
    	this.categories.clear();
    }
}