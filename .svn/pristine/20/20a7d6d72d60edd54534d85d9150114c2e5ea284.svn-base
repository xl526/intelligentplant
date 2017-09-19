package com.dp.intelligentplant.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="DMON_VALUE")
public class DmonValue extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1604308843369468326L;

	@Column(name="UID")
	private String uid;
	
	@Column(name="NAME")
	private String name;

	@Column(name="TIMESTAMP")
	private Date timestamp;
	
	@Column(name="VALUE")
	private String value;
	
	@Column(name="BOX_ID")
	private String boxId;
	
	@Column(name="GNAME")
	private String gname;
	
	@Transient
	private String timestampStr;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getTimestampStr() {
		return timestampStr;
	}

	public void setTimestampStr(String timestampStr) {
		this.timestampStr = timestampStr;
	}

}
