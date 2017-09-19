package com.dp.intelligentplant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dp.intelligentplant.domain.Equipment;
import com.dp.intelligentplant.domain.EquipmentBrand;
import com.dp.intelligentplant.domain.EquipmentRegion;
import com.dp.intelligentplant.domain.EquipmentStatus;
import com.dp.intelligentplant.domain.EquipmentType;
import com.dp.intelligentplant.service.api.EquipmentService;
import com.dp.intelligentplant.service.api.EquipmentStatusService;
import com.dp.intelligentplant.util.PageVO;
import com.dp.intelligentplant.util.ResultInfo;
import com.dp.intelligentplant.vo.EquipmentStatusVO;
import com.dp.intelligentplant.vo.EquipmentVO;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {
	
	@Autowired
	private EquipmentStatusService equipmentStatusService;
	
	@Autowired
	private EquipmentService equipmentService;
	
	@RequestMapping("/chart/current")
	@ResponseBody
	public Object chartCurrent (HttpServletRequest request, Model model) {
		JSONObject jsonObject = new JSONObject();
		
		List<EquipmentStatus> list1 = equipmentStatusService.findByEquipmentId(8L, "current_value");
		List<EquipmentStatus> list2 = equipmentStatusService.findByEquipmentId(9L, "current_value");
		int len1 = list1.size();
		int len2 = list2.size();
		
		JSONObject[] arr1 = new JSONObject[len1];
		for (int i = 0; i < list1.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("time", list1.get(i).getRecordTime());
			obj.put("val", list1.get(i).getValue());
			arr1[i] = obj;
		}
		JSONObject[] arr2 = new JSONObject[len2];
		for (int i = 0; i < list2.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("time", list2.get(i).getRecordTime());
			obj.put("val", list2.get(i).getValue());
			arr2[i] = obj;
		}
		
		jsonObject.put("data1", arr1);
		jsonObject.put("data2", arr2);
		
		//设备名称
		Equipment e1 = equipmentService.findEquipmentById(8L);
		Equipment e2 = equipmentService.findEquipmentById(9L);
		jsonObject.put("name1", e1.getEname());
		jsonObject.put("name2", e2.getEname());
		
		return jsonObject;
	}
	
	@RequestMapping("/chart/temperature")
	@ResponseBody
	public Object chartTemperature (HttpServletRequest request, Model model) {
		JSONObject jsonObject = new JSONObject();
		
		List<EquipmentStatus> list1 = equipmentStatusService.findByEquipmentId(8L, "temperature");
		List<EquipmentStatus> list2 = equipmentStatusService.findByEquipmentId(9L, "temperature");
		int len1 = list1.size();
		int len2 = list2.size();
		
		JSONObject[] arr1 = new JSONObject[len1];
		for (int i = 0; i < list1.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("time", list1.get(i).getRecordTime());
			obj.put("val", list1.get(i).getValue());
			arr1[i] = obj;
		}
		JSONObject[] arr2 = new JSONObject[len2];
		for (int i = 0; i < list2.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("time", list2.get(i).getRecordTime());
			obj.put("val", list2.get(i).getValue());
			arr2[i] = obj;
		}
		
		jsonObject.put("data1", arr1);
		jsonObject.put("data2", arr2);
		
		//设备名称
		Equipment e1 = equipmentService.findEquipmentById(8L);
		Equipment e2 = equipmentService.findEquipmentById(9L);
		jsonObject.put("name1", e1.getEname());
		jsonObject.put("name2", e2.getEname());
		
		return jsonObject;
	}
	
	@RequestMapping("/page")
	@ResponseBody
	public Object page(PageVO<EquipmentStatus> pageVO, EquipmentStatusVO equipmentStatusVO) {
		Page<EquipmentStatus> page = equipmentStatusService.findByPageAndParams(pageVO, equipmentStatusVO);
		pageVO.setItemsCount(page.getTotalElements());
		pageVO.setData(page.getContent());
		return pageVO;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public Object list(EquipmentVO equipmentVO) {
		Iterable<Equipment> data = equipmentService.listEquipment(equipmentVO);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", data);
		return jsonObject;
	}
	
	
	@RequestMapping("/type/list")
	@ResponseBody
	public Object typelist(){
		Iterable<EquipmentType> data = equipmentService.listEquipmenttype();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", data);
		return jsonObject;
	}
	
	@RequestMapping("/brand/list")
	@ResponseBody
	public Object brandlist(){
		Iterable<EquipmentBrand> data = equipmentService.listEquipmentbrand();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", data);
		return jsonObject;
	}
	
	@RequestMapping("/region/list")
	@ResponseBody
	public Object regionlist(){
		Iterable<EquipmentRegion> data = equipmentService.listEquipmentregion();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", data);
		return jsonObject;
	}
	
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Object delete(@PathVariable("id") Long id) {
		ResultInfo resultInfo = new ResultInfo();
		equipmentService.deleteEquipment(id);
		return resultInfo;
	}
	
	@RequestMapping("/type/delete/{id}")
	@ResponseBody
	public Object deleteEquipmentType(@PathVariable("id") Long id) {
		ResultInfo resultInfo = new ResultInfo();
		equipmentService.deleteEquipmentType(id);
		return resultInfo;
	}
	
	@RequestMapping("/brand/delete/{id}")
	@ResponseBody
	public Object deleteEquipmentBrand(@PathVariable("id") Long id) {
		ResultInfo resultInfo = new ResultInfo();
		equipmentService.deleteEquipmentBrand(id);
		return resultInfo;
	}
	
	@RequestMapping("/region/delete/{id}")
	@ResponseBody
	public Object deleteEquipmentRegion(@PathVariable("id") Long id) {
		ResultInfo resultInfo = new ResultInfo();
		equipmentService.deleteEquipmentRegion(id);
		return resultInfo;
	}
	
	@RequestMapping("/fbox/devices/select")
	@ResponseBody
	public Object deviceSelect() {
		List<Equipment> list = equipmentService.listFBoxEquipment();
		
		JSONArray jsonArray = new JSONArray();
		for (Equipment e : list) {
			JSONObject json = new JSONObject();
			json.put("label", e.getEname());
			json.put("value", e.getEno());
			jsonArray.add(json);
		}
		
		return jsonArray;
	}
	
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(HttpServletRequest request, Equipment equipment) {
		String equipmentbrandId = request.getParameter("equipmentbrand");
		if (!StringUtils.isEmpty(equipmentbrandId)) {
			EquipmentBrand equipmentBrand = equipmentService.findEquipmentBrandById(Long.parseLong(equipmentbrandId));
			equipment.setBrand(equipmentBrand);
			equipmentService.saveOrUpdateEquipment(equipment);
		}
		return "redirect: ../pages/equipview.html";
	}
	
	@RequestMapping("/type/saveOrUpdate")
	public String saveOrUpdateType(HttpServletRequest request, EquipmentType equipmentType) {
		equipmentService.saveOrUpdateEquipmentType(equipmentType);
		return "redirect: ../../pages/equiptypemanagement.html";
	}
	
	@RequestMapping("/brand/saveOrUpdate")
	public String saveOrUpdateBrand(HttpServletRequest request, EquipmentBrand equipmentBrand) {
		String equipmenttypeId = request.getParameter("equipmenttypeId");
		if (!StringUtils.isEmpty(equipmenttypeId)) {
			EquipmentType equipmentType = equipmentService.findEquipmentTypeById(Long.parseLong(equipmenttypeId));
			equipmentBrand.setType(equipmentType);
			equipmentService.saveOrUpdateEquipmentBrand(equipmentBrand);
		}
		return "redirect: ../../pages/equipbrandmanagement.html";
	}
	
	@RequestMapping("/region/saveOrUpdate")
	public String saveOrUpdateRegion(HttpServletRequest request, EquipmentRegion equipmentRegion) {
		equipmentService.saveOrUpdateEquipmentRegion(equipmentRegion);
		return "redirect: ../../pages/equipregionmanagement.html";
	}
	
	@RequestMapping("/findOne/{id}")
	@ResponseBody
	public Object findOne(@PathVariable("id") Long id) {
		Equipment equipment = equipmentService.findEquipmentById(id);
		return equipment;
	}
	
	/*private void fillEntity(HttpServletRequest request, Equipment equipment) throws Exception {
		Enumeration<String> parameterNames = request.getParameterNames();
		Pattern pattern = Pattern.compile("\\[|\\]");
		Class clazz = equipment.getClass();
		
		while (parameterNames.hasMoreElements()) {
			
			String paramName = parameterNames.nextElement();
			if (paramName.contains("data")) {
				Matcher matcher = pattern.matcher(paramName);
				int num = 0;
				while (matcher.find()) {
					num++;
					if (num == 3) {
						break;
					}
				}
				int beginIndex = matcher.start();
				matcher.find();
				int endIndex = matcher.start();
				String fieldName = paramName.substring(beginIndex+1, endIndex);
				String fieldValue = request.getParameter(paramName);
				
				try {
					clazz.getDeclaredField(fieldName);
				} catch (Exception e) {
					continue;
				}
				String setMethod = "set" + StringUtils.toUpperCaseFirst(fieldName);
				Method m = clazz.getDeclaredMethod(setMethod, String.class);
				m.invoke(equipment, fieldValue);
			}
		}
	}*/
	
}
