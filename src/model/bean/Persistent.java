package model.bean;

import java.util.ArrayList;

public interface Persistent
{
    boolean save(Object obj);
    boolean update(Object obj);
    boolean delete(Object obj);
    Object findById(int id);
    ArrayList<?> findGroup(int offset, int limit);
}
