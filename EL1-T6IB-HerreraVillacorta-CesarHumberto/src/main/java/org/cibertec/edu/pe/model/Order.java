package org.cibertec.edu.pe.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="Orders")
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
	private Date orderDate;
	private BigDecimal productCost;
	private BigDecimal deliveryCost;
	private BigDecimal discount;
	private BigDecimal totalAmount;
	@OneToMany(mappedBy = "order" // name of the VARIABLE in the child class
            ,cascade = CascadeType.ALL) // to save also the into the child db
    private Set<OrderItem> orderItems;
	
	public void addOrderItem(OrderItem orderItem){
        if(orderItems == null){
            orderItems = new HashSet<>();
        }
        orderItems.add(orderItem);
        orderItem.setOrder(this);;
    }

	public Order() {
		super();
	}

	public Order(Long orderId, Date orderDate, BigDecimal productCost, BigDecimal deliveryCost, BigDecimal discount,
			BigDecimal totalAmount, Set<OrderItem> orderItems) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.productCost = productCost;
		this.deliveryCost = deliveryCost;
		this.discount = discount;
		this.totalAmount = totalAmount;
		this.orderItems = orderItems;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getProductCost() {
		return productCost;
	}

	public void setProductCost(BigDecimal productCost) {
		this.productCost = productCost;
	}

	public BigDecimal getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(BigDecimal deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
}
