package model.dao;

import javafx.scene.Parent;
import model.bean.Paginable;
import java.util.ArrayList;
import java.util.Random;

public class ProductDAO implements Paginable
{

    @Override
    public ArrayList<Parent> nextPage(int offset, int limit)
    {
        //Somente para testes
        ArrayList<Parent> products = new ArrayList<>();

        return products;
    }

    @Override
    public ArrayList<Parent> previousPage(int offset, int limit)
    {
        //Somente para testes
        ArrayList<Parent> products = new ArrayList<>();

        return products;
    }

    @Override
    public int numberOfRegisters()
    {
        //Somente para testes
        Random rand = new Random();
        int randomNum = rand.nextInt(300);

        return randomNum;
    }
}
