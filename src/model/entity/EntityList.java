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
		incrementOffset();
		return null;
	}
	
	public ArrayList<?> loadPreviousPage(){
		//TODO
		decrementOffset();
		return null;
	}
	
	public ArrayList<?> findItems(String keyword){
		//TODO
		return null;
	}
	
	public String getPaginationInfo() {
		String pagination = offset+"-"+(offset+limit-1)+" de "+total;
		if(offset+limit >= total) pagination = offset+"-"+total+" de "+total;
		return pagination;
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
	
	private void incrementOffset() {
		if(offset+limit < total)
			this.offset += limit;
	}
	
	private void decrementOffset() {
		if(offset > 1)
			this.offset -= limit;
	}
}
