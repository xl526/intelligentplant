package com.dp.intelligentplant.util;

import com.alibaba.fastjson.JSONObject;

public class ResultInfo {
	
	private boolean success;
	
	private String code;
	
	private Object data;
	
	private String msg;

	
	public ResultInfo() {
		this.success = true;
		this.code = "200";
		this.data = null;
		this.msg = "ok";
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
