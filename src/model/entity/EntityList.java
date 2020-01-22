package model.entity;

import java.util.ArrayList;
import model.dao.ListableEntity;
import model.exception.EmptyArrayListException;

public class EntityList {
	private int offset = 1;
	private int limit = 15;
	private int total = 0;
	private ListableEntity listable;
	
	public EntityList(ListableEntity listable) {
		this.total = listable.getNumberRegisters();
		this.listable = listable;
	}
	
	public ArrayList<?> getItems() throws EmptyArrayListException{
		ArrayList<?> items = null;
		items = this.listable.getItems(offset, limit);
		
		if(items.isEmpty() || items==null) 
			throw new EmptyArrayListException(items);
		else	
			return items;
	}
	
	public ArrayList<?> loadNextPage(){
		//TODO
		return null;
	}
	
	public ArrayList<?> loadPreviousPage(){
		//TODO
		return null;
	}
	
	public ArrayList<?> findItems(String keyword){
		//TODO
		return null;
	}
	
	public String getPaginationInfo() {
		//TODO
		return ""+total;
	}
	
	public boolean isFirstPage() {
		//TODO
		return true;
	}
	
	public boolean isLastPage() {
		//TODO
		return true;
	}	
}
