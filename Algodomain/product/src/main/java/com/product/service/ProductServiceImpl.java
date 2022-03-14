package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.ProductDao;
import com.product.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	public ProductServiceImpl() {
	}

	@Override
	public List<Product> getProduct() {

		return productDao.findAll();
	}

	@Override
	public Product getProduct(long productId) {
		return productDao.getOne(productId);

	}

	@Override
	public Product addProduct(Product product) {

		return productDao.save(product);
	}

	@Override
	public Product updateProduct(Product product) {

		return productDao.save(product);

	}

	@Override
	public void deleteProduct(long parseLong) {
		Product entity = productDao.getOne(parseLong);
		productDao.delete(entity);
	}

}
