package com.dp.intelligentplant.util;

public enum EquipmentStatusEnum {
	
	STATUS_0("下线", "0"),
	
	STATUS_1("在线", "1");
	
	private String name;
	
	private String value;
	
	private EquipmentStatusEnum(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public static String getNameByValue(String value) {
		for (EquipmentStatusEnum e : EquipmentStatusEnum.values()) {
			if (e.value == value)
				return e.name;
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
