package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.entity.Category;
import model.entity.PersistentEntity;
import model.entity.Product;

public class ProductDAO implements  PersistentDAO, ListableEntity{
	
	private Connection connection;
	
	public ProductDAO() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	@Override
	public void save(PersistentEntity entity) {
		Product prod = (Product)entity;
		String sql = "INSERT INTO ddb_product (id_product,name,code,costPrice,salePrice,quantity,minimum_quantity,inclusion) VALUES (DEFAULT,?,?,?,?,?,?,CURRENT_TIMESTAMP)";
		
		try {
			PreparedStatement stat = this.connection.prepareStatement(sql);
			stat.setString(1,prod.getName());
			stat.setString(2,prod.getCode());
			stat.setFloat(3,prod.getCostPrice());
			stat.setFloat(4, prod.getSalePrice());
			stat.setInt(5,prod.getQuantiy());
			stat.setInt(6, prod.getMinimumQuantity());
			stat.executeUpdate();
			ResultSet r = stat.executeQuery("SELECT LAST_INSERT_ID()");
			if(r.next()) saveProductCategories(r.getInt(1), prod.getCategories());
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PersistentEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean findById(int id) {
		
		return false;
	}

	@Override
	public boolean findByCode(String code) {
		boolean exist = false;
		String sql="SELECT id_product FROM ddb_product WHERE code LIKE '"+code+"' LIMIT 1";
		try {
			PreparedStatement stat = this.connection.prepareStatement(sql);
			ResultSet result = stat.executeQuery();
			if(result.next())
				exist=true;
			stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exist;
	}
	
	public boolean findByName(String name) {
		boolean exist = false;
		String sql="SELECT id_product FROM ddb_product WHERE name LIKE '"+name+"' LIMIT 1";
		try {
			PreparedStatement stat = this.connection.prepareStatement(sql);
			ResultSet result = stat.executeQuery();
			if(result.next())
				exist=true;
			stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exist;
	}
	
	private void saveProductCategories(int prodID,ArrayList<Category> list) {
		String insert="INSERT INTO ddb_categories_by_product(product_id,category_id) VALUES("+prodID+",?)";
		try {
			PreparedStatement stat = this.connection.prepareStatement(insert);
			for(Category cat : list) {
				stat.setInt(1, cat.getId());
				stat.executeUpdate();
			}
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Product> getItems(int offset, int limit){
		ArrayList<Product> list = new ArrayList<>();
		String query = "SELECT id_product,name,code,salePrice,quantity,minimum_quantity FROM ddb_product LIMIT "+limit+" OFFSET "+offset;
		try {
			PreparedStatement stat = this.connection.prepareStatement(query);
			ResultSet rset = stat.executeQuery();
			while (rset.next()) {
				list.add(new Product(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getFloat(4),rset.getInt(5),rset.getInt(6)));
			}
			stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Product> findItems(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberRegisters() {
		int count=0;
		String query = "SELECT count(id_product) FROM ddb_product LIMIT 1";
		try {
			PreparedStatement stat = this.connection.prepareStatement(query);
			ResultSet result = stat.executeQuery();
			if(result.next())
				count = result.getInt(1);
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public String itemLayoutPath() {
		return "/view/fxml/FXMLListItemProduct.fxml";
	}
}
