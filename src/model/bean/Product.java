package model.bean;

import view.util.StringToReal;

import java.security.Timestamp;

public class Product
{
    private int id;
    private String code;
    private String name;
    private float costPrice;
    private float salePrice;
    private int quantity;
    private Timestamp datetimeInclusion;

    public Product(int id, String code, String name, float costPrice, float salePrice, int quantity, Timestamp inclusion)
    {
        this.id = id;
        this.code = code;
        this.name = name;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.quantity = quantity;
        this.datetimeInclusion = inclusion;
    }

    public Product(int id, String code, String name, float costPrice, float salePrice, int quantity)
    {
        this.id = id;
        this.code = code;
        this.name = name;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.quantity = quantity;
        this.datetimeInclusion = null;
    }

    public Product(String code, String name, float costPrice, float salePrice, int quantity, Timestamp inclusion)
    {
        this.code = code;
        this.name = name;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.quantity = quantity;
        this.datetimeInclusion = inclusion;
    }

    float getSalePrice()
    {
        return salePrice;
    }

    int getQuantity()
    {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public String getSalePriceText()
    {
        return StringToReal.floatToReal(this.salePrice);
    }
}
