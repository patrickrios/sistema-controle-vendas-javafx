package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entity.Category;
import model.entity.PersistentEntity;

public class CategoryDAO implements PersistentDAO{
	private Connection conn;
	
	public CategoryDAO() {
		this.conn = ConnectionFactory.getConnection();
	}

	@Override
	public void save(PersistentEntity entity){
		Category cat = (Category)entity;
		String sql="INSERT INTO ddb_product_category (id_product_category,category_name) VALUES (DEFAULT,?)";		
		try {
			PreparedStatement stat = this.conn.prepareStatement(sql);
			stat.setString(1,cat.getName());
			stat.executeUpdate();
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findByCode(String code) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean findByName(String name) {
		boolean exist = false;
		String sql="SELECT id_product_category FROM ddb_product_category WHERE category_name LIKE '"+name+"' LIMIT 1";
		
		try {
			PreparedStatement stat = this.conn.prepareStatement(sql);
			ResultSet result = stat.executeQuery();
			if(result.next()) 
				exist=true;
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exist;
	}
	
	public ArrayList<Category> getAll(){
		ArrayList<Category> list = new ArrayList<>();
		String query = "SELECT id_product_category, category_name FROM ddb_product_category";
		try {
			PreparedStatement stat = this.conn.prepareStatement(query);
			ResultSet result = stat.executeQuery();
			while (result.next()) {
				list.add(new Category(result.getInt(1),result.getString(2)));
			}
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
