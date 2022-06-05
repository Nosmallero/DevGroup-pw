package pe.edu.upc.faveatfinal.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "restaurants")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	private Integer restaurantId;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category categoryId;
	
	@Column(name = "name_restaurants", length = 10, nullable = false)
	private String name_restaurant;

	@Column(name = "locations", length = 20, nullable = false)
	private String location;

	@Column(name = "capacities", columnDefinition = "NUMERIC(2)")
	private Integer capacity;

	@Column(name = "phones", length = 9, nullable = false)
	private String phone;

	@Column(name = "protocols", length = 200, nullable = false)
	private String protocol;

	@Column(name = "start_time")
	@Temporal(TemporalType.TIME)
	private Date serviceStart;
	
	@Column(name = "end_time")
	@Temporal(TemporalType.TIME)
	private Date serviceEnd;
	
	@Min(1)
	@Max(5)
	@Column(name = "qualifications")
	private Integer qualification;


	public Integer getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getName_restaurant() {
		return name_restaurant;
	}


	public void setName_restaurant(String name_restaurant) {
		this.name_restaurant = name_restaurant;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Integer getCapacity() {
		return capacity;
	}


	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getProtocol() {
		return protocol;
	}


	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}


	public Date getServiceStart() {
		return serviceStart;
	}


	public void setServiceStart(Date serviceStart) {
		this.serviceStart = serviceStart;
	}


	public Date getServiceEnd() {
		return serviceEnd;
	}


	public void setServiceEnd(Date serviceEnd) {
		this.serviceEnd = serviceEnd;
	}


	public Integer getQualification() {
		return qualification;
	}


	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}


	public Category getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}


}

