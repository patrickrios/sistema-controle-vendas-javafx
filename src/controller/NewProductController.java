package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private TextField textfieldProductCode;

    @FXML
    private Label labelProductCode;

    @FXML
    private Button buttonProdCodeGen;

    @FXML
    private TextField textfieldBarcode;

    @FXML
    private Label labelBarcode;

    @FXML
    private Button buttonBarcodeGen;

    @FXML
    private TextField textfieldCostPrice;

    @FXML
    private TextField textfieldSalePrice;

    @FXML
    private TextField textfieldProductQuantity;

    private int productQuantity = 1;

    private boolean genBarcodeControl = false;

    private boolean genProdCodeControl = false;

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
    public void autoGenerateProductCode()
    {
        Image icon;
        if(!this.genProdCodeControl) {
            this.textfieldProductCode.setDisable(true);
            this.labelProductCode.setDisable(true);
            this.genProdCodeControl = true;
            icon = new Image(getClass().getResourceAsStream("/view/img/toggle-on-icon-52x32.png"));
        }
        else {
            this.textfieldProductCode.setDisable(false);
            this.labelProductCode.setDisable(false);
            this.genProdCodeControl = false;
            icon = new Image(getClass().getResourceAsStream("/view/img/toggle-off-icon-52x32.png"));
        }
        this.buttonProdCodeGen.setGraphic(new ImageView(icon));
    }

    @FXML
    public void autoGenerateBarcode()
    {
        Image icon;
        if(!this.genBarcodeControl) {
            this.textfieldBarcode.setDisable(true);
            this.labelBarcode.setDisable(true);
            this.genBarcodeControl = true;
            icon = new Image(getClass().getResourceAsStream("/view/img/toggle-on-icon-52x32.png"));
        }
        else {
            this.textfieldBarcode.setDisable(false);
            this.labelBarcode.setDisable(false);
            this.genBarcodeControl = false;
            icon = new Image(getClass().getResourceAsStream("/view/img/toggle-off-icon-52x32.png"));
        }
        this.buttonBarcodeGen.setGraphic(new ImageView(icon));
    }

    @FXML
    void saveNewProduct()
    {
        ProductDAO productDAO = new ProductDAO();
        productDAO.save(this.getProductFromForm());
        this.resetFields();
        this.showSucessLabel();
    }

    @FXML
    public void resetFields()
    {
        this.textfieldProductName.setText("");
        this.textfieldProductCode.setText("");
        this.textfieldBarcode.setText("");
        this.textfieldCostPrice.setText("");
        this.textfieldSalePrice.setText("");
        this.textfieldProductQuantity.setText("1");
        this.productQuantity = 1;
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