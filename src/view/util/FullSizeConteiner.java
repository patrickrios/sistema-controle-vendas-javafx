package view.util;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

public class FullSizeConteiner {
	
	public static void fullOnScroll(AnchorPane anchor) {
		ScrollPane sc = (ScrollPane)anchor.getScene().lookup("#scrollContent");
		double width = sc.getWidth();
		double height = sc.getHeight();
		
		anchor.setPrefSize(width, height);
	}

}
