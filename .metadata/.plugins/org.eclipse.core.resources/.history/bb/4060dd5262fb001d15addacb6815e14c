package com.crud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.crud.models.Product;

@Component
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	// Create new product
	@Transactional
	public long createProduct(Product product) {
		return (Long) this.hibernateTemplate.save(product);
	}

	// Get All products
	public List<Product> getAllProducts() {
		List<Product> allProd = this.hibernateTemplate.loadAll(Product.class);
		return allProd;
	}

	// Get single product
	public Product getProd(long id) {
		Product prod = this.hibernateTemplate.get(Product.class, id);
		return prod;
	}

	// Delete products
	@Transactional
	public void deleteProduct(long pid) {
		Product prod = this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(prod);
	}

}
