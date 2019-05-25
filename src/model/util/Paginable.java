package model.util;

import javafx.scene.Parent;
import java.util.ArrayList;

public interface Paginable
{
    ArrayList<Parent> nextPage(int offset, int limit);
    ArrayList<Parent> previousPage(int offset, int limit);
    int numberOfRegisters();
}
