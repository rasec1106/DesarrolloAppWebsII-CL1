package org.cibertec.edu.pe.controller;

import java.math.BigDecimal;
import java.util.Date;
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
	
	private Set<OrderItem> orderItems = new HashSet<>();
	
	@GetMapping("/placeOrder")
	public String placeOrder(Model m) {
		m.addAttribute("orderItems", orderItems);
		Order order = new Order();
		order.setOrderItems(orderItems);
		order = orderService.calculate(order);
		m.addAttribute("order", order);
		return "placeOrder";
	}
	
	@GetMapping("/addToCart/{productId}")
	public String addToCart(@PathVariable Long productId, Model m) {
		Product p = productService.search(productId).get();
		OrderItem item = new OrderItem();
		item.setProduct(p);
		orderItems.add(item);
		return "redirect:/list";
	}
	
	@GetMapping("/removeFromCart/{productId}")
	public String removeFromCart(@PathVariable Long productId, Model m) {
		Product p = productService.search(productId).get();
		OrderItem item = new OrderItem();
		item.setProduct(p);
		orderItems.remove(item);
		return "redirect:/placeOrder";
	}
	
	@PostMapping("/purchase")
	public String purchase(@Validated Order order, Model m) {
		order.setOrderDate(new Date());
		int hasSaved = orderService.save(order, orderItems);
		System.out.println("SAVE"+ hasSaved);
		if(hasSaved == 1) orderItems.clear();
		return "redirect:/list";
	}
}
