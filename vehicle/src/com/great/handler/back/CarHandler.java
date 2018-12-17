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

import com.great.bean.Car;
import com.great.bean.School;
import com.great.bean.User;
import com.great.service.CarService;
import com.great.service.CoachService;
import com.great.service.SchoolService;
import com.great.util.Result;

@Controller("backCarHandler")
@RequestMapping("/back/car")
public class CarHandler {
	//教练车的service
	@Resource
	private CarService carService;
	//驾校的service
	@Resource
	private SchoolService schoolService;
	//教练的service
	@Resource
	private CoachService coachService;
	
	//增加教练车
	@RequestMapping(value = "/addCar.handler")
	public @ResponseBody Result add(@RequestBody Car car) throws Exception {
		boolean flag=false;
		flag = carService.add(car);
		if(flag==true){
			return Result.success("增加成功");
		}else{
		return Result.fail("增加失败");
		}
		
	}
	//删除教练车
		@RequestMapping(value = "/deleteCar.handler")
		public @ResponseBody Result delete(
				@RequestParam(value = "carId",required=true) int carId,
				HttpSession session
				) throws Exception {
			boolean flag=false;
			flag=carService.delete(carId);
			if(flag==true){
				return Result.success("删除成功");
			}else{
			return Result.fail("删除失败");
			}
			
		}
		//修改教练车
		@RequestMapping(value = "/updateCar.handler")
		public ModelAndView  update(ModelAndView mav,
				@RequestParam(value = "carId",required=true) int carId,
				HttpSession session
				) throws Exception {
			boolean flag=false;
			flag=carService.update(carId);
			List<Map<String,Object>> map = carService.queryAll();
			mav.getModel().put("map", map);
			mav.setViewName("/back/car_add");
			return mav;
			
		}
	//获取教练表和驾校表的数据。
	@RequestMapping(value = "/queryall.handler")
	public ModelAndView queryadd(ModelAndView mav,HttpSession session) throws Exception {
		//获取驾校表的信息
		List<Map<String,Object>> map1 = schoolService.queryAll();
		mav.getModel().put("map1", map1);
		//获取教练表
		List<Map<String,Object>> map2 = coachService.queryAll();
		mav.getModel().put("map2", map2);
		mav.setViewName("/back/car_add");
		return mav;
		
	}

	@RequestMapping(value = "/queryCar.handler")
	public ModelAndView queryCar(ModelAndView mav,HttpSession session) throws Exception {
		//获取教练车表的信息
		List<Map<String,Object>> map = carService.queryAll();
		mav.getModel().put("map", map);
		
		mav.setViewName("/back/car_list");
		return mav;
		
	}
	
}
