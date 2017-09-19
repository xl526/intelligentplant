package com.dp.intelligentplant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dp.intelligentplant.domain.DmonDef;
import com.dp.intelligentplant.service.api.DmonDefService;
import com.dp.intelligentplant.util.PageVO;

@Controller
@RequestMapping("/dmon/def")
public class DmonDefController {
	
	@Autowired
	private DmonDefService dmonDefService;
	
	@RequestMapping("/list")
	@ResponseBody
	public Object list() {
		List<DmonDef> data = dmonDefService.listDmonDef();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", data);
		return jsonObject;
	}
	
	@RequestMapping("/page")
	@ResponseBody
	public Object page(PageVO<DmonDef> pageVO, DmonDef dmonDef) {
		Page<DmonDef> page = dmonDefService.findDmonDefByPageAndParams(pageVO, dmonDef);
		pageVO.setItemsCount(page.getTotalElements());
		pageVO.setData(page.getContent());
		return pageVO;
	}
	
}
