package model.dao;

import javafx.scene.Parent;
import model.bean.Product;
import model.util.Paginable;
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

    public ArrayList<Product> findAll()
    {
        ArrayList<Product> list = new ArrayList<>();

        list.add(new Product(1,"01D704", "Xícara de cafe", 0.35f, 1.25f, 4));
        list.add(new Product(2,"03DSC2", "Bolo de banana", 1.00f, 2.25f, 3));
        list.add(new Product(3,"0X702D", "Torta de maçã", 1.05f, 2.50f, 5));

        return list;
    }
}
