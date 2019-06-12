package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.bean.CashRegister;
import model.bean.Product;
import model.bean.Sale;
import model.dao.ProductDAO;

import java.io.IOException;
import java.util.ArrayList;

public class PointOfSaleController
{
    @FXML
    private Label labelSaldo;

    @FXML
    private Label labelSaleTotalValue;

    @FXML
    private VBox vboxSearch;

    @FXML
    private AnchorPane anchorpaneSearchItens;

    @FXML
    private VBox vboxSaleItensView;

    @FXML
    private Label labelShowingResultItens;

    private CashRegister cashRegister;

    private Sale sale;


    public void inti(CashRegister cashRegister)
    {
        this.cashRegister = cashRegister;
        this.sale = new Sale();
        this.labelSaldo.setText(this.labelSaldo.getText().replace("$saldo", cashRegister.getInitialValueFormatted()));
        this.labelSaleTotalValue.setText(this.sale.getTotalValueFormatted());
    }

    @FXML
    public void findItemToSale()
    {
        ArrayList<Product> list = new ProductDAO().findAll();

        vboxSearch.getChildren().clear();

        for(Product p : list)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLResultProductSearchItem.fxml"));

            try
            {
                Parent item = loader.load();
                ItemResultProductSearchController controller = loader.getController() ;
                controller.initi(p, this.sale);
                vboxSearch.getChildren().add(item);
            }

            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        this.anchorpaneSearchItens.setVisible(true);
        String numberResult = this.labelShowingResultItens.getText().replace("$n", ""+list.size());
        this.labelShowingResultItens.setText(numberResult);
    }

    @FXML
    void closeSearchItensResult()
    {
        //this.anchorpaneSearchItens.setVisible(false);
        this.vboxSearch.getChildren().clear();
        String numberResult = this.labelShowingResultItens.getText().replace("$n", "0");
        this.labelShowingResultItens.setText(numberResult);
    }

    @FXML
    void resetCurrentSale()
    {
        this.sale.resetSale();
        this.labelSaleTotalValue.setText(this.sale.getTotalValueFormatted());
        this.closeSearchItensResult();
        this.vboxSaleItensView.getChildren().clear();
    }

    @FXML
    public void finishSale()
    {
        if(!this.sale.isListEmpty())
        {
            this.sale.finishSale();
            this.resetCurrentSale();
        }
    }

}