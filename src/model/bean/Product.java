package model.bean;

import view.util.StringToReal;

import java.security.Timestamp;

public class Product
{
    private int id;
    private String code;
    private String barcode;
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

    public Product(String code, String name, float costPrice, float salePrice, int quantity)
    {
        this.code = code;
        this.name = name;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.quantity = quantity;
    }


    float getSalePrice()
    {
        return salePrice;
    }

    int getQuantity()
    {
        return quantity;
    }

    public String getName()
    {
        return name;
    }

    public String getCode()
    {
        return code;
    }

    public String getSalePriceText()
    {
        return StringToReal.floatToReal(this.salePrice);
    }

    @Override
    public String toString()
    {
        return "Product{code="+this.code+", name="+this.name+", costPrice="+this.costPrice+", salePrice="+this.salePrice+", quantity="+this.quantity+"}";
    }
}
