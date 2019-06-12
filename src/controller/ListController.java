package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
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
    private Label labelListName;

    @FXML
    private TextField textfieldSearch;

    @FXML
    private Button buttonPagPreviousPage;

    @FXML
    private Label labelPaginationInfo;

    @FXML
    private Button buttonPagNextPage;

    @FXML
    private AnchorPane anchorListHeader;

    @FXML
    private ScrollPane scrollpaneList;

    @FXML
    private VBox vboxItens;

    private Pagination pagination;

    public void init(Paginable paginable, String title)
    {
        this.pagination = new Pagination(paginable);
        this.labelListName.setText(title);
        this.vboxItens.getChildren().clear();
        loadList();
        scrollpaneList.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }

    private void loadList()
    {
        ArrayList<Parent> itens = pagination.loadNextPage();

        for(Parent item :itens)
        {
            vboxItens.getChildren().add(item);
        }

    }

    public void setListHeader(String path)
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
}
