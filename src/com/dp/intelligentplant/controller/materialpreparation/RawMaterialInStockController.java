package com.dp.intelligentplant.controller.materialpreparation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dp.intelligentplant.domain.materialpreparation.RawMaterialInStock;
import com.dp.intelligentplant.service.api.materialpreparation.RawMaterialInStockService;
import com.dp.intelligentplant.util.PageVO;
import com.dp.intelligentplant.util.ResultInfo;

@Controller
@RequestMapping("/rawMaterialInStock")
public class RawMaterialInStockController {
	
	@Autowired
	private RawMaterialInStockService rawMaterialInStockService;
	
	@RequestMapping("/page")
	@ResponseBody
	public Object page(PageVO<RawMaterialInStock> pageVO, RawMaterialInStock rawMaterialInStock) {
		Page<RawMaterialInStock> page = rawMaterialInStockService.findRawMaterialInStockByPageAndParams(pageVO, rawMaterialInStock);
		pageVO.setItemsCount(page.getTotalElements());
		pageVO.setData(page.getContent());
		return pageVO;
	}
	
	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public Object saveOrUpdate(RawMaterialInStock rawMaterialInStock) {
		ResultInfo resultInfo = new ResultInfo(); 
		rawMaterialInStockService.saveRawMaterialInStock(rawMaterialInStock);
		return resultInfo;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(RawMaterialInStock rawMaterialInStock) {
		ResultInfo resultInfo = new ResultInfo(); 
		rawMaterialInStockService.deleteRawMaterialInStock(rawMaterialInStock.getId());
		return resultInfo;
	}
	
}
