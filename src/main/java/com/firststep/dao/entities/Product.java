package com.firststep.dao.entities;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
	@Id @GeneratedValue
	private int productId;
	private String productName;
	private double productCost;
	@Embedded
	private ProductProfile productProfile;
	
	public Product(){}
	
	public Product(String productName, double productCost){
		this.productCost = productCost;
		this.productName = productName;
	}
	
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
	public ProductProfile getProductProfile() {
		return productProfile;
	}
	public void setProductProfile(ProductProfile productProfile) {
		this.productProfile = productProfile;
	}

	public String getProductProfileStr() {
		return productProfile.toString();
	}
}
