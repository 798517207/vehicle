package com.great.handler.back;

import java.math.BigDecimal;
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
	public @ResponseBody Result add(
			@RequestParam(value="carNum",required=true) String carNum,
			@RequestParam(value="schoolId",required=true) int schoolId,
			@RequestParam(value="coachId",required=true) int coachId,
			HttpSession session
			) throws Exception {
		Car car=new Car();
		car.setCarNum(carNum);
		car.setSchoolId(schoolId);
		car.setCoachId(coachId);
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
			flag=carService.delete(carId,99);
			if(flag==true){
				return Result.success("删除成功");
			}else{
			return Result.fail("删除失败");
			}
			
		}
		//修改教练车
		@RequestMapping(value = "/updateCar.handler")
		public @ResponseBody Result  update(ModelAndView mav,
				@RequestParam(value = "carId",required=true) int carId,
				@RequestParam(value = "carNum",required=true) String carNum,
				@RequestParam(value = "schoolId",required=true) int schoolId,
				@RequestParam(value = "coachId",required=true) int coachId,
				HttpSession session
				) throws Exception {
			boolean flag=false;
			flag=carService.update(carId,carNum,schoolId,coachId);
			if(flag==true){
				return Result.success("修改成功");
			}else{
			return Result.fail("修改失败");
			}
			
			
		}


	@RequestMapping(value = "/queryCar.handler")
	public ModelAndView queryCar(ModelAndView mav,HttpSession session) throws Exception {
		//获取教练车表的信息
		List<Map<String,Object>> map = carService.queryAll();
		mav.getModel().put("map", map);
		
		mav.setViewName("/back/car_list");
		return mav;
		
	}
	//查询单条的信息发回来
	@RequestMapping(value = "/queryOneCar.handler")
	public ModelAndView queryOnce(ModelAndView mav,
			@RequestParam(value = "carId",required=true) int carId,
			HttpSession session) throws Exception {
		Map<String,Object> map = carService.queryOne(carId);
		mav.getModel().put("map", map);
		List<Map<String,Object>> schoolList =schoolService.queryAll();
		mav.getModel().put("schoolList", schoolList);
		mav.setViewName("/back/car_update");
		return mav;
		
	} 
	
	//获取驾校列表，并进行界面跳转
	@RequestMapping(value="/addModelCar.handler")
	public ModelAndView addModelCar(ModelAndView mav,
			HttpSession session) throws Exception{
		List<Map<String,Object>> schoolList =schoolService.queryAll();
		mav.getModel().put("schoolList", schoolList);
		mav.setViewName("/back/car_add");
		return mav;
		
	}
	
	
}
