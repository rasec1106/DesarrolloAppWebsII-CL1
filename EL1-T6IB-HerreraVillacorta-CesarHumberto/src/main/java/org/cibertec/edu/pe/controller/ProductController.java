package org.cibertec.edu.pe.controller;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IProductService;
import org.cibertec.edu.pe.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/search/{id}")
	public String search(@PathVariable String id, Model m) {
		Optional<Product> p = service.search(id);
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
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable String id, Model m) {
		Optional<Product> p = service.search(id);
		m.addAttribute("product", p);
		return "productForm";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id, Model m) {
		service.delete(id);
		return "redirect:/list";
	}
}
