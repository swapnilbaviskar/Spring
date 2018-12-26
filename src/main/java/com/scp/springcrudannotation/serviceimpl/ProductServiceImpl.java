package com.scp.springcrudannotation.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scp.springcrudannotation.beans.ProductBean;
import com.scp.springcrudannotation.dao.ProductDao;
import com.scp.springcrudannotation.entities.ProductEntity;
import com.scp.springcrudannotation.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;

	public boolean addProduct(ProductBean productBean) {

		productDao.addProduct(beanToEntity(productBean));
		return true;
	}

	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	public ProductBean updateProduct(ProductBean productBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductBean getProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProductBean> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*public void addProduct(ProductBean productBean) {
		// TODO Auto-generated method stub
		productdao.addProduct(beanToEntity(productBean));
		
		
	}
	*/
	private ProductEntity beanToEntity(ProductBean productBean)
	{
		ProductEntity productEntity=new ProductEntity();
		productEntity.setProductId(productBean.getProductId());
		productEntity.setProductCost(productBean.getProductCost());
		productEntity.setProductName(productBean.getProductName());
		return productEntity;
	}

}
