package view.util;

import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class SucessConfirmationLabelController
{
    @FXML
    private HBox hboxSucessConfView;

    @FXML
    private Label labelMessage;


    public void init(String message)
    {
        this.labelMessage.setText(message);
        AnchorPane.setRightAnchor(this.hboxSucessConfView, 0.0);
        AnchorPane.setTopAnchor(this.hboxSucessConfView, 25.0);
    }

    @FXML
    void close()
    {
        AnchorPane parent = (AnchorPane)hboxSucessConfView.getParent();
        parent.getChildren().remove(hboxSucessConfView);
    }
}
