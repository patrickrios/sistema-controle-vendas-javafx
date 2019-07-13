package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class SaleReportController implements Initializable
{
    @FXML
    private LineChart<?, ?> lineChartSales;

    @FXML
    private CategoryAxis catAxis;

    @FXML
    private NumberAxis numbAxis;

    @FXML
    private ChoiceBox<String> choiceboxMonth;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        populateLineChart();
        loadChoiceboxMonth();
    }

    private void populateLineChart()
    {
        XYChart.Series series = new XYChart.Series();
        series.setName("Total em R$ por dia");

        Random r = new Random();

        for(int i=1; i<=15; i++)
        {
            int value = r.nextInt(101);
            boolean b = series.getData().addAll(new XYChart.Data("" + i, value));

        }

        lineChartSales.getData().add(series);
        lineChartSales.setTitle("Transações");
    }

    private void loadChoiceboxMonth()
    {
        ArrayList<String> months = new ArrayList<>();
        months.add("Este mês");

        choiceboxMonth.setItems(FXCollections.observableList(months));
        choiceboxMonth.setValue("Este mês");
    }

}
