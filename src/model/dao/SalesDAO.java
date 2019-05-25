package model.dao;

import controller.ItemController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import model.util.Paginable;
import java.io.IOException;
import java.util.ArrayList;

public class SalesDAO implements Paginable
{
    @Override
    public ArrayList<Parent> nextPage(int offset, int limit)
    {
        //Somente teste
        ArrayList<Parent> sales = new ArrayList<>();

        ArrayList<String> list = new ArrayList<>();
        list.add("023S  Patrick  R$765,98   14-01-2019 às 14:37");
        list.add("024S  Bianca   R$583,06   14-01-2019 às 13:21");
        list.add("023S  Pedro    R$3365,33  14-01-2019 às 09:42");
        list.add("023S  Manuela  R$1034,15  14-01-2019 às 11:12");
        list.add("023S  Jair     R$1366,68  14-01-2019 às 17:45");

        for(String item : list)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLItem.fxml"));

            try
            {
                Parent parent = loader.load();
                ItemController controller = loader.getController();
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
}
