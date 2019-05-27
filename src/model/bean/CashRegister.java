package model.bean;

import view.util.StringToReal;

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
    private boolean open;
    private ArrayList<Sale> salesList;

    public CashRegister(float initialValue)
    {
        this.initialValue = initialValue;
        this.numberOfSales = 0;
        this.open = true;
    }

    public void close()
    {
        if(this.open)
        {
            this.open = false;
        }
    }

    public String getInitialValueFormatted()
    {
        return StringToReal.floatToReal(this.initialValue);
    }
}
