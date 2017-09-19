package com.dp.intelligentplant.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EQUIPMENTBRAND")
public class EquipmentBrand extends BaseDomain{
	
	@Column(name="NAME")
	private String name;
	@Column(name="DESCRIPTION")
	private String description;
	@ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)  
    @JoinColumn(name="EQUIPMENTTYPE")  
	private EquipmentType type;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public EquipmentType getType() {
		return type;
	}
	public void setType(EquipmentType type) {
		this.type = type;
	}
}
