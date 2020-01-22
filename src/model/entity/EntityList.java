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
		return offset+"-"+limit+" de "+total;
	}
	
	public boolean isFirstPage() {
		boolean yep = false;
		if(offset==1) yep=true;
		return yep;
	}
	
	public boolean isLastPage() {
		boolean yep = false;
		if((offset+15)>=total) yep = true;
		return yep;
	}	
}
