package model.bean;

import view.util.StringToReal;

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


    public boolean addItemToSale(SaleItem item)
    {
        boolean added = false;
        if(!verifyExistenceOfItem(item))
        {
            if(itensList.add(item))
            {
                this.numberOfItens++;
                addValueToTotal(item.getSubtotal());
               added = true;
            }
        }

        return added;
    }

    public void removeItemFromSale(SaleItem item)
    {
        if(itensList.remove(item))
        {
            this.numberOfItens--;
            removeValueFromTotal(item.getSubtotal());
        }
    }

    public void updateRemoveTotalValue(float value)
    {
        this.totalValue -= value;
    }

    public void updateAddTotalValue(float value)
    {
        this.totalValue += value;
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
        boolean exists = false;

        for(SaleItem i : itensList)
        {
            if(i.getNameItem().equals(item.getNameItem()))
            {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public String getTotalValueFormatted()
    {
        return StringToReal.floatToReal(this.totalValue);
    }

    public void resetSale()
    {
        this.itensList.clear();
        this.numberOfItens = 0;
        this.totalValue = 0;
    }

    public void status()
    {
        System.out.println("Sale{ sale="+this.toString()+", itens="+this.numberOfItens+" total="+this.totalValue+"}");

        for(SaleItem i : this.itensList)
            System.out.println("\titem{name="+i.getNameItem()+", quant="+i.getQuantity()+", subtotal="+i.getSubtotalFormatted()+"}");

        System.out.println("\n");
    }
}
