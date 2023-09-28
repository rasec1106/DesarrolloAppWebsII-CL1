package org.cibertec.edu.pe.controller;

import java.util.List;

import org.cibertec.edu.pe.interfaceService.IProductService;
import org.cibertec.edu.pe.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
