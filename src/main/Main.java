package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application
{
	private double xOffset = 0; 
	private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/fxml/FXMLLoginPage.fxml"));
        Scene root = new Scene(parent);
        
        primaryStage.setScene(root);
        setSceneSize(primaryStage);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        draggable(root, primaryStage);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
    private void draggable(Scene root, Stage stage) {
    	root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
    }  
    
    private void setSceneSize(Stage stage) {
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	double width = screenSize.getWidth();
    	double height = screenSize.getHeight()-40;
    	stage.setWidth(width);
    	stage.setHeight(height);
    }
}
