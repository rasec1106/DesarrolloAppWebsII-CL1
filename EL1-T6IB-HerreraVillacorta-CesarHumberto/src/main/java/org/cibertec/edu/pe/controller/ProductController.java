package org.cibertec.edu.pe.controller;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IProductService;
import org.cibertec.edu.pe.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	@GetMapping("/list")
	public String list(Model m) {
		List<Product> list = service.list();
		m.addAttribute("productList", list);
		return "listProducts";
	}
	
	@GetMapping("/search/{productId}")
	public String search(@PathVariable Long productId, Model m) {
		Optional<Product> p = service.search(productId);
		m.addAttribute("product", p);
		return "searchProductById";
	}
	
	@GetMapping("/create")
	public String create(Model m) {
		m.addAttribute("product", new Product());
		return "productForm";
	}
	
	@PostMapping("/save")
	public String save(@Validated Product p, Model m) {
		service.save(p);
		return "redirect:/list";
	}
	
	@GetMapping("/update/{productId}")
	public String update(@PathVariable Long productId, Model m) {
		Optional<Product> p = service.search(productId);
		m.addAttribute("product", p);
		return "productForm";
	}
	
	@GetMapping("/delete/{productId}")
	public String delete(@PathVariable Long productId, Model m) {
		service.delete(productId);
		return "redirect:/list";
	}
}
