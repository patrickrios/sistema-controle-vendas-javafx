package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.bean.Sale;
import view.util.FadeEffectTransition;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListSalesItemController
{
    @FXML
    private AnchorPane anchorListeSaleItem;

    @FXML
    private Label labelSaleCode;

    @FXML
    private Label labelNumItens;

    @FXML
    private Label labelTotalValue;

    @FXML
    private Label labelDateTime;

    @FXML
    private CheckBox checkboxItem;


    public void init(Sale sale)
    {
        this.labelNumItens.setText(labelNumItens.getText().replace("$num", ""+sale.getNumberOfItens()));
        this.labelTotalValue.setText(sale.getTotalValueFormatted());
        this.checkboxItem.setSelected(false);
    }

    @FXML
    public void checkboxSelected()
    {
        if(this.checkboxItem.isSelected()) {
            this.anchorListeSaleItem.getStyleClass().add("list-sale-item-selected");
        }
        else {
            this.anchorListeSaleItem.getStyleClass().clear();
            this.anchorListeSaleItem.getStyleClass().add("anchor-list-item");
        }
    }

    @FXML
    public void viewDetails()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLSaleDetails.fxml"));

        try
        {
            Parent parent = loader.load();
            Scene scene = this.anchorListeSaleItem.getScene();
            AnchorPane mainContent = (AnchorPane) scene.lookup("#anchorpaneMainContent");
            new FadeEffectTransition(parent);
            mainContent.getChildren().setAll(parent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
