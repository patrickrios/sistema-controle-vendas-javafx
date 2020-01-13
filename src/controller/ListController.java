package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import view.util.FullSizeConteiner;

public class ListController {
	@FXML
    private AnchorPane anchorList;
	
	void fullSize() {
		FullSizeConteiner.fullOnScroll(this.anchorList);
	}
}
