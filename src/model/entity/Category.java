package model.entity;

import model.dao.CategoryDAO;
import model.exception.EntityAlreadyExistException;

public class Category implements PersistentEntity {
	private Integer id;
	private String name;
	
	public Category(Integer id, String name) {
		this.id=id;
		this.name=name;
	}
	
	public Category(String name) {
		this.id = null;
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getId() {
		return id;
	}

	@Override
	public void createIfNotExist() throws EntityAlreadyExistException {
		CategoryDAO cdao = new CategoryDAO();
		
		if(cdao.findByName(name)) 
			throw new EntityAlreadyExistException(name);
		else 
			cdao.save(this);
	}

	@Override
	public void deleteThis() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateThis() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verifyExistent() {
		// TODO Auto-generated method stub
		return false;
	}
}
