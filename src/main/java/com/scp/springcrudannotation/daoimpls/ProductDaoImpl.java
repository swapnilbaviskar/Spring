package com.scp.springcrudannotation.daoimpls;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.scp.springcrudannotation.dao.ProductDao;
import com.scp.springcrudannotation.entities.ProductEntity;
@Repository
public class ProductDaoImpl implements ProductDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addProduct(ProductEntity productEntity) {

		sessionFactory.openSession().save(productEntity);
		System.out.println("in dao impl "+"record inserted");
		return true;
	}

	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	public ProductEntity updateProduct(ProductEntity productEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductEntity getProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProductEntity> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
