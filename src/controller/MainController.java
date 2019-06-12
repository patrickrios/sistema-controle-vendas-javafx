package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.dao.ProductDAO;
import model.dao.SalesDAO;
import view.util.FadeEffectTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{
    @FXML
    private AnchorPane anchorpaneMainContent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        loadHomepageScreen();
    }

    @FXML
    public void loadNewProductScreen()
    {
        try
        {
            Parent parent = FXMLLoader.load(getClass().getResource("/view/fxml/FXMLNewProduct.fxml"));

            new FadeEffectTransition(parent);

            anchorpaneMainContent.getChildren().setAll(parent);
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadSalesHistoryScreen()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLList.fxml"));

        try
        {
            Parent parent = loader.load();
            ListController controller = loader.getController();
            controller.init(new SalesDAO(), "Vendas  >  Histórico de vendas");
            controller.setListHeader("/view/fxml/FXMLListSaleHeader.fxml");
            new FadeEffectTransition(parent);
            anchorpaneMainContent.getChildren().setAll(parent);
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadListProductsScreen()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLList.fxml"));

        try
        {
            Parent parent = loader.load();

            ListController controller = loader.getController();

            controller.init(new ProductDAO(), "Produtos  >  Lista de produtos");

            new FadeEffectTransition(parent);

            anchorpaneMainContent.getChildren().setAll(parent);
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadHomepageScreen()
    {
        try
        {
            Parent parent = FXMLLoader.load(getClass().getResource("/view/fxml/FXMLHomepage.fxml"));
            new FadeEffectTransition(parent);
            anchorpaneMainContent.getChildren().setAll(parent);
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadOpenNewCashRegister()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLOpenNewCashRegister.fxml"));

        try
        {
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();

        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}