package com.dp.intelligentplant.fbox;

public class DefVO {
	
	//监控点uid
	private String uid;
	
	//名称
	private String name;
	
	//描述
	private String desc;
	
	//盒子boxUid
	private String boxUid;
	
	//单位
	private String unit;
	
	//整数位
	private String intDigits;
	
	//小数位
	private String fracDigits;
	
	//数据类型
	private String dataType;

	private DefSrc src;

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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getBoxUid() {
		return boxUid;
	}

	public void setBoxUid(String boxUid) {
		this.boxUid = boxUid;
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

	public DefSrc getSrc() {
		return src;
	}

	public void setSrc(DefSrc src) {
		this.src = src;
	}
	
}
