package org.cibertec.edu.pe.controller;

import java.util.HashSet;
import java.util.Set;

import org.cibertec.edu.pe.interfaceService.IOrderService;
import org.cibertec.edu.pe.interfaceService.IProductService;
import org.cibertec.edu.pe.interfaces.IProduct;
import org.cibertec.edu.pe.model.Order;
import org.cibertec.edu.pe.model.OrderItem;
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
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IProductService productService;
	
	private Set<OrderItem> orderItems;
	
	@GetMapping("/placeOrder")
	public String placeOrder(Model m) {
		m.addAttribute("orderItems", orderItems);
		m.addAttribute("order", new Order());
		return "placeOrder";
	}
	
	@GetMapping("/addToCart/{productId}")
	public String addToCart(@PathVariable Long productId, Model m) {
		Product p = productService.search(productId).get();
		OrderItem item = new OrderItem();
		item.setProduct(p);
		if(orderItems == null) orderItems = new HashSet<>();
		orderItems.add(item);
		return "redirect:/list";
	}
	
	@PostMapping("/purchase")
	public String save(@Validated Order order, Model m) {
		orderService.save(order, orderItems);
		return "redirect:/list";
	}
}
