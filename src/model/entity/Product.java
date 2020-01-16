package model.entity;

import java.sql.Date;
import java.util.ArrayList;

import model.util.MoneyRealFormat;

public class Product {
	private Integer id;
	private String name;
	private String code;
	private float costPrice;
	private float salePrice;
	private int quantiy;
	private int minimumQuantity;
	private ArrayList<String> categories;
	private Date inclusionDate;
	
	//A product not save on db
	public Product(String name,String code,float costPrice,float salePrice,int quantity,int minQuantity,ArrayList<String> categories,Date inclusion) {
		this.name=name;
		this.code=code;
		this.costPrice=costPrice;
		this.salePrice=salePrice;
		this.quantiy=quantity;
		this.minimumQuantity=minQuantity;
		this.categories=categories;
		this.inclusionDate=inclusion;
	}
	
	//A product not save on db
	public Product(String name,String code,float costPrice,float salePrice,int quantity,int minQuantity,ArrayList<String> categories) {
		this.name=name;
		this.code=code;
		this.costPrice=costPrice;
		this.salePrice=salePrice;
		this.quantiy=quantity;
		this.minimumQuantity=minQuantity;
		this.categories=categories;
	}
	
	//Product from database
	public Product(int id,String name,String code,float costPrice,float salePrice,int quantity,int minQuantity,ArrayList<String> categories,Date inclusion) {
		this.id=id;
		this.name=name;
		this.code=code;
		this.costPrice=costPrice;
		this.salePrice=salePrice;
		this.quantiy=quantity;
		this.minimumQuantity=minQuantity;
		this.categories=categories;
		this.inclusionDate=inclusion;
	}
	
	public ArrayList<String> datasFormatted(){
		ArrayList<String> datas = new ArrayList<>();
		datas.add(name);
		datas.add(code);
		datas.add(MoneyRealFormat.floatToRealString(costPrice));
		datas.add(MoneyRealFormat.floatToRealString(salePrice));
		datas.add(quantiy+"");
		datas.add(minimumQuantity+"");
	
		for(String cat : categories)	datas.add(cat);
		
		return datas;
	}
}
