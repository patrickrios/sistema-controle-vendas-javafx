package controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.dao.CategoryDAO;
import model.entity.Category;
import model.exception.EntityAlreadyExistException;
import view.exception.EmptyInputException;

public class CategorySelectionController {
    @FXML
    private VBox vboxCategories;
    @FXML
    private TextField inputCategory;
    @FXML
    private Label labelCategoryEx;
    
    private ArrayList<Category> selectedCategories;
    
    private ArrayList<Category> categoriesOnDB;
    
    private int index=0;
    
    public void initi(ArrayList<Category> list) {
    	this.selectedCategories = list;
    	this.labelCategoryEx.setVisible(false);
    	loadCategoriesList();
    }
    
    private void loadCategoriesList() {
    	vboxCategories.getChildren().clear();
    	this.categoriesOnDB = new CategoryDAO().getAll();
    	for(Category cat : this.categoriesOnDB) {
    		addCategoryListItem(cat);
    	}
    }
    
    @FXML
    void saveNewCategory() {
    	try {
			String input = verifyInput();
			Category newCategory = new Category(input);
			newCategory.createIfNotExist();
			addCategoryListItem(newCategory);
			this.inputCategory.clear();
		} catch (EmptyInputException e) {
			e.markAsEmpty();
		} catch (EntityAlreadyExistException e) {
			this.labelCategoryEx.setText(e.toString());
			this.labelCategoryEx.setVisible(true);
		}
    }
    
    private void addCategoryListItem(Category cat) {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLCategorySelectionItem.fxml"));
		try {
			Parent item = loader.load();
			CategorySelectionItemController c = loader.getController();
			c.initi(cat,this.selectedCategories);
			if(isPair()) c.markAsPair();
			this.vboxCategories.getChildren().add(item);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private String verifyInput() throws EmptyInputException {
    	String input = "";
    	if(this.inputCategory.getText().isEmpty() || this.inputCategory==null)
    		throw new EmptyInputException(inputCategory);
    	else
    		input = this.inputCategory.getText();
    	return input;
    }
    
    private boolean isPair() {
    	boolean is=false;
    	if(this.index%2!=0) is = true;
    	this.index++;
    	return is;
    }
}