package io.namoosori.web.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.namoosori.web.product.domain.Product;
import io.namoosori.web.product.service.ProductService;

// TODO : Spring bean 등록을 위한 내용 추가 
public class ProductController {

	private ProductService productService;

//	TODO : ProductService 필드에 대한 Spring DI 적용을 위한 생성자  추가 

	@GetMapping("/")
	public String home() {
		return "redirect:list";
	}

//	TODO : 메소드 구현 
	public ModelAndView showProductList() {
		//
		return null;
	}

//	TODO : 메소드 구현 
	public ModelAndView showProductDetail(@RequestParam String serialNumber) {
		//
		return null;
	}

//	TODO : 메소드 구현 
	public String showRegistForm() {
		return null;
	}

//	TODO : 메소드 구현 
	public String registProduct(Product newProduct) {
		//
		return null;
	}

//	TODO : 메소드 구현 
	public ModelAndView showModifyForm(@RequestParam String serialNumber) {
		//
		return null;
	}

//	TODO : 메소드 구현 
	public String modifyProduct(Product newProduct) {
		//
		return null;
	}

//	TODO : 메소드 구현 
	public String removeProduct(@RequestParam String serialNumber) {
		//
		return null;
	}

}
