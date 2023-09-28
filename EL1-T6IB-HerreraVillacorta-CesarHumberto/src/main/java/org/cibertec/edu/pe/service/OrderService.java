package org.cibertec.edu.pe.service;

import java.math.BigDecimal;
import java.util.Set;

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
	public int save(Order order, Set<OrderItem> orderItems) {
		int hasSaved = 0;
		orderItems.forEach(orderItem -> order.addOrderItem(orderItem));
		Order dbOrder = data.save(order);
		if(!dbOrder.equals(null)) hasSaved = -1;
		return hasSaved;
	}
	
	@Override
	public Order calculate(Order order) {
		order.setDeliveryCost(new BigDecimal(0));
		order.setDiscount(new BigDecimal(0));
		order.setProductCost(new BigDecimal(0));
		order.getOrderItems().forEach(item -> order.setProductCost(item.getProduct().getPrice().add(order.getProductCost())));
		order.setTotalAmount(order.getProductCost().add(order.getDeliveryCost()).subtract(order.getDiscount()));
		return order;
	}

}
