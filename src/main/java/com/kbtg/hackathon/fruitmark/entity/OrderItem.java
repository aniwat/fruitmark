package com.kbtg.hackathon.fruitmark.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_item_id")
	private Integer orderItemId;
	
	/*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderId", nullable = false)*/
	private Integer orderId;
	
	private Integer orderAmt;
	private Timestamp orderDate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productId", nullable = false)
	private Product productId;
	
	public OrderItem() {
		super();
	}

	public OrderItem(Integer orderItemId, Integer orderId, Product productId, Integer orderAmt, Timestamp orderDate) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.productId = productId;
		this.orderAmt = orderAmt;
		this.orderDate = orderDate;
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}
	
	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}
	
	public Integer getOrderId() {
		return orderId;
	}
	
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public Product getProductId() {
		return productId;
	}
	
	public void setProductId(Product productId) {
		this.productId = productId;
	}
	
	public Integer getOrderAmt() {
		return orderAmt;
	}
	
	public void setOrderAmt(Integer orderAmt) {
		this.orderAmt = orderAmt;
	}
	
	public Timestamp getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	
}
