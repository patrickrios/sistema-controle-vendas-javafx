package controller;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;

public class ListItemCategoryController {
	@FXML
    private AnchorPane anchorCategoryItem;
	 @FXML
	 private CheckBox checkSelectCategory;
	 
	 private ArrayList<String> catList;
	 
	 public void initi(int i, ArrayList<String> list) {
		 this.checkSelectCategory.setText(names(i));
		 this.catList = list;
	 }
	 
	 @FXML
	 void switchCheckboxStatus(){
		 
		 if(checkSelectCategory.isSelected()) {
			 this.catList.add(checkSelectCategory.getText());
			 markAsSelected();
		 }
		 else {
			 for(String cat : catList) {
				 if(checkSelectCategory.getText().equals(cat)) {
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
	 
	 //just for test, must be removed later
	 private String names(int i) {
		 String name = "sem nome";
		 if(i==0) name="Informática";
		 if(i==1) name="Acessórios para escritório";
		 if(i==2) name="Celulares";
		 if(i==3) name="Informática";
		 if(i==4) name="Gadgets";
		 if(i==5) name="Notebooks";
		 if(i==6) name="Papelaria";
		 if(i==7) name="Baterias";
			return name;
	 }

}
