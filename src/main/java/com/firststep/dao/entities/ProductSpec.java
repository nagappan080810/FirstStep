package com.firststep.dao.entities;
import javax.persistence.*;

@Entity
@Table(name="productSpec")
public class ProductSpec {
	@Id
	private int productSpecid;
	@ManyToOne(fetch=FetchType.EAGER,targetEntity=Product.class)
	@JoinColumn(name="productid",insertable=true,updatable=true)
	private Product product;
	private String propertyName;
	private String propertyValue;
	private String propertyDesc;
	
	public int getProductSpecid() {
		return productSpecid;
	}
	public void setProductSpecid(int productSpecid) {
		this.productSpecid = productSpecid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	public String getPropertyDesc() {
		return propertyDesc;
	}
	public void setPropertyDesc(String propertyDesc) {
		this.propertyDesc = propertyDesc;
	}
	

}
