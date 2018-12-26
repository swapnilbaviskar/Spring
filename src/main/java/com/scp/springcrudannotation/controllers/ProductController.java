package com.scp.springcrudannotation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.scp.springcrudannotation.beans.ProductBean;
import com.scp.springcrudannotation.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	static {
		System.out.println("controller loaded");

	}
	
	
	@Autowired
	ProductService productService;
/*
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView appLandingPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("ProductBean", new ProductBean());
		return new ModelAndView("index");
	}*/

	@RequestMapping(name = "/addproduct", method = RequestMethod.POST)
	public boolean addProduct(@ModelAttribute ProductBean productBean) {

		System.out.println("in controller And product sent to service layer");

		productService.addProduct(productBean);
		
		System.out.println("exiting controller");

		return true;
	}

	@RequestMapping(name = "/updateproduct", method = RequestMethod.POST)
	public boolean updateProduct(@ModelAttribute ProductBean productBean) {
		productService.updateProduct(productBean);
		return true;
	}

	@RequestMapping(name = "/deleteproduct", method = RequestMethod.GET)
	public boolean deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
		return true;
	}

	@RequestMapping(name = "/getproduct", method = RequestMethod.GET)
	public ModelAndView getProduct(@PathVariable int productId) {
		ProductBean productBean = productService.getProduct(productId);

		ModelAndView model = new ModelAndView();
		model.addObject("ProductBean", productBean);
		model.setViewName("productlist");
		return model;
	}

	@RequestMapping(name = "/getallproduct", method = RequestMethod.GET)
	public ModelAndView getAllProduct() {
		List<ProductBean> listOfProducts = productService.getAllProduct();

		ModelAndView model = new ModelAndView();
		model.addObject("ProductBean", listOfProducts);
		model.setViewName("productlist");
		return model;
	}

}
