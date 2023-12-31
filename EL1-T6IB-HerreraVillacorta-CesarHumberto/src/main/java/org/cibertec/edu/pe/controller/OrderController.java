package org.cibertec.edu.pe.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import org.cibertec.edu.pe.dto.PurchaseRequest;
import org.cibertec.edu.pe.interfaceService.IOrderService;
import org.cibertec.edu.pe.interfaceService.IProductService;
import org.cibertec.edu.pe.model.Order;
import org.cibertec.edu.pe.model.OrderItem;
import org.cibertec.edu.pe.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"purchaseRequest"})
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IProductService productService;
	
	@ModelAttribute("purchaseRequest")
	public PurchaseRequest getPurchaseRequest(){
		return new PurchaseRequest();
	}
	
	@GetMapping("/placeOrder")
	public String placeOrder(Model m) {
		PurchaseRequest purchase = (PurchaseRequest) m.getAttribute("purchaseRequest");
		Set<OrderItem> orderItems = purchase.getOrderItems();		
		Order order = new Order();
		order.setOrderItems(orderItems);
		order = orderService.calculate(order);
		purchase.setOrder(order);
		m.addAttribute("purchaseRequest", purchase);
		return "placeOrder";
	}
	
	@GetMapping("/addToCart/{productId}")
	public String addToCart(@PathVariable Long productId, Model m) {
		PurchaseRequest purchase = (PurchaseRequest) m.getAttribute("purchaseRequest");
		Set<OrderItem> orderItems = purchase.getOrderItems();
		Product p = productService.search(productId).get();
		OrderItem item = new OrderItem();
		item.setDiscount(new BigDecimal(0));
		item.setQuantity(new BigDecimal(1));
		item.setSubtotal(p.getPrice());
		item.setProduct(p);
		if(!orderService.isContaining(productId, orderItems)) orderItems.add(item);
		purchase.setOrderItems(orderItems);
		m.addAttribute("purchaseRequest", purchase);
		return "redirect:/list";
	}
	
	@GetMapping("/removeFromCart/{index}")
	public String removeFromCart(@PathVariable int index, Model m) {
		PurchaseRequest purchase = (PurchaseRequest) m.getAttribute("purchaseRequest");
		Set<OrderItem> orderItems = purchase.getOrderItems();	
		OrderItem item = (OrderItem)orderItems.toArray()[index];
		orderItems.remove(item);
		m.addAttribute("purchaseRequest", purchase);
		return "redirect:/order/placeOrder";
	}
	
	@PostMapping("/purchase")
	public String purchase(Model m) {
		PurchaseRequest purchase = (PurchaseRequest) m.getAttribute("purchaseRequest");
		Set<OrderItem> orderItems = purchase.getOrderItems();
		Order order = purchase.getOrder();
		order.setOrderDate(new Date());
		int hasSaved = orderService.save(order, orderItems);
		System.out.println("SAVE"+ hasSaved);
		if(hasSaved == 1) orderItems.clear();
		return "redirect:/list";
	}
	@PostMapping("/recalculate")
	public String recalculate(@ModelAttribute PurchaseRequest purchase, Model m) {
		m.addAttribute("purchaseRequest", purchase);
		return "redirect:/order/placeOrder";
	}
}
