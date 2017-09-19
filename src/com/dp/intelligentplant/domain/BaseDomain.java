package com.dp.intelligentplant.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@MappedSuperclass
public class BaseDomain implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	protected Long id;

	@Column(name="CREATE_USER")
	protected Long createUser;
	
	@Column(name="CREATE_TIME")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	protected Date createTime;
	
	@Column(name="UPDATE_USER")
	protected Long updateUser;
	
	@Column(name="UPDATE_TIME")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	protected Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
