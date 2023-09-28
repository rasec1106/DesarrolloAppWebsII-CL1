package org.cibertec.edu.pe.model;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;
	@OneToOne
	@JoinColumn(name="productId")
	private Product product;
	private BigDecimal quantity;
	private BigDecimal discount;
	private BigDecimal subtotal;
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;
	
	public OrderItem() {
		super();
	}

	public OrderItem(Long orderItemId, Product product, BigDecimal discount, BigDecimal subtotal, Order order, BigDecimal quantity) {
		super();
		this.orderItemId = orderItemId;
		this.product = product;
		this.discount = discount;
		this.subtotal = subtotal;
		this.order = order;
		this.quantity = quantity;
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

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
