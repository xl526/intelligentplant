package com.dp.intelligentplant.service.impl.materialpreparation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.dp.intelligentplant.dao.materialpreparation.IRawMaterialInStockDao;
import com.dp.intelligentplant.domain.Knife;
import com.dp.intelligentplant.domain.materialpreparation.RawMaterialInStock;
import com.dp.intelligentplant.service.api.KnifeService;
import com.dp.intelligentplant.service.api.materialpreparation.RawMaterialInStockService;
import com.dp.intelligentplant.util.PageVO;

@Service
public class RawMaterialInStockServiceImpl implements RawMaterialInStockService {
	
	@Autowired
	private IRawMaterialInStockDao rawMaterialInStockDao;
	
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void saveRawMaterialInStock(RawMaterialInStock rawMaterialInStock) {
		rawMaterialInStock.setRecordTime(new Date());
		rawMaterialInStockDao.save(rawMaterialInStock);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void deleteRawMaterialInStock(Long id) {
		rawMaterialInStockDao.delete(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<RawMaterialInStock> findRawMaterialInStockByPage(Pageable pageable) {
		Page<RawMaterialInStock> page = rawMaterialInStockDao.findAll(pageable);
		return page;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<RawMaterialInStock> findRawMaterialInStockByPageAndParams(PageVO<RawMaterialInStock> pageVO, final RawMaterialInStock rawMaterialInStock) {
		
		Page<RawMaterialInStock> pageResult = rawMaterialInStockDao.findAll(new Specification<RawMaterialInStock>() {
			
			@Override
			public Predicate toPredicate(Root<RawMaterialInStock> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				return null;
			}
		}, new PageRequest(pageVO.getPageIndex()-1, pageVO.getPageSize()));
		
		return pageResult;
		
	}
	
	
}
