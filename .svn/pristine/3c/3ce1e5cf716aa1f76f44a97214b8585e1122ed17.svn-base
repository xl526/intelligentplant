package com.dp.intelligentplant.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.dp.intelligentplant.domain.Equipment;

@Repository
public interface IEquipmentDao extends JpaRepository<Equipment, Long>, JpaSpecificationExecutor<Equipment> {
	
	public List<Equipment> findByEname(String name);
	
}
