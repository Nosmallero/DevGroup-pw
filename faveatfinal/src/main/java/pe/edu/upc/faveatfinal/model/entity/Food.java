package pe.edu.upc.faveatfinal.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "foods", indexes = {@Index(columnList = "name", name = "foods_index_name")})
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name",length = 40, nullable = false)
	private String name;
	
	@Column(name = "costs", nullable = false)
	private float cost;
	
	@Column(name = "stocks", nullable = false)
	private int stock;
	
	@Column(name = "descriptions", length = 100, nullable = false)
	private String description;

	@ManyToOne
	@JoinColumn(name = "menu_restaurant_id")
	private MenuRestaurant menuRestaurant;
	
	@Column(name = "images")
	private String image;
	
	@OneToMany(mappedBy = "food")
	private List<FoodsOrder> foodsOrder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MenuRestaurant getMenuRestaurant() {
		return menuRestaurant;
	}

	public void setMenuRestaurant(MenuRestaurant menuRestaurant) {
		this.menuRestaurant = menuRestaurant;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<FoodsOrder> getFoodsOrder() {
		return foodsOrder;
	}

	public void setFoodsOrder(List<FoodsOrder> foodsOrder) {
		this.foodsOrder = foodsOrder;
	}

	

}
