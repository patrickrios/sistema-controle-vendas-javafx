package controller;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import model.entity.Category;

public class CategorySelectionItemController {
	@FXML
    private AnchorPane anchorCategoryItem;
	 @FXML
	 private CheckBox checkSelectCategory;
	 
	 private Category cat;
	 
	 private ArrayList<Category> catList;
	 
	 public void initi(Category cat, ArrayList<Category> list) {
		 this.cat = cat;
		 this.catList = list;
		 this.checkSelectCategory.setText(cat.getName());
	 }
	 
	 @FXML
	 void switchCheckboxStatus(){
		 
		 if(checkSelectCategory.isSelected()) {
			 this.catList.add(this.cat);
			 markAsSelected();
		 }
		 else {
			 for(Category cat : catList) {
				 if(checkSelectCategory.getText().equals(cat.getName())) {
					 catList.remove(cat);
					 break;
				 }
			 }
			 unmarkAsSelected();
		 }
			 
	 }
	 
	 private void markAsSelected() {
		 this.anchorCategoryItem.getStyleClass().add("list-category-item-selected");
	 }
	 
	 private void unmarkAsSelected() {
		 this.anchorCategoryItem.getStyleClass().remove("list-category-item-selected");
	 }
	 
	 public void markAsPair() {
		 this.anchorCategoryItem.getStyleClass().add("list-item-pair");
	 }
}
