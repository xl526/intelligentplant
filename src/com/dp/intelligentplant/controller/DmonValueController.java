package com.dp.intelligentplant.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dp.intelligentplant.domain.DmonValue;
import com.dp.intelligentplant.service.api.DmonValueService;
import com.dp.intelligentplant.util.PageVO;

@Controller
@RequestMapping("/dmon/value")
public class DmonValueController {
	
	@Autowired
	private DmonValueService dmonValueService;
	
	@RequestMapping("/list")
	@ResponseBody
	public Object list() {
		List<DmonValue> data = dmonValueService.listDmonValue();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", data);
		return jsonObject;
	}
	
	@RequestMapping("/page")
	@ResponseBody
	public Object page(PageVO<DmonValue> pageVO, DmonValue dmonValue) {
		Page<DmonValue> page = dmonValueService.findDmonValueByPageAndParams(pageVO, dmonValue);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<DmonValue> list = page.getContent();
		for (DmonValue dv : list) {
			dv.setTimestampStr(df.format(dv.getTimestamp()));
		}
		pageVO.setItemsCount(page.getTotalElements());
		pageVO.setData(page.getContent());
		return pageVO;
	}
	
}
