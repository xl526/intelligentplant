package com.dp.intelligentplant.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.dp.intelligentplant.domain.DmonDef;

@Repository
public interface IDmonDefDao extends JpaRepository<DmonDef, Long>, JpaSpecificationExecutor<DmonDef> {
	
	public List<DmonDef> findByBoxUid(String boxUid);
	
	public List<DmonDef> findByDeviceId(String deviceId);
}
