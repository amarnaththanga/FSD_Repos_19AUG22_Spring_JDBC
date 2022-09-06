package com.simplilearn.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.webapp.dao.ProductDAO;
import com.simplilearn.webapp.model.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/list-products", method=RequestMethod.GET)
	public ModelAndView listAllProducts () {
		ModelAndView mv = new ModelAndView("list-products");
		
		// get list of products from DB
		List<Product> productList = productDAO.getProducts();
				
		mv.addObject("list",productList);
		return mv;
	}

	// Add Products - GET using addProduct
	@RequestMapping(value="/add-product", method=RequestMethod.GET)
	public ModelAndView addProduct() {
		ModelAndView mv = new ModelAndView("add-product");
		Product product = new Product();
		mv.addObject("product",product);
		return mv;		
	}
	
	// Add Products - POST using submitProduct
	@RequestMapping(value="/add-product", method=RequestMethod.POST)
	public ModelAndView submitProduct(@ModelAttribute("product") Product product) {
		ModelAndView mv = new ModelAndView("success-response");
		// submit data to Add Product DAO operation.
		productDAO.addProdut(product);
		mv.addObject("action","created");
		return mv;		
	}
	
	// Update Products - GET using updateProduct
	@RequestMapping(value="/update-product", method=RequestMethod.GET)
	public ModelAndView updateProduct() {
		ModelAndView mv = new ModelAndView("update-product");
		Product product = new Product();
		mv.addObject("product",product);
		return mv;		
	}

	// Update Products - POST using submitProduct
	@RequestMapping(value="/update-product", method=RequestMethod.POST)
	public ModelAndView submitUpdateProduct(@ModelAttribute("product") Product product) {
		ModelAndView mv = new ModelAndView("success-response");
		// submit data to Update Product in DAO operation.
		productDAO.updateProdut(product);
		mv.addObject("action","updated");
		return mv;		
	}	
	
	// Delete Products - GET using deleteProduct
		@RequestMapping(value="/delete-product", method=RequestMethod.GET)
		public ModelAndView deleteProduct() {
			ModelAndView mv = new ModelAndView("delete-product");
			Product product = new Product();
			mv.addObject("product",product);
			return mv;		
		}
		
	// Delete Products - POST using submitDeleteProduct
		@RequestMapping(value="/delete-product", method=RequestMethod.POST)
		public ModelAndView submitDeleteProduct(@ModelAttribute("product") Product product) {
			ModelAndView mv = new ModelAndView("success-response");
			// submit data to Delete Product in DAO operation.
			productDAO.deleteProdut(product);
			mv.addObject("action","deleted");
			return mv;		
		}		
}
