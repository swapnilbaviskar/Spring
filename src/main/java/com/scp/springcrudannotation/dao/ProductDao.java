package com.scp.springcrudannotation.dao;

import java.util.List;

import com.scp.springcrudannotation.entities.ProductEntity;

public interface ProductDao {

	public boolean addProduct(ProductEntity productEntity);

	public boolean deleteProduct(int productId);

	public ProductEntity updateProduct(ProductEntity productEntity);

	public ProductEntity getProduct(int productId);

	public List<ProductEntity> getAllProduct();

}
