package com.dp.intelligentplant.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@Table(name="EQUIPMENT_STATUS")
public class EquipmentStatus extends BaseDomain {

	@Column(name="EQUIPMENT")
	private Long equipment;

	@Column(name="PARAM")
	private String param;
	
	@Column(name="VALUE")
	private String value;
	
	@Column(name="RECORD_TIME")
	private Date recordTime;

	public Long getEquipment() {
		return equipment;
	}

	public void setEquipment(Long equipment) {
		this.equipment = equipment;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	
}
