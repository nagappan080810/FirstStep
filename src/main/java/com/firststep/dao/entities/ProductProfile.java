package com.firststep.dao.entities;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import java.util.*;

@Embeddable
public class ProductProfile {
	private double weight;
	private String ownedBy;
	@Temporal(TemporalType.DATE)
	private Date purchasedDate;
	private boolean isExported;
	public ProductProfile(){}
	public ProductProfile(double weight, String ownedBy, Date purchasedDate, boolean isExported){
		this.weight = weight;
		this.ownedBy = ownedBy;
		this.purchasedDate = purchasedDate;
		this.isExported = isExported;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}
	public Date getPurchasedDate() {
		return purchasedDate;
	}
	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
	public boolean isisExported() {
		return isExported;
	}
	public void setisExported(boolean isExported) {
		this.isExported = isExported;
	}
	@Override
	public String toString() {
		return "ProductProfile [weight=" + weight + ", ownedBy=" + ownedBy
				+ ", purchasedDate=" + purchasedDate + ", isExported="
				+ isExported + "]";
	}
}
