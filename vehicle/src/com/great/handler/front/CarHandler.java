package com.great.handler.front;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.great.service.CarService;
import com.great.service.CoachService;

@Controller("frontCarHandler")
@RequestMapping("/front/car")
public class CarHandler {
	   //教练车的service
		@Resource
		private CarService carService;
		
		@RequestMapping(value = "/queryCar.handler")
		public ModelAndView queryCar(ModelAndView mav,HttpSession session) throws Exception {
			//获取教练车表的信息
			List<Map<String,Object>> map = carService.queryAll();
			mav.getModel().put("map", map);
			
			mav.setViewName("/front/car_list");
			return mav;
			
		}
}