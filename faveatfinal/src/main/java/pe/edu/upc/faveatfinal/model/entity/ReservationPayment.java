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
@Table(name = "reservationPayment", 
	indexes = {@Index(columnList = "id, nameReservation", name = "reservationPayment_index_id_nameReservation")})

public class ReservationPayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nameReservation", length = 100, nullable = false)	
	private String nameReservation;
	
	@Column(name = "paymentAmount", nullable = false)	
	private float paymentAmount;
	
	@ManyToOne
	@JoinColumn(name = "creditCard_id")
	private CreditCard creditCard;
	
	@OneToMany(mappedBy = "reservationPayment")
	private List<Reservation> reservations;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getNameReservation() {
		return nameReservation;
	}

	public void setNameReservation(String nameReservation) {
		this.nameReservation = nameReservation;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
}
