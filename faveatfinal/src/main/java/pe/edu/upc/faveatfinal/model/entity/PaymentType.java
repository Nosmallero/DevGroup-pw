package pe.edu.upc.faveatfinal.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "paymentType", indexes = {@Index(columnList = "namePaymentType", name = "paymentType_index_namePaymentType")})
public class PaymentType {
	@Id
	@Column(name = "id", length = 3)
	private Integer id;
	
	@Column(name = "namePaymentType", length = 20, nullable = false)
	private String namePaymentType;
	
	@Column(name = "detail", length = 100, nullable = false)
	private String detail;
	
	@OneToMany(mappedBy = "paymentType")
	private List<ReservationPayment> reservationPayments;
	

	public PaymentType() {
		reservationPayments = new ArrayList<>();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNamePaymentType() {
		return namePaymentType;
	}

	public void setNamePaymentType(String namePaymentType) {
		this.namePaymentType = namePaymentType;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public List<ReservationPayment> getReservationPayments() {
		return reservationPayments;
	}

	public void setReservationPayments(List<ReservationPayment> reservationPayments) {
		this.reservationPayments = reservationPayments;
	}

}
