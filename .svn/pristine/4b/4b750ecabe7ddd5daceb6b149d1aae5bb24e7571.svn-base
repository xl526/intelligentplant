package com.dp.intelligentplant.service.api.materialpreparation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dp.intelligentplant.domain.materialpreparation.RawMaterialInStock;
import com.dp.intelligentplant.util.PageVO;

public interface RawMaterialInStockService {
	
	public void saveRawMaterialInStock(RawMaterialInStock rawMaterialInStock);
	
	public void deleteRawMaterialInStock(Long id);
	
	public Page<RawMaterialInStock> findRawMaterialInStockByPage(Pageable pageable);
	
	public Page<RawMaterialInStock> findRawMaterialInStockByPageAndParams(PageVO<RawMaterialInStock> pageVO, final RawMaterialInStock rawMaterialInStock);
	
}
