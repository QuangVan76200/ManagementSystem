package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

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

import lombok.Data;

@Entity
@DynamicUpdate
@DynamicInsert
@Data
@Table(name = "Shelf")
public class Shelf implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "ShelfID")
	  private Long shelfId;

	  @Column(name = "Name", nullable = false)
	  private String name;

	  @Column(name = "Location", nullable = false)
	  private String location;

	  @Column(name = "Capacity", nullable = false)
	  private Integer capacity;
	  
	  @OneToMany(mappedBy = "shelf", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	  private List<Stock> listStock;
	  
	  
	  @ManyToOne
	  @JoinColumn(name ="WarehouseID")
	  private Warehouse warehouse;

}
