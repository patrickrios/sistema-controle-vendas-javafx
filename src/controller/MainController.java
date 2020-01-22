package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.dao.ProductDAO;
import view.util.FadeEffectTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{
	@FXML
    private ScrollPane scrollContent;
    @FXML
    private  AnchorPane anchorpaneMainContent;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        loadHomepageScreen();
    }

    public void initi(Stage stage) {

    }

    @FXML
    public void loadListLayout(){
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLList.fxml"));
        try{
            Parent parent = loader.load();
            ListController c = loader.getController();
            c.initi(new ProductDAO(),"Nome","Cod","Preço de venda","Quantidade");
            this.anchorpaneMainContent.getChildren().setAll(parent);
            c.initiAfterAdded(this.scrollContent.getWidth(),this.scrollContent.getHeight());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void loadSaleReportScreen(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLSaleReport.fxml"));

        try{
            Parent parent = loader.load();
            new FadeEffectTransition(parent);
            this.anchorpaneMainContent.getChildren().setAll(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadHomepageScreen() {
        try{
            Parent parent = FXMLLoader.load(getClass().getResource("/view/fxml/FXMLHomepage.fxml"));
            new FadeEffectTransition(parent);
            anchorpaneMainContent.getChildren().setAll(parent);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void loadNewProductLayout() {
    	try {
			Parent layout = FXMLLoader.load(getClass().getResource("/view/fxml/FXMLNewProduct.fxml"));
			this.anchorpaneMainContent.getChildren().setAll(layout);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    public void logout() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/view/fxml/FXMLMainLoginPage.fxml"));
            Stage stage = (Stage)anchorpaneMainContent.getScene().getWindow();
            stage.setResizable(false);
            stage.setMaximized(false);
            stage.setScene(new Scene(parent));
            stage.setMaxWidth(980);
            stage.setMaxHeight(544);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void minimizeStage() {
    	Stage stage = (Stage)anchorpaneMainContent.getScene().getWindow();
    	stage.setIconified(true);
    }
    
    @FXML
    void closeApplication() {
    	System.exit(0);
    }
    
    @FXML
    void maximizeStage() {
    	Stage stage = (Stage)anchorpaneMainContent.getScene().getWindow();
    	stage.setX(0.0);
    	stage.setY(0.0);
    }
}