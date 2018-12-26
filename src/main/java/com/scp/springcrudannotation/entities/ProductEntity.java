package com.scp.springcrudannotation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_entity")

public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int productId;
	private String productName;
	private double productCost;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductCost() {
		return productCost;
	}
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	
	@Override
	public String toString() {
		return "ProductBean [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ "]";
	}
	
	public ProductEntity(int productId, String productName, double productCost) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
	}
	
	
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
