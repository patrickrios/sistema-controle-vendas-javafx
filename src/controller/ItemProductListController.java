package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.bean.Product;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ItemProductListController
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


    public void init(Product product)
    {
        labelCode.setText(product.getCode());
        labelProductName.setText(product.getName());
        labelBarcode.setText("07893032021");
        labelPriceCost.setText("R$ 00,00");
        labelPriceSale.setText(product.getSalePriceText());
    }
}
