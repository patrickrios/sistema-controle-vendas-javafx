package model.bean;

import java.security.Timestamp;
import java.util.ArrayList;

public class CashRegister
{
    private int id;
    private float initialValue;
    private float finalValue;
    private Timestamp datetimeBegin;
    private Timestamp datetimeEnd;
    private int numberOfSales;
    private ArrayList<Sale> salesList;

    public CashRegister(float initialValue)
    {
        this.initialValue = initialValue;
        this.numberOfSales = 0;
    }
}
