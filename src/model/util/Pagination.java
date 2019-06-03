package model.util;

import javafx.scene.Parent;
import java.util.ArrayList;

public class Pagination
{
    private int offset;
    private int limit;
    private Paginable p;

    public Pagination(Paginable p)
    {
        this.p = p;
        this.offset = 0;
        this.limit = 30;
    }

    public ArrayList<Parent> loadNextPage()
    {
        ArrayList<Parent> list = new ArrayList<>();


        //if(offset < p.numberOfRegisters())
        //{
            list = p.nextPage(offset, limit);
            this.offset += 30;
            this.limit += 30;
        //}

        return list;
    }

    public ArrayList<?> loadPreviousPage()
    {
        ArrayList<?>list = new ArrayList<>();

        if(offset >= 30)
        { 
            list = p.previousPage(offset, limit);
            this.offset -= 30;
            this.limit -= 30;
        }

        return list;
    }


    public String paginationInfo()
    {
        return (offset+30)+" de "+p.numberOfRegisters();
    }
}