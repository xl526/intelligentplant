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

import com.dp.intelligentplant.dao.IDmonDefDao;
import com.dp.intelligentplant.domain.DmonDef;
import com.dp.intelligentplant.service.api.DmonDefService;
import com.dp.intelligentplant.util.PageVO;

@Service
public class DmonDefServiceImpl implements DmonDefService {
	
	@Resource
	private IDmonDefDao dmonDefDao;
	
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void saveDmonDef(DmonDef dmonDef) {
		dmonDefDao.save(dmonDef);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void deleteDmonDef(Long id) {
		dmonDefDao.delete(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<DmonDef> findDmonDefByPage(Pageable pageable) {
		Page<DmonDef> page = dmonDefDao.findAll(pageable);
		return page;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DmonDef> listDmonDef() {
		return dmonDefDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<DmonDef> findDmonDefByBoxUid(String boxUid) {
		return dmonDefDao.findByBoxUid(boxUid);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DmonDef> findDmonDefByDeviceId(String deviceId) {
		return dmonDefDao.findByDeviceId(deviceId);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<DmonDef> findDmonDefByPageAndParams(PageVO<DmonDef> pageVO, DmonDef dmonDef) {
		
		Page<DmonDef> pageResult = dmonDefDao.findAll(new Specification<DmonDef>() {
			
			@Override
			public Predicate toPredicate(Root<DmonDef> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				if (dmonDef != null) {
					Predicate boxUid = null;
					List<Predicate> list = new ArrayList<Predicate>();
					
					if (!StringUtils.isEmpty(dmonDef.getBoxUid()))
						boxUid = cb.equal(root.get("boxUid").as(String.class), dmonDef.getBoxUid());
					
					if (boxUid != null) list.add(boxUid);
						
					Predicate[] queryArr = new Predicate[list.size()];
					list.toArray(queryArr);
					
					query.where(queryArr);
				}
				return null;
			}
		}, new PageRequest(pageVO.getPageIndex()-1, pageVO.getPageSize()));
		
		return pageResult;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void syncDmonDef(List<DmonDef> dmonDefs) {
		dmonDefDao.deleteAllInBatch();
		for (DmonDef dmonDef : dmonDefs) {
			saveDmonDef(dmonDef);
		}
	}
	
}
