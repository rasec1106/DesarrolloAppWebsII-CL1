package org.cibertec.edu.pe.interfaceService;

import java.util.Set;

import org.cibertec.edu.pe.model.Order;
import org.cibertec.edu.pe.model.OrderItem;

public interface IOrderService {
	public int save(Order order, Set<OrderItem> orderItems);
	public Order calculate(Order order);
}
