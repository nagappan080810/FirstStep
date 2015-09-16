package com.firststep.service;
import org.springframework.context.support.*;
import org.springframework.dao.*;
import org.springframework.stereotype.*;
import org.springframework.context.*;
import java.text.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;

import com.firststep.dao.*;
import com.firststep.dao.entities.*;

public class ProductService {
	//@Autowired
	//@Qualifier("productDao")
	private ProductDaoImpl productDao;
	
	
	
	public ProductDaoImpl getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductDaoImpl productDao) {
		this.productDao = productDao;
	}
	public static void main(String args[]){
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("daocontext.xml");
		ProductService productService = (ProductService) ac.getBean("productService");
		if(productService.getProductDao()==null)
			System.out.println("product dao is null");
		int productId = productService.addMockProduct();
		productService.printProducts(productId);
		ac.close();
	}
	public int addMockProduct(){
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		int productId=0;
		try{
			Product product = new Product("Walker",3988.00);
			Date date = dateFormatter.parse("2013-10-10");
			ProductProfile productProfile = new ProductProfile(15, "mugzhil",date,true);
			System.out.println(productProfile.getPurchasedDate());
			product.setProductProfile(productProfile);
			productId = productDao.addProduct(product);
			System.out.println("product added successfully with product id"+productId);
		}catch(ParseException e){
			System.out.println("purchase date is invalid");
		}catch(DataAccessException e){
			System.out.println("error while saving the data"+e.getMessage());
		}		
		return productId;
	}
	public void printProducts(int productId){
		try{
			Product product = productDao.readProduct(productId);
			System.out.println("product name"+product.getProductName()+
					"product cost" + product.getProductCost());
			System.out.println("product spec"+product.getProductProfileStr());
		}catch(DataAccessException e){
			System.out.println("Data Access Exception"+e.getMessage());
		}
	}
}
