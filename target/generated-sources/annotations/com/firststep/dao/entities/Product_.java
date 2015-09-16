package com.firststep.dao.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, Double> productCost;
	public static volatile SingularAttribute<Product, String> productName;
	public static volatile SingularAttribute<Product, ProductProfile> productProfile;
	public static volatile SingularAttribute<Product, Integer> productId;

}

