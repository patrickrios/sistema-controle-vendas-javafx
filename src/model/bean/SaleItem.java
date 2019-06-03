package model.bean;

import view.util.StringToReal;

public class SaleItem
{
    private int quantity;
    private float subtotal;
    private Product product;

    public SaleItem(Product product)
    {
        this.product = product;
        this.quantity = 1;
        this.subtotal = product.getSalePrice();
    }

    public void increaseQuantity()
    {
        if(this.quantity < this.product.getQuantity())
        {
            this.quantity++;
            updateSubtotal();
        }
    }

    public void decreaseQuantity()
    {
        if(this.quantity > 1)
        {
            this.quantity--;
            updateSubtotal();
        }
    }

    public void setQuantity(int quantity)
    {
        if(quantity <= this.product.getQuantity() && quantity > 0)
        {
            this.quantity = quantity;
            updateSubtotal();
        }
    }

    private void updateSubtotal()
    {
        this.subtotal = (this.quantity * this.product.getSalePrice());
    }

    public String getNameItem()
    {
        return this.product.getName();
    }

    public String getSubtotalFormatted()
    {
        return StringToReal.floatToReal(this.subtotal);
    }

    public float getSalePriceProduct()
    {
        return this.product.getSalePrice();
    }

    public float getSubtotal()
    {
        return subtotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductCode()
    {
        return this.product.getCode();
    }


    public void status()
    {
        System.out.println("Item{name="+this.product.getName()+", quantity="+this.getQuantity()+" subtotal="+this.subtotal+"}");
    }
}