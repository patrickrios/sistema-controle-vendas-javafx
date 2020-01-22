package model.dao;

import java.util.ArrayList;

import model.exception.EmptyArrayListException;

public interface ListableEntity {
	ArrayList<?> getItems(int offset, int limit);
	ArrayList<?> findItems(String keyword) throws EmptyArrayListException;
	int getNumberRegisters();
	String itemLayoutPath();
}
