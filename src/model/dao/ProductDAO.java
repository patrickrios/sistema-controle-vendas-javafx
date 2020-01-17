package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.PersistentEntity;
import model.entity.Product;

public class ProductDAO implements  PersistentDAO{
	
	private Connection connection;
	
	public ProductDAO() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	@Override
	public void save(PersistentEntity entity) {
		//Product prod = (Product)entity;
		
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

}
