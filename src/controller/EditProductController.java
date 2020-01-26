package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import model.entity.Category;
import model.entity.Product;
import view.util.FullSizeConteiner;
import view.util.RealFormat;

public class EditProductController {
    @FXML
    private AnchorPane anchorEditProduct;
    @FXML
    private TextField inputName;
    @FXML
    private TextField inputCode;
    @FXML
    private Label labelCategories;
    @FXML
    private TextField inputCostPrice;
    @FXML
    private TextField inputSalePrice;
    @FXML
    private TextField inputMinimum;
    @FXML
    private TextField inputQuantity;
    
    private Product product;
    
    public void initi(Product product) {
    	this.product = product;
    	initiInputs();
    }
    
    private void initiInputs() {
    	this.inputName.setText(product.getName());
    	this.inputCode.setText(product.getCode());
    	this.inputCostPrice.setText(RealFormat.stringWithoutPrefix(product.getCostPrice()));
    	this.inputSalePrice.setText(RealFormat.stringWithoutPrefix(product.getSalePrice()));
    	this.inputMinimum.setText(product.getMinimumQuantity()+"");
    	this.inputQuantity.setText(product.getQuantiy()+"");
    	
    	//if(!product.getCategories().isEmpty()&&product.getCategories()!=null)
    	//	for(Category cat : product.getCategories())
    	//this.labelCategories.setText(this.labelCategories.getText()+", "+cat.getName());
    }
    
	@FXML
	void close() {
		StackPane stack = (StackPane)anchorEditProduct.getScene().lookup("#stackListView");
		stack.getChildren().remove(this.anchorEditProduct);
	}
	
	protected void fullSize() {
		StackPane stack = (StackPane)anchorEditProduct.getScene().lookup("#stackListView");
		double width = stack.getWidth();
		double height = stack.getHeight();
		
		this.anchorEditProduct.setPrefSize(width,height);
	}

}
