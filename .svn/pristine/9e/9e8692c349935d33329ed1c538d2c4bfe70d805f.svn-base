package com.dp.intelligentplant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dp.intelligentplant.fbox.AlarmVO;
import com.dp.intelligentplant.service.api.AlarmService;

@Controller
@RequestMapping("/alarm")
public class AlarmController {
	
	@Autowired
	private AlarmService alarmService;
	
	@RequestMapping("/current")
	@ResponseBody
	public Object listCurrentAlarm (HttpServletRequest request, Model model) {
		List<AlarmVO> alarms = alarmService.listAlarm();
		return alarms;
	}
	
}
