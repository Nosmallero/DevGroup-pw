package pe.edu.upc.faveatfinal.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "foods_orders")
public class FoodsOrder {
	
	@Id
	@Column(name="food_order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "food_id")
	private Food food;
	
	@Column(name = "quantity_food", columnDefinition = "NUMERIC(4)", nullable=false)
	private Integer quantityFood;
	
	@Column(name = "cost_total", columnDefinition = "DECIMAL(8,2)", nullable=false)
	private Float  costTotal;

	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	

	public Integer getQuantityFood() {
		return quantityFood;
	}

	public void setQuantityFood(Integer quantityFood) {
		this.quantityFood = quantityFood;
	}

	public Float getCostTotal() {
		return costTotal;
	}

	public void setCostTotal(Float costTotal) {
		this.costTotal = costTotal;
	}
	
	/*
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "food_id")
	private Food food;*/
	
}
