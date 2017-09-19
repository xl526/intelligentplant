package com.dp.intelligentplant.service.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dp.intelligentplant.domain.DmonDef;
import com.dp.intelligentplant.domain.Knife;
import com.dp.intelligentplant.util.PageVO;

public interface DmonDefService {
	
	public void saveDmonDef(DmonDef dmonDef);
	
	public void deleteDmonDef(Long id);
	
	public Page<DmonDef> findDmonDefByPage(Pageable pageable);
	
	public Page<DmonDef> findDmonDefByPageAndParams(PageVO<DmonDef> pageVO, final DmonDef dmonDef);
	
	public List<DmonDef> listDmonDef();
	
	public List<DmonDef> findDmonDefByBoxUid(String boxUid);
	
	public List<DmonDef> findDmonDefByDeviceId(String deviceId);
	
	public void syncDmonDef(List<DmonDef> dmonDefs);
	
}
