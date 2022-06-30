package pe.edu.upc.faveatfinal.model.entity;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "customers", indexes = {@Index(columnList = "last_name", name = "customer_index_last_name")})
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "email", length = 50, nullable = false )
	private String email;
	@Column(name = "first_name", length = 60, nullable = false )
	private String firstName;
	@Column(name = "last_name", length = 60, nullable = false )
	private String lastName;
	@Column(name = "phone", length = 9, nullable = false )
	private String phone;
	@Column(name = "address", length = 100, nullable = false )
	private String address;
	
	@OneToMany(mappedBy = "customer")
	private List<Delivery> delivery;
	
	@OneToMany(mappedBy = "customer")
	private List<Reservation> reservation;
	

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Delivery> getDelivery() {
		return delivery;
	}

	public void setDelivery(List<Delivery> delivery) {
		this.delivery = delivery;
	}

}
