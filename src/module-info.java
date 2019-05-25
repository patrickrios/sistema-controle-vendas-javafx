module Sistema.controle.vendas
{
    requires javafx.fxml;
    requires  javafx.controls;

    opens main;
    opens view.css;
    opens view.fonts;
    opens view.fxml;
    opens view.img;
    opens view.util;
    opens controller;
    opens model.bean;
    opens model.dao;
}