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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.dp.intelligentplant.dao.IDmonValueDao;
import com.dp.intelligentplant.domain.DmonValue;
import com.dp.intelligentplant.service.api.DmonValueService;
import com.dp.intelligentplant.util.PageVO;

@Service
public class DmonValueServiceImpl implements DmonValueService {
	
	@Resource
	private IDmonValueDao dmonValueDao;
	
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void saveDmonValue(DmonValue dmonValue) {
		dmonValueDao.save(dmonValue);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void deleteDmonValue(Long id) {
		dmonValueDao.delete(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<DmonValue> findDmonValueByPage(Pageable pageable) {
		Page<DmonValue> page = dmonValueDao.findAll(pageable);
		return page;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DmonValue> listDmonValue() {
		return dmonValueDao.findAll();
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void syncDmonValue(List<DmonValue> dmonValues) {
		dmonValueDao.deleteAllInBatch();
		for (DmonValue dmonValue : dmonValues) {
			saveDmonValue(dmonValue);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Page<DmonValue> findDmonValueByPageAndParams(PageVO<DmonValue> pageVO, DmonValue dmonValue) {
		
		Page<DmonValue> pageResult = dmonValueDao.findAll(new Specification<DmonValue>() {
			
			@Override
			public Predicate toPredicate(Root<DmonValue> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				if (dmonValue != null) {
					Predicate boxId = null;
					List<Predicate> list = new ArrayList<Predicate>();
					
					if (!StringUtils.isEmpty(dmonValue.getBoxId()))
						boxId = cb.equal(root.get("boxId").as(String.class), dmonValue.getBoxId());
					
					if (boxId != null) list.add(boxId);
						
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
