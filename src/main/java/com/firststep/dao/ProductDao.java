package com.firststep.dao;
import com.firststep.dao.entities.*;

public interface ProductDao {
	public int addProduct(Product product);
	public void deleteProduct(int productId);
	public Product readProduct(int productId);
	public void updateProduct(Product product);
}
