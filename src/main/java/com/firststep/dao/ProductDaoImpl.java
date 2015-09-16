package com.firststep.dao;
import com.firststep.dao.entities.*;
import org.springframework.orm.hibernate3.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.hibernate.*;
@Repository
public class ProductDaoImpl implements ProductDao{
	private HibernateTemplate hibernateTemplate;
	public ProductDaoImpl(){}
	public ProductDaoImpl(HibernateTemplate hibernateTemplate){
		this.hibernateTemplate = hibernateTemplate;
		this.hibernateTemplate.setAlwaysUseNewSession(true);
	}

	@Override
	public int addProduct(Product product) {
		if (product == null)
			System.out.println("null value");
		Integer productId = 0;
		productId = (Integer) hibernateTemplate.save(product);
		return productId;
	}

	@Override
	public void deleteProduct(int productId) {
		Product product = hibernateTemplate.load(Product.class, productId);
		hibernateTemplate.delete(product);
		
	}

	@Override
	public Product readProduct(final int productId) {
		// create hibernate callback to execute the load product class.
		HibernateCallback<Product> obj= new HibernateCallback<Product>(){
			public Product doInHibernate(Session session){
				Product product = (Product) session.get(Product.class, productId);
				return product;
			}
		};
		Product product = hibernateTemplate.executeWithNativeSession(obj);
		product.getProductName();
		return product;
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(product);
	}
	
}
