package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.bean.Product;
import model.dao.ProductDAO;
import view.util.FadeEffectTransition;
import view.util.StringToReal;
import view.util.SucessConfirmationLabelController;

import java.io.IOException;

public class NewProductController
{
    @FXML
    private TextField textfieldProductName;

    @FXML
    private TextField textfieldBarcode;

    @FXML
    private TextField textfieldCostPrice;

    @FXML
    private TextField textfieldSalePrice;

    @FXML
    private TextField textfieldProductQuantity;

    private int productQuantity = 1;

    @FXML
    public void increaseProductQuantity()
    {
        this.productQuantity++;
        textfieldProductQuantity.setText(""+this.productQuantity);
    }

    @FXML
    public void decreaseProductQuantity()
    {
        if(this.productQuantity > 1)
        {
            this.productQuantity--;
            this.textfieldProductQuantity.setText(""+this.productQuantity);
        }
    }

    @FXML
    public void setProductQuantity()
    {
        if(!this.textfieldProductQuantity.getText().isEmpty())
        {
            this.productQuantity = Integer.parseInt(textfieldProductQuantity.getText());
            this.textfieldProductQuantity.setText(""+this.productQuantity);
        }
    }

    @FXML
    void saveNewProduct()
    {
        ProductDAO productDAO = new ProductDAO();
        productDAO.save(this.getProductFromForm());
        this.resetFields();
        this.showSucessLabel();
    }

    private Product getProductFromForm()
    {
        String name = textfieldProductName.getText();
        String code = textfieldBarcode.getText();
        float costPrice = StringToReal.stringToFloat(textfieldCostPrice.getText());
        float salePrice = StringToReal.stringToFloat(textfieldSalePrice.getText());
        int quant = this.productQuantity;

        return new Product(code, name, costPrice, salePrice, quant);
    }

    private void resetFields()
    {
        this.textfieldProductName.setText("");
        this.textfieldBarcode.setText("");
        this.textfieldCostPrice.setText("");
        this.textfieldSalePrice.setText("");
        this.textfieldProductQuantity.setText("1");
        this.productQuantity = 1;
    }

    private void showSucessLabel()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/util/FXMLSucessConfirmationLabel.fxml"));

        try
        {
            Parent parent = loader.load();
            SucessConfirmationLabelController controller = loader.getController();
            controller.init("Produto cadastrado com sucesso");
            new FadeEffectTransition(parent);
            AnchorPane anchor = (AnchorPane)textfieldProductName.getParent();
            anchor.getChildren().add(parent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
