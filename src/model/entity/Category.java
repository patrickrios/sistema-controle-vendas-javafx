package model.entity;

public class Category {
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
}
