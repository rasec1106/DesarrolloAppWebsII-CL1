package org.cibertec.edu.pe.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;
	@Embedded // to tell hibernate that it should see the product class
	private Product product;
	private double discount;
	private double subtotal;
	@ManyToOne
	@JoinColumn(name="orderId") //name of the COLUMN in the db table - not the class
	private Order order;
	
	public OrderItem() {
		super();
	}

	public OrderItem(Long orderItemId, Product product, double discount, double subtotal, Order order) {
		super();
		this.orderItemId = orderItemId;
		this.product = product;
		this.discount = discount;
		this.subtotal = subtotal;
		this.order = order;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
