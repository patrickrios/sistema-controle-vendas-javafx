package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.bean.Product;
import model.bean.Sale;
import model.bean.SaleItem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemResultProductSearchController implements Initializable
{
    @FXML
    private Pane paneItemResultSearchContent;

    @FXML
    private Label labelProductName;

    @FXML
    private Label labelSalePrice;

    private Sale sale;

    private Product product;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    public void initi(Product product, Sale sale)
    {
        this.labelProductName.setText(product.getName());
        this.labelSalePrice.setText(product.getSalePriceText());
        this.sale = sale;
        this.product = product;
    }

    @FXML
    void addItemToSale()
    {
        SaleItem item = new SaleItem(this.product);

        if(this.sale.addItemToSale(item))
        {
            addSaleItemOnView(item);
            updateTotalValueLabelView();
        }

        closeResultSearch();
    }

    private void addSaleItemOnView(SaleItem item)
    {
        VBox listItens = (VBox) paneItemResultSearchContent.getScene().lookup("#vboxSaleItensView");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLSaleItem.fxml"));

        try
        {
            Parent parent = loader.load();
            SaleItemController controller = loader.getController();
            controller.initi(item, this.sale);
            listItens.getChildren().add(parent);
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    private void closeResultSearch()
    {
        AnchorPane searchScroll = (AnchorPane) paneItemResultSearchContent.getScene().lookup("#anchorpaneSearchItens");
        searchScroll.setVisible(false);
    }


    private void updateTotalValueLabelView()
    {
        Label label = (Label)paneItemResultSearchContent.getScene().lookup("#labelSaleTotalValue");
        label.setText(this.sale.getTotalValueFormatted());
    }

}