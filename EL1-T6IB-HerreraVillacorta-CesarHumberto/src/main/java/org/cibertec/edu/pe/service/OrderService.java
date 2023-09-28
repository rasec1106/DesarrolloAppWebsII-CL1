package org.cibertec.edu.pe.service;

import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IOrderService;
import org.cibertec.edu.pe.interfaces.IOrder;
import org.cibertec.edu.pe.model.Order;
import org.cibertec.edu.pe.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private IOrder data;
	
	@Override
	public int placeOrder(Order order) {
		int hasSaved = 0;
		Order dbOrder = data.save(order);
		if(!dbOrder.equals(null)) hasSaved = -1;
		return hasSaved;
	}

	@Override
	public void addOrderItem(Long orderId, OrderItem orderItem) {
		Optional<Order> order = search(orderId);
		if(!order.equals(null)) {
			Order o = order.get();
			o.addOrderItem(orderItem);
		}
	}

	@Override
	public Optional<Order> search(Long orderId) {
		return data.findById(orderId);
	}

}
