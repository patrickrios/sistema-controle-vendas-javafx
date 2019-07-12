package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    @FXML
    void loadForgetPassword()
    {

    }

    @FXML
    void login()
    {
        Stage stage = (Stage) anchorMain.getScene().getWindow();

        try
        {
            Parent parent = FXMLLoader.load(getClass().getResource("/view/fxml/FXMLMain.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setResizable(true);
            stage.setMaximized(true);
            stage.show();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
