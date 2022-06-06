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
@Table(name = "deliverys")
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "tip", nullable = false)
	private float tip;
	@Column(name = "description", length = 200, nullable = false )
	private String description;
	
	@Column(name = "date_delivery", length = 50, nullable = false )
	private String dateDelivery;
	
	@ManyToOne
	@JoinColumn(name = "deliveryMan_id")
	private DeliveryMan deliveryMan;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getTip() {
		return tip;
	}

	public void setTip(float tip) {
		this.tip = tip;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateDelivery() {
		return dateDelivery;
	}

	public void setDateDelivery(String dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	public DeliveryMan getDeliveryMan() {
		return deliveryMan;
	}

	public void setDeliveryMan(DeliveryMan deliveryMan) {
		this.deliveryMan = deliveryMan;
	}

	
	
	
	
}
