package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.util.Paginable;
import model.util.Pagination;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListController
{

    @FXML
    private Label labelListTitle;

    @FXML
    private TextField textfieldSearch;

    @FXML
    private Button buttonPagPreviousPage;

    @FXML
    private Label labelPaginationInfo;

    @FXML
    private Button buttonPagNextPage;

    @FXML
    private Button buttonDeleteAll;

    @FXML
    private Button buttonViewList;

    @FXML
    private Button buttonViewGrid;

    @FXML
    private AnchorPane anchorListHeader;

    @FXML
    private VBox vboxItens;

    private Pagination pagination;

    public void init(Paginable paginable, String title)
    {
        this.pagination = new Pagination(paginable);
        this.labelListTitle.setText(title);
        this.vboxItens.getChildren().clear();
        this.loadList();
        this.markButtonView(this.buttonViewList);
    }

    private void loadList()
    {
        ArrayList<Parent> itens = pagination.loadNextPage();

        for(Parent item :itens)
        {
            vboxItens.getChildren().add(item);
        }
    }

    void setListHeader(String path)
    {
        try
        {
            Parent parent = FXMLLoader.load(getClass().getResource(path));
            anchorListHeader.getChildren().setAll(parent);
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void viewGridLayout()
    {
        markButtonView(this.buttonViewGrid);
        unmarkButtonView(this.buttonViewList);
        changeViewGridIconOn();
        changeViewListIconOff();
    }

    @FXML
    void viewListLayout()
    {
        markButtonView(this.buttonViewList);
        unmarkButtonView(this.buttonViewGrid);
        changeViewListIconOn();
        changeViewGridIconOff();
    }

    private void markButtonView (Button button)
    {
        button.getStyleClass().clear();
        button.getStyleClass().add("button");
        button.getStyleClass().add("button-pagination-nav");
        button.getStyleClass().add("button-view-selected");
    }

    private void unmarkButtonView(Button button)
    {
        button.getStyleClass().clear();
        button.getStyleClass().add("button");
        button.getStyleClass().add("button-pagination-nav");
    }

    private void changeViewGridIconOn()
    {
        Image icon = null;
        icon = new Image(getClass().getResourceAsStream("/view/img/list/view-grid-selected-17x13.png"));
        this.buttonViewGrid.setGraphic(new ImageView(icon));
    }

    private void changeViewGridIconOff()
    {
        Image icon = null;
        icon = new Image(getClass().getResourceAsStream("/view/img/list/view-grid-unselected-17x13.png"));
        this.buttonViewGrid.setGraphic(new ImageView(icon));
    }

    private void changeViewListIconOn()
    {
        Image icon = null;
        icon = new Image(getClass().getResourceAsStream("/view/img/list/view-list-selected-17x14.png"));
        this.buttonViewList.setGraphic(new ImageView(icon));
    }

    private void changeViewListIconOff()
    {
        Image icon = null;
        icon = new Image(getClass().getResourceAsStream("/view/img/list/view-list-unselected-17x14.png"));
        this.buttonViewList.setGraphic(new ImageView(icon));
    }
}