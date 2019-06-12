module sistema.controle.vendas
{
    requires javafx.fxml;
    requires javafx.controls;

    opens controller;
    opens main;
    opens model.bean;
    opens model.dao;
    opens model.util;
    opens view.css;
    opens view.fonts;
    opens view.fxml;
    opens view.img;
    opens view.util;
}