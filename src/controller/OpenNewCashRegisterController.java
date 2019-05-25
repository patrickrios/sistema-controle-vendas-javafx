package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import view.util.StringToReal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OpenNewCashRegisterController implements Initializable
{
    @FXML
    private AnchorPane anchorpaneContent;

    @FXML
    private TextField textfieldInitialValue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    @FXML
    public void openNewCashRegister()
    {
        String valueTextfield = textfieldInitialValue.getText();

        float value = StringToReal.stringToFloat(valueTextfield);

        System.out.println(value);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLPointOfSale.fxml"));

        try
        {
            Parent parent = loader.load();
            //invocar o controldador aqui
            Scene scene = new Scene(parent);

            Stage stage = new Stage();
            stage.setMaximized(true);
            stage.setTitle("Caixa aberto");
            stage.setScene(scene);
            stage.show();

            cancelOperation();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void cancelOperation()
    {
        anchorpaneContent.getScene().getWindow().hide();
    }
}
