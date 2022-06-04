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
@Table(name = "reservationPayment", 
	indexes = {@Index(columnList = "id, nameReservation", name = "reservationPayment_index_id_nameReservation")})

public class ReservationPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nameReservation", length = 20, nullable = false)	
	private String nameReservation;
	
	@Column(name = "paymentAmount", nullable = false)	
	private float paymentAmount;
	
	@ManyToOne
	@JoinColumn(name = "paymentType_id")
	private PaymentType paymentType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

}
