package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class ListItemController {
    @FXML
    private AnchorPane anchorItem;
    
    public void initi() {
    	//TODO
    }
    
    protected void initiAfterAdded(double width, int index) {
    	fullWidthSize(width);
    	markAsPair(index);
    }
    
    private void fullWidthSize(double width) {
    	this.anchorItem.setPrefWidth(width-62);
    }
    
    private void markAsPair(int index) {
    	if(index%2 != 0)
    		this.anchorItem.getStyleClass().add("list-item-pair");
    }
}