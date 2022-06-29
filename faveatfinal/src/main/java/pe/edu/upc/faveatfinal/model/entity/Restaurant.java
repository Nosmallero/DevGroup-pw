package pe.edu.upc.faveatfinal.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Table(name = "restaurants")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category categoryId;
	
	@Column(name = "name_restaurants", length = 50, nullable = false)
	private String name_restaurant;

	@Column(name = "locations", length = 20, nullable = false)
	private String location;

	@Column(name = "capacities", columnDefinition = "NUMERIC(2)")
	private Integer capacity;

	@Column(name = "phones", length = 9, nullable = false)
	private String phone;

	@Column(name = "protocols", length = 200)
	private String protocol;

	@Column(name = "start_time", length = 50, nullable = false)
	private String serviceStart;
	
	@Column(name = "end_time", length = 50, nullable = false)
	private String serviceEnd;
	
	@Column(name = "images")
	private String image;
	
	@Min(1)
	@Max(5)
	@Column(name = "qualifications")
	private Integer qualification;

	@OneToMany(mappedBy = "restaurant")
	private List<MenuRestaurant> menuRestaurant;
	
	@OneToMany(mappedBy = "restaurant")
	private List<Reservation> reservation;

	public Integer getId() {
		return id;
	}



	public List<Reservation> getReservation() {
		return reservation;
	}



	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}



	public void setId(Integer id) {
		this.id = id;
	}


	public Category getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
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


	public String getServiceStart() {
		return serviceStart;
	}


	public void setServiceStart(String serviceStart) {
		this.serviceStart = serviceStart;
	}


	public String getServiceEnd() {
		return serviceEnd;
	}


	public void setServiceEnd(String serviceEnd) {
		this.serviceEnd = serviceEnd;
	}


	public Integer getQualification() {
		return qualification;
	}


	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public List<MenuRestaurant> getMenuRestaurant() {
		return menuRestaurant;
	}


	public void setMenuRestaurant(List<MenuRestaurant> menuRestaurant) {
		this.menuRestaurant = menuRestaurant;
	}
	
	

}

