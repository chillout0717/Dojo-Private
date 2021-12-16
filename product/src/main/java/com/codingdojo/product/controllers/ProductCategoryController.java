package com.codingdojo.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.product.models.Category;
import com.codingdojo.product.models.Product;
import com.codingdojo.product.services.ProductCategoryService;

@Controller
public class ProductCategoryController {
	
	@Autowired
	private ProductCategoryService pcService;
	
	@GetMapping("/product/new")
	public String newProduct() {
		return "newProduct.jsp";
	}
	
	@GetMapping("/category/new")
	public String newCategory() {
		return "newCategory.jsp";
	}
	
	@PostMapping("/newCategory")
	public String addCategory(@RequestParam("category") String category) {
		Category addCategory = new Category();
		addCategory.setName(category);
		pcService.createCategory(addCategory);
		return "redirect:/category/new";
	}
	
	@PostMapping("/newProduct")
	public String addProduct(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("price") float price) {
		Product addProduct = new Product(name, description, price);
		pcService.createProduct(addProduct);
		return "redirect:/product/new";
	}
	
	@GetMapping("/{id}")
	public String showProduct(Model model, @PathVariable("id") Long id) {
		Product getProduct = pcService.getProduct(id);
		model.addAttribute("showProduct", pcService.findCategoryNotProduct(getProduct));
		model.addAttribute("product", getProduct);
		return "getProduct.jsp";
	}
	
	@PostMapping("/addCatToProd/{id}")
	public String addCatToProd(@RequestParam("cats") Long id, @PathVariable("id") Long productId) {
		Product productToAddCatTo = pcService.getProduct(productId);
		Category categoryToAdd = pcService.getCategory(id);
		pcService.addCategoryToProduct(productToAddCatTo, categoryToAdd);
		return "redirect:/{id}";
	}
	
	@GetMapping("/cat/{id}")
	public String showCat(Model model, @PathVariable("id") Long id) {
		Category getCategory = pcService.getCategory(id);
		model.addAttribute("showCategory", pcService.findProductyNotCategory(getCategory));
		model.addAttribute("category", getCategory);
		return "getCategory.jsp";
		
	}
	
	@PostMapping("/addProdToCat/{id}")
	public String addProdToCat(@RequestParam("prod") Long id, @PathVariable("id") Long categoryId) {
		Product productToAddCatTo = pcService.getProduct(id);
		Category categoryToAdd = pcService.getCategory(id);
		pcService.addProductToCategory(productToAddCatTo, categoryToAdd);
		return "redirect:/cat/{id}";
	}
	
	
	
	
}
