package io.namoosori.web.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.namoosori.web.product.domain.Product;
import io.namoosori.web.product.service.ProductService;

// TODO : Spring bean 등록을 위한 내용 추가
@Controller
public class ProductController {

	private ProductService productService;

//	TODO : ProductService 필드에 대한 Spring DI 적용을 위한 생성자  추가
	public ProductController(ProductService productService){
		this.productService = productService;
	}

	@GetMapping("/")
	public String home() {			
		
		return "redirect:list";
	}

//	TODO : 메소드 구현
	@RequestMapping("/list")
	public ModelAndView showProductList() {	
		ModelAndView mv = new ModelAndView("/views/list.jsp");		
		mv.addObject("products", productService.findAll());
		
		return mv;
	}

//	TODO : 메소드 구현
	@RequestMapping(value = "/detail")
	public ModelAndView showProductDetail(@RequestParam String serialNumber) {
		ModelAndView mv = new ModelAndView("/views/detail.jsp");
		mv.addObject("product", productService.find(serialNumber));		
		
		return mv;
	}

//	TODO : 메소드 구현
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String showRegistForm() {
		
		return "views/registerForm.jsp";
	}

//	TODO : 메소드 구현
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registProduct(Product newProduct) {	
		productService.regist(newProduct);		
		
		return "redirect:list";
	}

//	TODO : 메소드 구현
	// 제품 수정 화면 출력
	@RequestMapping(value = "/modify")
	public ModelAndView showModifyForm(@RequestParam String serialNumber) {
		ModelAndView mv = new ModelAndView("/views/modifyForm.jsp");		
		mv.addObject("product", productService.find(serialNumber));		
		
		return mv;
	}

//	TODO : 메소드 구현
	// 제품 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyProduct(Product newProduct) {
		productService.modify(newProduct);
		
		return "redirect:list";
	}

//	TODO : 메소드 구현
	//  제품 삭제
	@RequestMapping(value = "/remove")
	public String removeProduct(@RequestParam String serialNumber) {
		productService.remove(serialNumber);
		
		return "redirect:list";
	}

}
