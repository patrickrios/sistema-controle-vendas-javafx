package model.entity;

import java.util.ArrayList;
import model.dao.ListableEntity;
import model.exception.EmptyArrayListException;

public class EntityList {
	private int offset = 1;
	private int limit = 15;
	private int total = 0;
	private ListableEntity listable;
	private ArrayList<?> items;
	
	public EntityList(ListableEntity listable) {
		this.total = listable.getNumberRegisters();
		this.listable = listable;
		this.items = this.listable.getItems(offset, limit);
	}
	
	public ArrayList<?> getItems() throws EmptyArrayListException{
		if(items.isEmpty() || items==null) 
			throw new EmptyArrayListException(items);
		else	
			return this.items;
	}
	
	public ArrayList<?> loadNextPage(){
		incrementOffset();
		this.items = this.listable.getItems(offset, limit);
		return this.items;
	}
	
	public ArrayList<?> loadPreviousPage(){
		//TODO
		decrementOffset();
		this.items = this.listable.getItems(offset, limit);
		return this.items;
	}
	
	public ArrayList<?> findItems(String keyword){
		//TODO
		return null;
	}
	
	public String getPaginationInfo() {
		if(offset+limit >= total)
			return String.format("%02d-%02d de %02d", offset,total,total);
		else
			return String.format("%02d-%02d de %02d", offset,(offset+limit-1),total);
	}
	
	public boolean isFirstPage() {
		boolean yep = false;
		if(offset==1) yep=true;
		return yep;
	}
	
	public boolean isLastPage() {
		boolean yep = false;
		if((offset+limit)>=total) yep = true;
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
