package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.bean.CashRegister;
import model.bean.Product;
import model.bean.Sale;
import model.bean.SaleItem;
import model.dao.ProductDAO;
import view.util.StringToReal;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PointOfSaleController implements Initializable
{
    @FXML
    private Label labelSaldo;

    @FXML
    private VBox vboxSearch;

    @FXML
    private ScrollPane scrollpaneSearch;

    @FXML
    private VBox vboxSaleItensView;

    private CashRegister cashRegister;

    private Sale sale;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        scrollpaneSearch.setVisible(false);
    }

    public void inti(CashRegister cashRegister)
    {
        this.cashRegister = cashRegister;
        this.sale = new Sale();
        this.labelSaldo.setText(this.labelSaldo.getText().replace("$saldo", cashRegister.getInitialValueFormatted()));
    }

    @FXML
    public void findItemToSale()
    {
        ArrayList<Product> list = new ProductDAO().findAll();

        vboxSearch.getChildren().clear();

        for(Product p : list)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLItemResultProductSearch.fxml"));

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

        scrollpaneSearch.setVisible(true);
    }

}