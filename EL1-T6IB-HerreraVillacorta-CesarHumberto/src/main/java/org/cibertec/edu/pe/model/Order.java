package org.cibertec.edu.pe.model;

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
@Entity
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
	private Date orderDate;
	private double productCost;
	private double deliveryCost;
	private double discount;
	private double totalAmount;
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

	public Order(Long orderId, Date orderDate, double productCost, double deliveryCost, double discount,
			double totalAmount, Set<OrderItem> orderItems) {
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

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	public double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
}
