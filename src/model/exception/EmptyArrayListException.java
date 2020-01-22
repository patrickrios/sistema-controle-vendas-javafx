package model.exception;

import java.util.ArrayList;

public class EmptyArrayListException extends Exception{
	
	private ArrayList<?> list;
	
	public EmptyArrayListException(ArrayList<?> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return this.list.toString();
	}

}
