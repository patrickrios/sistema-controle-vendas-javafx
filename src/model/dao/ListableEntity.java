package model.dao;

import java.util.ArrayList;

public interface ListableEntity {
	ArrayList<?> getItems(int offset, int limit);
	ArrayList<?> findItems(String keyword);
	int getNumberRegisters();
}
