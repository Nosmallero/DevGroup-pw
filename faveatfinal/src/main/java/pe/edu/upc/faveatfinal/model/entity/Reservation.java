package pe.edu.upc.faveatfinal.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reservation",
		indexes = {@Index(columnList = "id" , name = "reservation_index_id")})

public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "date_start_reservation", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateStartReservation;
	
	@Column(name = "date_end_reservation", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateEndReservation;
	
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;

	@ManyToOne
	@JoinColumn(name = "reservationPayment_id")
	private ReservationPayment reservationPayment;
	
	@ManyToOne
	@JoinColumn(name = "creditCard_id")
	private CreditCard creditCard;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public ReservationPayment getReservationPayment() {
		return reservationPayment;
	}

	public void setReservationPayment(ReservationPayment reservationPayment) {
		this.reservationPayment = reservationPayment;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Restaurant getRestaurants() {
		return restaurant;
	}

	public void setRestaurants(Restaurant restaurants) {
		this.restaurant = restaurants;
	}

	public Date getDateStartReservation() {
		return dateStartReservation;
	}

	public void setDateStartReservation(Date dateStartReservation) {
		this.dateStartReservation = dateStartReservation;
	}

	public Date getDateEndReservation() {
		return dateEndReservation;
	}

	public void setDateEndReservation(Date dateEndReservation) {
		this.dateEndReservation = dateEndReservation;
	}
	
}
