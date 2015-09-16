package com.firststep.dao.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ProductSpec.class)
public abstract class ProductSpec_ {

	public static volatile SingularAttribute<ProductSpec, String> propertyName;
	public static volatile SingularAttribute<ProductSpec, Product> product;
	public static volatile SingularAttribute<ProductSpec, String> propertyDesc;
	public static volatile SingularAttribute<ProductSpec, Integer> productSpecid;
	public static volatile SingularAttribute<ProductSpec, String> propertyValue;

}

