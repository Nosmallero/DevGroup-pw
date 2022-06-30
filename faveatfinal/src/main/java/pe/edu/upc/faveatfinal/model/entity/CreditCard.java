package pe.edu.upc.faveatfinal.model.entity;

import java.util.ArrayList;
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
@Table(name = "creditCard", indexes = {@Index(columnList = "typeCard", name = "creditCard_index_typeCard")})

public class CreditCard {
	
	@Id
	@Column(name="creditcard_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "numberCard", length = 16, nullable = false)
	private String numberCard;
	
	@Column(name = "securityCode", length = 10, nullable = false)
	private Integer securityCode;
	
	@Column(name = "typeCard", length = 20, nullable = false)
	private String typeCard;
	
	@Column(name = "expirationDate", length = 20, nullable = false)
	private String expirationDate;
	
	@OneToMany(mappedBy = "creditCard")
	private List<ReservationPayment> reservationPayments;
	
	@OneToMany(mappedBy = "creditCard")
	private List<Delivery> delivery;
	
	
	/*@OneToMany(mappedBy = "creditCard")
	private List<DeliveryPayment> deliveryPayments;*/
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(String numberCard) {
		this.numberCard = numberCard;
	}

	public Integer getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(Integer securityCode) {
		this.securityCode = securityCode;
	}

	public String getTypeCard() {
		return typeCard;
	}

	public void setTypeCard(String typeCard) {
		this.typeCard = typeCard;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public List<ReservationPayment> getReservationPayments() {
		return reservationPayments;
	}

	public void setReservationPayments(List<ReservationPayment> reservationPayments) {
		this.reservationPayments = reservationPayments;
	}

	public List<Delivery> getDelivery() {
		return delivery;
	}

	public void setDelivery(List<Delivery> delivery) {
		this.delivery = delivery;
	}

	
	/*public List<DeliveryPayment> getDeliveryPayments() {
		return deliveryPayments;
	}

	public void setDeliveryPayments(List<DeliveryPayment> deliveryPayments) {
		this.deliveryPayments = deliveryPayments;
	}*/

}
	