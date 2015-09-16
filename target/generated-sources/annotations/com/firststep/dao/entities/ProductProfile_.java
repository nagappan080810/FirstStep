package com.firststep.dao.entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ProductProfile.class)
public abstract class ProductProfile_ {

	public static volatile SingularAttribute<ProductProfile, Double> weight;
	public static volatile SingularAttribute<ProductProfile, Boolean> isExported;
	public static volatile SingularAttribute<ProductProfile, String> ownedBy;
	public static volatile SingularAttribute<ProductProfile, Date> purchasedDate;

}

