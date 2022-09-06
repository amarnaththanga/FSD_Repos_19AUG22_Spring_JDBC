package com.simplilearn.webapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.simplilearn.webapp.model.Product;

public class ProductDAO {

	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// 1. list all Products
	public List<Product> getProducts() {
		List<Product> productList = template.query("Select * from product_data", new RowMapper <Product>() {
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setId(rs.getLong(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setDesc(rs.getString(4));
				product.setCreatedAt(rs.getDate(5));
				return product;
			}			
		});		
		return productList;		
	}
	
	// 2. Add Product
	public int addProdut(Product product) {
		String ADD_PRODUCT = "INSERT into product_data (name, price, description) values( ? , ?, ? ) ";
		return template.update(ADD_PRODUCT, product.getName(),product.getPrice(),product.getDesc());
	}
	
	// 3. Update Product
	public int updateProdut(Product product) {
		String UPDATE_PRODUCT = "UPDATE product_data set name=?,price=?,description=? where id=?";
		return template.update(UPDATE_PRODUCT, product.getName(),product.getPrice(),product.getDesc(),product.getId());
	}
	// 4. Delete Product
	public int deleteProdut(Product product) {
		String DELETE_PRODUCT = "DELETE from product_data where id=?";
		return template.update(DELETE_PRODUCT, product.getId());
	}
	
}
