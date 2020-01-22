package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.dao.ListableEntity;
import model.entity.EntityList;
import model.entity.PersistentEntity;
import model.exception.EmptyArrayListException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ListController{
    @FXML
    private AnchorPane anchorList;
    @FXML
    private Label labelTitle;
    @FXML
    private ScrollPane scrollList;
    @FXML
    private VBox vboxList;
    @FXML
    private Button buttonPagNavLeft;
    @FXML
    private Label labelPagination;
    @FXML
    private Button buttonPagNavRight;
    @FXML
    private AnchorPane anchorListHeader;
    @FXML
    private TextField inputSearch;
	
	private double itemWidth = 900;
	
	private EntityList list;
	
	private String[] columns = null;
	
	private String itemLayoutPath;
	
	public void initi(ListableEntity listable, String...columns) {
		this.list = new EntityList(listable);
		this.columns = columns;
		this.itemLayoutPath = listable.itemLayoutPath();
	}
	
	@FXML
    void nextPage() {

    }

    @FXML
    void previousPage() {

    }
    
    private void initiHeader() {
    	if(columns.length>0 && columns!=null) {
	    	double eachColumn = (itemWidth-160)/columns.length;
	    	double margin = 60.0;
	    	for(int i=0;i<columns.length;i++) {
	    		Label column = new Label(columns[i].toUpperCase());
	    		column.setLayoutX(margin);
	    		anchorListHeader.getChildren().add(column);
	    		margin += eachColumn;
	    	}
    	}
    }
    
    private void updatePaginationControls() {
    	if(this.list.isFirstPage())
    		disablePagNavButtton(buttonPagNavLeft,"pag-button-disable-left.png");
    	else
    		enablePagNavButton(buttonPagNavLeft,"pag-button-enable-left.png");
    	
    	if(this.list.isLastPage())
    		disablePagNavButtton(buttonPagNavRight,"pag-button-disable-right.png");
    	else
    		enablePagNavButton(buttonPagNavRight,"pag-button-enable-right.png");
    }
    
    private void updatePaginationInfo() {
    	this.labelPagination.setText(this.list.getPaginationInfo());
    }

	
	private void loadList() {
		int index=0;
		try {
			for(Object obj : this.list.getItems()) {
				PersistentEntity entity = (PersistentEntity)obj;
				FXMLLoader loader = new FXMLLoader(getClass().getResource(this.itemLayoutPath));
				Parent item = loader.load();
				ListItemController c = loader.getController();
				c.initi(entity);
				this.vboxList.getChildren().add(item);
				c.initiAfterAdded(itemWidth, index);
				index++;
			}
		} 
		catch (EmptyArrayListException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void initiAfterAdded(double width, double height) {
		this.anchorList.setPrefSize(width,height);
		this.itemWidth = width;
		initiHeader();
		updatePaginationInfo();
		updatePaginationControls();
		loadList();
	}
	
	private void disablePagNavButtton(Button b, String iconPath) {
		String path = "/view/img/";
		path += iconPath;
		b.setGraphic(new ImageView(new Image(getClass().getResourceAsStream(path))));
		b.setDisable(true);
	}
	
	private void enablePagNavButton(Button b, String iconPath) {
		String path = "/view/img/";
		path += iconPath;
		b.setGraphic(new ImageView(new Image(getClass().getResourceAsStream(path))));
		b.setDisable(false);
	}
}
