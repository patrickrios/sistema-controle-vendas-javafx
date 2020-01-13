package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

public class MainLoginPageController
{
    @FXML
    private AnchorPane anchorMain;
    @FXML
    private TextField textfieldUsername;
    @FXML
    private PasswordField textfieldPassword;
    @FXML
    private CheckBox chehckboxKeepConnected;
    
    private double xOffset = 0; 
	private double yOffset = 0;

    @FXML
    void loadForgetPassword(){

    }

    @FXML
    void login(){
        Stage stage = (Stage) anchorMain.getScene().getWindow();

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLMain.fxml"));
            Parent parent = loader.load();

            stage.close();

            Stage mainStage = new Stage();
            Scene mainScene = new Scene(parent);
            setSceneSize(mainStage);
            mainStage.initStyle(StageStyle.TRANSPARENT);
            draggable(mainScene,mainStage);
            mainStage.setScene(mainScene);
            mainStage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void exitApp(){
        System.exit(0);
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