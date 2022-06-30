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
@Table(name = "deliveryPayment", 
	indexes = {@Index(columnList = "id, nameDelivery", name = "deliveryPayment_index_id_nameDelivery")})

public class DeliveryPayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nameDelivery", length = 100)	
	private String nameDelivery;
	
	@Column(name = "payment_Amount", nullable = false)	
	private float payment_Amount;
	

	
	@ManyToOne
	@JoinColumn(name = "deliveryMan_id")
	private DeliveryMan deliveryMan;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameDelivery() {
		return nameDelivery;
	}

	public void setNameDelivery(String nameDelivery) {
		this.nameDelivery = nameDelivery;
	}

	public float getPayment_Amount() {
		return payment_Amount;
	}

	public void setPayment_Amount(float payment_Amount) {
		this.payment_Amount = payment_Amount;
	}

	

	public DeliveryMan getDeliveryMan() {
		return deliveryMan;
	}

	public void setDeliveryMan(DeliveryMan deliveryMan) {
		this.deliveryMan = deliveryMan;
	}

}