package model.entity;

import java.sql.Date;
import java.util.ArrayList;

import model.dao.ProductDAO;
import model.exception.EntityAlreadyExistException;
import model.util.MoneyRealFormat;

public class Product implements PersistentEntity{
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

	@Override
	public void createIfNotExist() throws EntityAlreadyExistException {
		/*ProductDAO pdao = new ProductDAO();
		
		if(pdao.findByName(name) || pdao.findByCode(code))
			throw new EntityAlreadyExistException(this.name);
		else
			pdao.save(this);
		*/
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
		//boolean exist = new ProductDAO().
		return false;
	}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCode() {
		return code;
	}
	public float getCostPrice() {
		return costPrice;
	}
	public float getSalePrice() {
		return salePrice;
	}
	public int getQuantiy() {
		return quantiy;
	}
	public int getMinimumQuantity() {
		return minimumQuantity;
	}
	public ArrayList<String> getCategories() {
		return categories;
	}
	public Date getInclusionDate() {
		return inclusionDate;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void changeDatas(Product prod) {
		this.name = prod.name;
		this.code = prod.code;
		this.costPrice = prod.costPrice;
		this.salePrice = prod.salePrice;
		this.quantiy = prod.quantiy;
		this.minimumQuantity = prod.minimumQuantity;
		this.categories = prod.categories;
		this.inclusionDate = prod.inclusionDate;
	}
}
