package com.dp.intelligentplant.domain.materialpreparation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.dp.intelligentplant.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="RAW_MATERIAL_INSTOCK")
public class RawMaterialInStock extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8104589662439389476L;

	@Column(name="BATCH")
	private String batch;

	@Column(name="NUM")
	private long num;
	
	@Column(name="RECORD_TIME")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date recordTime;

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	
}
