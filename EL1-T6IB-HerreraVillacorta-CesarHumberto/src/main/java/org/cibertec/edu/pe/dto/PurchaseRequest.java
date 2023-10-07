package org.cibertec.edu.pe.dto;

import java.util.HashSet;
import java.util.Set;

import org.cibertec.edu.pe.model.Order;
import org.cibertec.edu.pe.model.OrderItem;

public class PurchaseRequest {
	public Order order;
    public Set<OrderItem> orderItems;
    
	public PurchaseRequest() {
		super();
		this.order = new Order();
		this.orderItems = new HashSet<OrderItem>();
	}

	public PurchaseRequest(Order order, Set<OrderItem> orderItems) {
		super();
		this.order = order;
		this.orderItems = orderItems;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
    
}
