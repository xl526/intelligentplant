package com.dp.intelligentplant.domain.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.dp.intelligentplant.domain.BaseDomain;

@Entity
@Table(name="MEDIA_FILE")
public class MediaFile extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6082848143613799737L;
	
	@Column(name="FILE_NAME")
	private String fileName;
	
	@Column(name="FILE_TYPE")
	private String fileType;
	
	@Column(name="FILE_SIZE")
	private Long fileSize;
	
	@Column(name="FILE_PATH")
	private String filePath;
	
	@Column(name="FILE_URL")
	private String fileUrl;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
}
