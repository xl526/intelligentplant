package com.dp.intelligentplant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.dp.intelligentplant.domain.DmonValue;

@Repository
public interface IDmonValueDao extends JpaRepository<DmonValue, Long>, JpaSpecificationExecutor<DmonValue> {
	
}
