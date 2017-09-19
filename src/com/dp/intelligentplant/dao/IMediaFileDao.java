package com.dp.intelligentplant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.dp.intelligentplant.domain.system.MediaFile;

@Repository
public interface IMediaFileDao extends JpaRepository<MediaFile, Long>, JpaSpecificationExecutor<MediaFile> {
	
}
