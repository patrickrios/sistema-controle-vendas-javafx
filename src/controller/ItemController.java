package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemController implements Initializable
{
    @FXML
    private Label labelName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    public void init(String name)
    {
        labelName.setText(name);
    }
}
