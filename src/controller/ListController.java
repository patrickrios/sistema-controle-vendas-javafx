package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.dao.ListableEntity;
import model.entity.EntityList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
	
	public void initi(ListableEntity listable, String...columns) {
		this.list = new EntityList(listable);
	}
	
	private void loadList() {
		for(int index=0; index<8; index++) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLListItemProduct.fxml"));
				Parent item = loader.load();
				ListItemProductController c = loader.getController();
				this.vboxList.getChildren().add(item);
				c.initiAfterAdded(itemWidth, index);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void initiAfterAdded(double width, double height) {
		this.anchorList.setPrefSize(width,height);
		this.itemWidth = width;
		loadList();
	}
}
