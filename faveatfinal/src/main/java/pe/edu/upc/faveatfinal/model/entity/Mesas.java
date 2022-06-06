package pe.edu.upc.faveatfinal.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mesas")
public class Mesas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tables_id")
	private Integer tablesId;

	@Column(name = "capacity_table")
	private Integer capacityTable;
	
	@Column(name = "type_table",length = 40, nullable = false)
	private String typeTable;
	
	public Integer getTablesId() {
		return tablesId;
	}

	public void setTablesId(Integer tablesId) {
		this.tablesId = tablesId;
	}

	public Integer getCapacityTable() {
		return capacityTable;
	}

	public void setCapacityTable(Integer capacityTable) {
		this.capacityTable = capacityTable;
	}

	public String getTypeTable() {
		return typeTable;
	}

	public void setTypeTable(String typeTable) {
		this.typeTable = typeTable;
	}
}