package com.dp.intelligentplant.service.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dp.intelligentplant.domain.DmonDef;
import com.dp.intelligentplant.domain.DmonValue;
import com.dp.intelligentplant.util.PageVO;

public interface DmonValueService {
	
	public void saveDmonValue(DmonValue dmonValue);
	
	public void deleteDmonValue(Long id);
	
	public Page<DmonValue> findDmonValueByPage(Pageable pageable);
	
	public List<DmonValue> listDmonValue();
	
	public void syncDmonValue(List<DmonValue> dmonValues);
	
	public Page<DmonValue> findDmonValueByPageAndParams(PageVO<DmonValue> pageVO, final DmonValue dmonValue);
	
}
