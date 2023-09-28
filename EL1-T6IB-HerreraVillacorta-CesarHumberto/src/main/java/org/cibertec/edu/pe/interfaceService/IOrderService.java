package org.cibertec.edu.pe.interfaceService;

import java.util.Optional;

import org.cibertec.edu.pe.model.Order;
import org.cibertec.edu.pe.model.OrderItem;

public interface IOrderService {
	public int placeOrder(Order order);
	public Optional<Order> search(Long orderId);
	public void addOrderItem(Long orderId, OrderItem orderItem);
}
