package com.great.handler.back;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.great.bean.School;
import com.great.service.SchoolService;
import com.great.util.Result;

@Controller
@RequestMapping("/front/school")
public class SchoolHandler {
	@Resource
	private SchoolService schoolService;

	@RequestMapping(value = "/addSchool.handler")
	public @ResponseBody Result addSchool(
			@RequestBody School school) throws Exception {
		boolean flag = false;
		flag = schoolService.addSchool(school);
		if (flag == true) {
			return Result.success(null);
		} else {
			return Result.fail(null);
		}
	}
	
	@RequestMapping(value = "/queryAllSchool.handler")
	public ModelAndView queryAll(ModelAndView mav,HttpSession session) throws Exception {
		List<Map<String,Object>> map = schoolService.queryAll();
		mav.getModel().put("map", map);
		mav.setViewName("/front/school_list");
		return mav;
		
	}

}
