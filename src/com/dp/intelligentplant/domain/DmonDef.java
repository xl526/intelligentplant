package com.dp.intelligentplant.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="DMON_DEF")
public class DmonDef extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7651456648074063942L;

	@Column(name="UID")
	private String uid;
	
	@Column(name="NAME")
	private String name;

	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="UNIT")
	private String unit;
	
	@Column(name="INT_DIGITS")
	private String intDigits;
	
	@Column(name="FRAC_DIGITS")
	private String fracDigits;
	
	@Column(name="DATA_TYPE")
	private String dataType;
	
	@Column(name="MAIN_ADDR")
	private String mainAddr;
	
	@Column(name="SUB_ADDR")
	private String subAddr;
	
	@Column(name="SUB_INDEX")
	private String subIndex;
	
	@Column(name="SERVER_ID")
	private String serverId;
	
	@Column(name="PORT_NO")
	private String portNo;
	
	@Column(name="STATION_NO")
	private String stationNo;
	
	@Column(name="DEVICE_ID")
	private String deviceId;
	
	@Column(name="BOX_UID")
	private String boxUid;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getIntDigits() {
		return intDigits;
	}

	public void setIntDigits(String intDigits) {
		this.intDigits = intDigits;
	}

	public String getFracDigits() {
		return fracDigits;
	}

	public void setFracDigits(String fracDigits) {
		this.fracDigits = fracDigits;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getMainAddr() {
		return mainAddr;
	}

	public void setMainAddr(String mainAddr) {
		this.mainAddr = mainAddr;
	}

	public String getSubAddr() {
		return subAddr;
	}

	public void setSubAddr(String subAddr) {
		this.subAddr = subAddr;
	}

	public String getSubIndex() {
		return subIndex;
	}

	public void setSubIndex(String subIndex) {
		this.subIndex = subIndex;
	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public String getPortNo() {
		return portNo;
	}

	public void setPortNo(String portNo) {
		this.portNo = portNo;
	}

	public String getStationNo() {
		return stationNo;
	}

	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getBoxUid() {
		return boxUid;
	}

	public void setBoxUid(String boxUid) {
		this.boxUid = boxUid;
	}
	
}
