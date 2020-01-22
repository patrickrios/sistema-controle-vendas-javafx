package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class HomepageController implements Initializable
{
    @FXML
    private Label labelCurrentDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Date currentDate = new Date();
        DateFormat dff = DateFormat.getDateInstance(DateFormat.FULL);
        labelCurrentDate.setText(dff.format(currentDate));
    }
}