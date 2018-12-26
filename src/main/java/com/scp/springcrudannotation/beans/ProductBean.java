package com.scp.springcrudannotation.beans;

public class ProductBean {
	
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
	
	public ProductBean(int productId, String productName, double productCost) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
	}
	
	
	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
