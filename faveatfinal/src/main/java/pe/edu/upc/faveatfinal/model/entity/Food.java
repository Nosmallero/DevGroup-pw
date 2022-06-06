package pe.edu.upc.faveatfinal.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "foods", indexes = {@Index(columnList = "food_name", name = "foods_index_food_name")})
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	private Integer foodId;

	@Column(name = "food_name",length = 40, nullable = false)
	private String foodName;
	
	@Column(name = "costs", nullable = false)
	private Float cost;
	
	@Column(name = "descriptions", length = 100, nullable = false)
	private String description;

	@ManyToOne
	@JoinColumn(name = "menu_restaurant_id")
	private MenuRestaurant menuRestaurant;

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
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

	

}
