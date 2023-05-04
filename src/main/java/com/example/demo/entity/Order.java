package com.example.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.example.demo.enums.OrderStatusType;
import com.example.demo.enums.OrderType;

import lombok.Data;

@Entity
@DynamicUpdate
@DynamicInsert
@Data

@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, referencedColumnName = "userId")
	private User user;

	@Column(name = "OrderDate", nullable = false)
	private Date orderDate;

	@Column(name = "Status", nullable = false, length = 20)
	private OrderStatusType status;

	@Column(name = "TypeOrder", nullable = false, length = 50)
	private OrderType typeOrder;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<Invoice> invoices;
	
	@OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL)
	private Set<OrderItem> orderItem;

	public void addInvoice(Invoice invoice) {
		invoices.add(invoice);
		invoice.setOrder(this);
	}
	
	
 
}
