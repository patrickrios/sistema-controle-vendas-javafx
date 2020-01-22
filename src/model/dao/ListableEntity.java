package model.dao;

import java.util.ArrayList;

import model.exception.EmptyArrayListException;

public interface ListableEntity {
	ArrayList<?> getItems(int offset, int limit) throws EmptyArrayListException;
	ArrayList<?> findItems(String keyword) throws EmptyArrayListException;
	int getNumberRegisters();
}
