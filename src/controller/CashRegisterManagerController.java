package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class CashRegisterManagerController
{
    @FXML
    void openNewCashRegister()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLOpenNewCashRegister.fxml"));

        try
        {
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
