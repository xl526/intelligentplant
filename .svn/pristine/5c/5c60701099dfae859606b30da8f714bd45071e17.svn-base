package com.dp.intelligentplant.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.dp.intelligentplant.dao.IKnifeDao;
import com.dp.intelligentplant.domain.Knife;
import com.dp.intelligentplant.service.api.KnifeService;
import com.dp.intelligentplant.util.PageVO;

@Service
public class KnifeServiceImpl implements KnifeService {
	
	@Resource
	private IKnifeDao knifeDao;
	
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void saveKnife(Knife knife) {
		knifeDao.save(knife);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void deleteKnife(Long id) {
		knifeDao.delete(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Knife> findKnifeByPage(Pageable pageable) {
		Page<Knife> page = knifeDao.findAll(pageable);
		return page;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Knife> findKnifeByPageAndParams(PageVO<Knife> pageVO, final Knife knife) {
		
		Page<Knife> pageResult = knifeDao.findAll(new Specification<Knife>() {
			
			@Override
			public Predicate toPredicate(Root<Knife> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				if (knife != null) {
					Predicate no = null;
					Predicate device = null;
					Predicate manageType = null;
					Predicate unit = null;
					Predicate maxTime = null;
					Predicate warningTime = null;
					List<Predicate> list = new ArrayList<Predicate>();
					
					if (!StringUtils.isEmpty(knife.getNo()))
						no = cb.like(root.get("no").as(String.class), "%" + knife.getNo() + "%");
					if (!StringUtils.isEmpty(knife.getDevice()))
						device = cb.like(root.get("device").as(String.class), "%" + knife.getDevice() + "%");
					if (!StringUtils.isEmpty(knife.getManageType()))
						manageType = cb.equal(root.get("manageType").as(String.class), knife.getManageType());
					if (!StringUtils.isEmpty(knife.getUnit()))
						unit = cb.equal(root.get("unit").as(String.class), knife.getUnit());
					if (!StringUtils.isEmpty(knife.getMaxTime()))
						maxTime = cb.equal(root.get("maxTime").as(String.class), knife.getMaxTime());
					if (!StringUtils.isEmpty(knife.getWarningTime()))
						warningTime = cb.equal(root.get("warningTime").as(String.class), knife.getWarningTime());
					
					if (no != null) list.add(no);
					if (device != null) list.add(device);
					if (manageType != null) list.add(manageType);
					if (unit != null) list.add(unit);
					if (maxTime != null) list.add(maxTime);
					if (warningTime != null) list.add(warningTime);
						
					Predicate[] queryArr = new Predicate[list.size()];
					list.toArray(queryArr);
					
					query.where(queryArr);
				}
				return null;
			}
		}, new PageRequest(pageVO.getPageIndex()-1, pageVO.getPageSize(), new Sort(Direction.ASC, "no")));
		
		return pageResult;
		
	}
	
	
}
