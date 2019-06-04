package model.dao;

import controller.ListProductItemController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import model.bean.Persistent;
import model.bean.Product;
import model.util.Paginable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ProductDAO implements Paginable, Persistent
{

    @Override
    public ArrayList<Parent> nextPage(int offset, int limit)
    {
        //Somente para testes
        ArrayList<Parent> products = new ArrayList<>();

        for(Product p : findAll())
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLListProductItem.fxml"));

            try
            {
                Parent parent = loader.load();
                ListProductItemController controller = loader.getController();
                controller.init(p);
                products.add(parent);
            }

            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

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
        return rand.nextInt(300);
    }

    public ArrayList<Product> findAll()
    {
        ArrayList<Product> list = new ArrayList<>();

        list.add(new Product(1,"01D704", "Xícara de cafe", 0.35f, 1.00f, 4));
        list.add(new Product(2,"02D705", "Bolo de banana", 1.00f, 2.00f, 3));
        list.add(new Product(3,"03D706", "Torta de maçã", 1.05f, 3.00f, 5));
        list.add(new Product(5,"04D707", "Hot dog", 1.05f, 1.50f, 10));

        return list;
    }

    @Override
    public boolean save(Object obj)
    {
        Product p = (Product) obj;
        System.out.println("New product added: "+p.toString());
        return true;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public ArrayList<?> findGroup(int offset, int limit) {
        return null;
    }
}
