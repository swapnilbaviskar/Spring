package com.scp.springcrudannotation.services;

import java.util.List;

import com.scp.springcrudannotation.beans.ProductBean;

public interface ProductService {

	public boolean addProduct(ProductBean productBean);

	public boolean deleteProduct(int productId);

	public ProductBean updateProduct(ProductBean productBean);

	public ProductBean getProduct(int productId);

	public List<ProductBean> getAllProduct();

}
