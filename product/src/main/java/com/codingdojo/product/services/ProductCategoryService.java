package com.codingdojo.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.product.models.Category;
import com.codingdojo.product.models.Product;
import com.codingdojo.product.repositories.CategoryRepository;
import com.codingdojo.product.repositories.ProductRepository;

@Service
public class ProductCategoryService {

	@Autowired
	private CategoryRepository cateRepo;
	@Autowired
	private ProductRepository proRepo;
	
	
	public Product createProduct(Product product) {
		return proRepo.save(product);
	}
	
	public Category createCategory(Category category) {
		return cateRepo.save(category);
	}
	
	public Category getCategory(Long id) {
		return cateRepo.findById(id).orElse(null);
	}
	
	public Product getProduct(Long id) {
		return proRepo.findById(id).orElse(null);
	}
	
	public List<Category> findCategoryNotProduct(Product product){
		return cateRepo.findByProductsNotContains(product);
		
	}
	
	public List<Product> findProductyNotCategory(Category category){
		return proRepo.findByCategoriesNotContains(category);
		
	}
	
	public void addCategoryToProduct(Product product, Category category) {
		List<Category> existingCats = product.getCategories();
		existingCats.add(category);	
		proRepo.save(product);
	}
	
	public void addProductToCategory(Product product, Category category) {
		List<Product> existingProd = category.getProducts();
		existingProd.add(product);	
		cateRepo.save(category);
	}
	
}
