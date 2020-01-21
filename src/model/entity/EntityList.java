package model.entity;

import java.util.ArrayList;
import model.dao.ListableEntity;

public class EntityList {
	private int offset = 1;
	private int limit = 15;
	private int total = 0;
	
	public EntityList(ListableEntity listable) {
		// TODO Auto-generated constructor stub
	}
	
	ArrayList<?> getItems(){
		//TODO
		return null;
	}
	
	ArrayList<?> loadNextPage(){
		//TODO
		return null;
	}
	
	ArrayList<?> loadPreviousPage(){
		//TODO
		return null;
	}
	
	ArrayList<?> findItems(String keyword){
		//TODO
		return null;
	}
	
	String getPaginationInfo() {
		//TODO
		return "";
	}
	
	boolean isFirstPage() {
		//TODO
		return true;
	}
	
	boolean isLastPage() {
		//TODO
		return true;
	}
	
	
	
}
