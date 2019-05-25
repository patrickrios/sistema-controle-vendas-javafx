package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ItemProductListController implements Initializable
{
    @FXML
    private Label labelCode;

    @FXML
    private Label labelProductName;

    @FXML
    private Label labelBarcode;

    @FXML
    private Label labelPriceCost;

    @FXML
    private Label labelPriceSale;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    public void init(ArrayList<String> datas)
    {
        labelCode.setText(datas.get(0));
        labelProductName.setText(datas.get(1));
        labelBarcode.setText(datas.get(2));
        labelPriceCost.setText(datas.get(3));
        labelPriceSale.setText(datas.get(4));
    }
}
