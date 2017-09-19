package com.dp.intelligentplant.util;

public enum EquipmentTypeEnum {
	
	TYPE_0("PLC设备", "PLC"),
	
	TYPE_1("数控设备", "CNC");
	
	private String name;
	
	private String value;
	
	private EquipmentTypeEnum(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public static String getNameByValue(String value) {
		for (EquipmentTypeEnum e : EquipmentTypeEnum.values()) {
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
