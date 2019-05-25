package model.bean;

public class SaleItem
{
    private int quantity;
    private float subtotal;
    private Product product;

    public SaleItem(Product product)
    {
        this.product = product;
    }

    public void increaseQuantity()
    {

    }

    public void decreaseQuantity()
    {

    }

    public void setQuantity(int quantity)
    {

    }
}
