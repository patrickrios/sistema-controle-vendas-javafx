package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SaleDetailsController implements Initializable
{
    @FXML
    private VBox vboxSaleItensList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        loadSaleItensList();
    }

    private void loadSaleItensList()
    {
        for(int i=0; i<6; i++)
        {
            try
            {
                Parent parent= FXMLLoader.load(getClass().getResource("/view/fxml/FXMLSaleDetailsListItem.fxml"));
                this.vboxSaleItensList.getChildren().add(parent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
