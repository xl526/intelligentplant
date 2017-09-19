package com.dp.intelligentplant.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dp.intelligentplant.domain.system.MediaFile;

@Entity
@Table(name="EQUIPMENT")
public class Equipment extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7733805311850035229L;

	@Column(name="ENO")
	private String eno;

	@Column(name="ENAME")
	private String ename;
	
	@Column(name="EDESCRIPTION")
	private String edescription;
	
	@Column(name="STATUS")
	private String status;
	
	@ManyToOne(cascade = {CascadeType.REFRESH}, optional = true)
    @JoinColumn(name="BRAND")
	private EquipmentBrand brand;
	
	@ManyToOne(cascade = {CascadeType.REFRESH}, optional = true)
    @JoinColumn(name="IMAGE")
	private MediaFile image;
	
	@Column(name="ORGANIZATION")
	private String organization;
	
	@Column(name="PRODUCT_LINE")
	private String productLine;
	
	@Column(name="WORK_PLACE")
	private String workPlace;
	
	@Column(name="MODEL")
	private String model;

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getEdescription() {
		return edescription;
	}

	public void setEdescription(String edescription) {
		this.edescription = edescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EquipmentBrand getBrand() {
		return brand;
	}

	public void setBrand(EquipmentBrand brand) {
		this.brand = brand;
	}

	public MediaFile getImage() {
		return image;
	}

	public void setImage(MediaFile image) {
		this.image = image;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
}
