package com.dp.intelligentplant.controller;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dp.intelligentplant.domain.Knife;
import com.dp.intelligentplant.service.api.KnifeService;
import com.dp.intelligentplant.util.PageVO;
import com.dp.intelligentplant.util.ResultInfo;

@Controller
@RequestMapping("/knife")
public class KnifeController {
	
	@Resource
	private KnifeService knifeService;
	
	@RequestMapping("/page")
	@ResponseBody
	public Object page(PageVO<Knife> pageVO, Knife knife) {
//		PageRequest pageRequest = new PageRequest(pageVO.getPageIndex(), pageVO.getPageSize());
//		Page<Knife> page = knifeService.findKnifeByPage(pageRequest);
		
		Page<Knife> page = knifeService.findKnifeByPageAndParams(pageVO, knife);
		pageVO.setItemsCount(page.getTotalElements());
		pageVO.setData(page.getContent());
		return pageVO;
	}
	
	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public Object saveOrUpdate(Knife knife) {
		ResultInfo resultInfo = new ResultInfo(); 
		knifeService.saveKnife(knife);
		return resultInfo;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(Knife knife) {
		ResultInfo resultInfo = new ResultInfo(); 
		knifeService.deleteKnife(knife.getId());
		return resultInfo;
	}
	
}
