package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.bean.Sale;

import java.net.URL;
import java.util.ResourceBundle;

public class ListSalesItemController
{
    @FXML
    private Label labelSaleCode;

    @FXML
    private Label labelNumItens;

    @FXML
    private Label labelTotalValue;

    @FXML
    private Label labelDateTime;


    public void init(Sale sale)
    {
        labelNumItens.setText(labelNumItens.getText().replace("$num", ""+sale.getNumberOfItens()));
        labelTotalValue.setText(sale.getTotalValueFormatted());
    }
}
