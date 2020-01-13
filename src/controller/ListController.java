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

public class ListController implements Initializable{
	@FXML
    private AnchorPane anchorList;
	@FXML
    private ScrollPane scrollList;
	@FXML
    private VBox vboxList;
	
	private double itemWidth = 900;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	private void loadList() {
		
		for(int index=0; index<8; index++) {
			
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLListItem.fxml"));
				Parent item = loader.load();
				ListItemController c = loader.getController();
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
