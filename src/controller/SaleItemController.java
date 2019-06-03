package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.bean.Sale;
import model.bean.SaleItem;

public class SaleItemController
{
    @FXML
    private AnchorPane anchorpaneSalteItemList;

    @FXML
    private Label labelItemName;

    @FXML
    private TextField textfieldItemQuantity;

    @FXML
    private Label labelSubtotal;

    @FXML
    private Label labelCodeItem;

    private SaleItem item;

    private Sale sale;

    public void initi(SaleItem item, Sale sale)
    {
        this.labelItemName.setText(item.getNameItem());
        this.labelSubtotal.setText(item.getSubtotalFormatted());
        this.textfieldItemQuantity.setText(""+item.getQuantity());
        this.labelCodeItem.setText(item.getProductCode());
        this.item = item;
        this.sale = sale;
    }

    @FXML
    void removeItem()
    {
        this.sale.removeItemFromSale(this.item);
        updateSaleTotalValueView();
        removeSaleItemFromView();
    }

    @FXML
    void decreaseQuantity()
    {
        this.sale.updateRemoveTotalValue(this.item.getSubtotal());
        this.item.decreaseQuantity();
        this.sale.updateAddTotalValue(this.item.getSubtotal());
        updateQuantityAndSubtotalView();
        updateSaleTotalValueView();
    }

    @FXML
    void increaseQuantity()
    {
        this.sale.updateRemoveTotalValue(this.item.getSubtotal());
        this.item.increaseQuantity();
        this.sale.updateAddTotalValue(this.item.getSubtotal());
        updateQuantityAndSubtotalView();
        updateSaleTotalValueView();
    }

    private void removeSaleItemFromView()
    {
        VBox vboxSaleItensView = (VBox) anchorpaneSalteItemList.getParent();
        vboxSaleItensView.getChildren().remove(anchorpaneSalteItemList);
    }

    private void updateQuantityAndSubtotalView()
    {
        this.labelSubtotal.setText(this.item.getSubtotalFormatted());
        this.textfieldItemQuantity.setText(""+this.item.getQuantity());
    }

    private void updateSaleTotalValueView()
    {
        Label label = (Label)anchorpaneSalteItemList.getScene().lookup("#labelSaleTotalValue");
        label.setText(this.sale.getTotalValueFormatted());
    }
}
