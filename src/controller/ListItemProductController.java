package controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.entity.PersistentEntity;
import model.entity.Product;

public class ListItemProductController implements ListItemController {
    @FXML
    private AnchorPane anchorItem;
    @FXML
    private CheckBox choiceboxProdItem;
    @FXML
    private Label labelProdName;
    @FXML
    private Label labelProdCode;
    @FXML
    private Label labelSalePrice;
    @FXML
    private Label labelProdQuanity;
    
    private Product product;
    
    private Label[] labels = new Label[4];//= {labelProdName,labelProdCode,labelSalePrice,labelProdQuanity};
    
    @Override
    public void initi(PersistentEntity product) {
    	this.product= (Product)product;
    	populateArrayLabels();
    	initiLabels();
    }
    
    @Override
	public void initiAfterAdded(double width, int index) {
    	fullWidthSize(width);
    	markAsPair(index);
    	defineLabelMarginLayout(width);
    }
    
    private void initiLabels() {
    	labelProdName.setText(this.product.getName());
    	labelProdCode.setText(this.product.getCode());
    	labelSalePrice.setText(this.product.formattedSalePrice());
    }
    
    private void fullWidthSize(double width) {
    	this.anchorItem.setPrefWidth(width-62);
    }
    
    private void markAsPair(int index) {
    	if(index%2 != 0)
    		this.anchorItem.getStyleClass().add("list-item-pair");
    }
    
    private void populateArrayLabels() {
    	labels[0] = this.labelProdName;
    	labels[1] = this.labelProdCode;
    	labels[2] = this.labelSalePrice;
    	labels[3] = this.labelProdQuanity;
    }
    
    private void defineLabelMarginLayout(double width) {
    	double space = (width-160)/this.labels.length;
    	double margin = 60.0;
    	
    	for(int i=0;i<labels.length; i++) {
    		this.labels[i].setLayoutX(margin);
    		margin += space;
    	}
    	
    }
}