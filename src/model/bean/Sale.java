package model.bean;

import java.security.Timestamp;
import java.util.ArrayList;

public class Sale
{
    private int id;
    private float totalValue;
    private int numberOfItens;
    private Timestamp hourOfSale;
    private ArrayList<SaleItem> itensList;

    public Sale()
    {
        this.numberOfItens = 0;
        this.totalValue = 0;
        itensList = new ArrayList<>();
    }

    public void addItem(SaleItem item)
    {
        if(itensList.add(item))
        {
            this.numberOfItens++;
            addValueToTotal(item.getSubtotal());
        }
    }

    public void removeItem(SaleItem item)
    {
        if(itensList.remove(item))
        {
            this.numberOfItens--;
            removeValueFromTotal(item.getSubtotal());
        }
    }

    public void updateRemoveTotalValue(SaleItem item)
    {
        this.totalValue -= (item.getSalePriceProduct()*item.getQuantity());
    }

    public void updateAddTotalValue(SaleItem item)
    {
        this.totalValue += (item.getSalePriceProduct()*item.getQuantity());
    }

    public void finishSale()
    {

    }

    private void addValueToTotal(float value)
    {
        this.totalValue += value;
    }

    private void removeValueFromTotal(float value)
    {
        this.totalValue -= value;
    }

    private boolean verifyExistenceOfItem(SaleItem item)
    {
        return true;
    }

    public void status()
    {
        System.out.println("Sale{ sale="+this.toString()+", itens="+this.numberOfItens+" total="+this.totalValue+"}");

       for(SaleItem i : this.itensList)
            System.out.println("\titem{name="+i.getNameItem()+", quant="+i.getQuantity()+", subtotal="+i.getSubtotalFormatted()+"}");

        System.out.println("\n");
    }
}
