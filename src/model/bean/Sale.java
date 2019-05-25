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

    public void addItem()
    {

    }

    public void finishSale()
    {

    }

    private void updateTotalValue()
    {

    }

    private boolean verifyExistenceOfItem()
    {
        return true;
    }
}
