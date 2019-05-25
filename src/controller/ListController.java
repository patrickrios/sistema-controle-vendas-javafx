package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.util.Paginable;
import model.util.Pagination;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListController implements Initializable
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
    private VBox vboxItens;

    private Pagination pagination;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    public void init(Paginable paginable, String title)
    {
        pagination = new Pagination(paginable);
        labelListName.setText(title);
        vboxItens.getChildren().clear();
        loadList();
    }

    private void loadList()
    {
        ArrayList<Parent> itens = pagination.loadNextPage();

        for(Parent item :itens)
        {
            vboxItens.getChildren().add(item);
        }

    }
}
