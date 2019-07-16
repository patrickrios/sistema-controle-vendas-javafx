package model.dao;

import controller.ListSalesItemController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import model.bean.Persistent;
import model.bean.Sale;
import model.util.Paginable;
import java.io.IOException;
import java.util.ArrayList;

public class SalesDAO implements Paginable, Persistent
{
    @Override
    public ArrayList<Parent> nextPage(int offset, int limit)
    {
        //Somente teste
        ArrayList<Parent> sales = new ArrayList<>();

        ArrayList<Sale> list = findGroup(offset, limit);

        for(Sale item : list)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLListSaleItem.fxml"));

            try
            {
                Parent parent = loader.load();
                ListSalesItemController controller = loader.getController();
                controller.init(item);
                sales.add(parent);
            }

            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return sales;
    }

    @Override
    public ArrayList<Parent> previousPage(int offset, int limit)
    {
        //Somente teste
        ArrayList<Parent> sales = new ArrayList<>();

        return sales;
    }

    @Override
    public int numberOfRegisters()
    {
        return 0;
    }

    @Override
    public boolean save(Object obj)
    {
        Sale sale = (Sale)obj;
        sale.status();
        return false;
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
    public ArrayList<Sale> findGroup(int offset, int limit)
    {
        ArrayList<Sale> group = new ArrayList<>();

        group.add(new Sale(32.35f, 5));
        group.add(new Sale(12.33f, 3));
        group.add(new Sale(16, 2));
        group.add(new Sale(44.75f, 7));
        group.add(new Sale(36.50f, 6));
        group.add(new Sale(7.50f, 1));
        group.add(new Sale(1, 1));
        group.add(new Sale(17.50f, 5));
        group.add(new Sale(40.0f, 2));
        group.add(new Sale(76.19f, 6));
        group.add(new Sale(9.99f, 4));
        group.add(new Sale(136.44f, 12));
        group.add(new Sale(76.13f, 5));
        group.add(new Sale(89.90f, 1));
        group.add(new Sale(2.99f, 1));

        return group;
    }
}
