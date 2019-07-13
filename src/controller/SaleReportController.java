package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        populateLineChart();
    }

    private void populateLineChart()
    {
        XYChart.Series series = new XYChart.Series();
        series.setName("Transações por dia");

        Random r = new Random();

        for(int i=1; i<=20; i++)
        {
            int value = r.nextInt(101);
            series.getData().add(new XYChart.Data(""+i, value));

        }

        lineChartSales.getData().add(series);
    }

}
