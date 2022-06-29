package pe.edu.upc.faveatfinal.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	private Integer reservationId;

	@Column(name = "type_reservation",length = 20, nullable = false)
	private String typeReservation;
	
	@Column(name = "date_start_reservation",length = 20, nullable = false)
	private String dateStartReservation;
	
	@Column(name = "date_end_reservation",length = 20, nullable = false)
	private String dateEndReservation;
	
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
	
	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public Restaurant getRestaurants() {
		return restaurant;
	}

	public void setRestaurants(Restaurant restaurants) {
		this.restaurant = restaurants;
	}

	public String getTypeReservation() {
		return typeReservation;
	}

	public void setTypeReservation(String typeReservation) {
		this.typeReservation = typeReservation;
	}

	public String getDateStartReservation() {
		return dateStartReservation;
	}

	public void setDateStartReservation(String dateStartReservation) {
		this.dateStartReservation = dateStartReservation;
	}

	public String getDateEndReservation() {
		return dateEndReservation;
	}

	public void setDateEndReservation(String dateEndReservation) {
		this.dateEndReservation = dateEndReservation;
	}
}
