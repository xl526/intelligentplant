package com.dp.intelligentplant.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dp.intelligentplant.dao.IEquipmentStatusDao;
import com.dp.intelligentplant.domain.EquipmentStatus;
import com.dp.intelligentplant.service.api.EquipmentStatusService;
import com.dp.intelligentplant.util.PageVO;
import com.dp.intelligentplant.vo.EquipmentStatusVO;

@Service
public class EquipmentStatusServiceImpl implements EquipmentStatusService {
	
	@Autowired
	private IEquipmentStatusDao equipmentStatusDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<EquipmentStatus> findByEquipmentId(Long equipmentId, String param) {
		return equipmentStatusDao.findByEquipmentAndParam(equipmentId, param);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<EquipmentStatus> findByPageAndParams(PageVO<EquipmentStatus> pageVO, final EquipmentStatusVO equipmentStatusVO) {
		
		Page<EquipmentStatus> pageResult = equipmentStatusDao.findAll(new Specification<EquipmentStatus>() {
			
			@Override
			public Predicate toPredicate(Root<EquipmentStatus> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				if (equipmentStatusVO != null) {
					Predicate startTime = null;
					Predicate endTime = null;
					
					List<Predicate> list = new ArrayList<Predicate>();
					
					if (null != equipmentStatusVO.getStartTime())
						startTime = cb.greaterThanOrEqualTo(root.get("recordTime").as(Date.class), equipmentStatusVO.getStartTime());
					if (null != equipmentStatusVO.getEndTime())
						endTime = cb.lessThanOrEqualTo(root.get("recordTime").as(Date.class), equipmentStatusVO.getEndTime());
					
					if (startTime != null) list.add(startTime);
					if (endTime != null) list.add(endTime);
						
					Predicate[] queryArr = new Predicate[list.size()];
					list.toArray(queryArr);
					
					query.where(queryArr);
				}
				return null;
			}
		}, new PageRequest(pageVO.getPageIndex()-1, pageVO.getPageSize()));
		
		return pageResult;
		
	}
	
}
