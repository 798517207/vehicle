package com.great.handler.front;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



import com.great.service.DynamicService;


@Controller("frontDynamicHandler")
@RequestMapping("/front/dynamic")
public class DynamicHandler {
	//行业动态的service
		@Resource
		private DynamicService dynamicService;
	//查询动态行业
		@RequestMapping(value = "/queryDynamic.handler")
		public ModelAndView queryDynamic(ModelAndView mav,HttpSession session) throws Exception {
			List<Map<String,Object>> map = dynamicService.queryAll();
			mav.getModel().put("map", map);
			
			mav.setViewName("/front/dynamic_list");
			return mav;
			
		}
}
