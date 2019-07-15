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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLMain.fxml"));
            Parent parent = loader.load();

            stage.close();

            Stage mainStage = new Stage();
            mainStage.setMaximized(true);
            mainStage.setTitle("Controle de vendas");
            mainStage.setScene(new Scene(parent));
            mainStage.show();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void exitApp()
    {
        System.exit(0);
    }
}