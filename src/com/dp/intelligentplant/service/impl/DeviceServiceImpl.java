package com.dp.intelligentplant.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dp.intelligentplant.dao.IDeviceDao;
import com.dp.intelligentplant.domain.Device;
import com.dp.intelligentplant.service.api.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {
	
	@Resource
	private IDeviceDao deviceDao;

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public void saveDevice(Device device) {
		deviceDao.save(device);
	}

	@Override
	public void deleteDevice(Long id) {
		deviceDao.delete(id);
	}
	
	@Override
	public Page<Device> findDeviceByPage(Pageable pageable) {
		Page<Device> page = deviceDao.findAll(pageable);
		return page;
	}
	
	
}
