package com.dp.intelligentplant.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dp.intelligentplant.dao.IMediaFileDao;
import com.dp.intelligentplant.domain.system.MediaFile;
import com.dp.intelligentplant.service.api.MediaFileService;

@Service
public class MediaFileServiceImpl implements MediaFileService {
	
	@Resource
	private IMediaFileDao mediaFileDao;
	
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void saveMediaFile(MediaFile mediaFile) {
		mediaFileDao.save(mediaFile);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void deleteMediaFile(Long id) {
		mediaFileDao.delete(id);
	}
	
}
