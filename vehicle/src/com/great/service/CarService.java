package com.great.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.great.bean.Car;
import com.great.dao.CarMapper;

@Service
public class CarService {
	@Resource
	private CarMapper carMapper;
	//增加教练车表
    public boolean add(Car car) throws Exception{
		return carMapper.add(car)>0;
		}
    //修改教练车表内信息
    public boolean update(int carId,String carNum,int schoolId,int coachId) throws Exception{
	     Car car=new Car();
	     car.setCarId(carId);
	     car.setCarNum(carNum);
	     car.setSchoolId(schoolId);
	     car.setCoachId(coachId);
    	return carMapper.update(car)>0;
		}
    //假删除教练车表
    public boolean delete(int carId,int carState) throws Exception{
    	 Car car=new Car();
    	 car.setCarId(carId);
    	 car.setCarState(carState);
    	return carMapper.delete(car)>0;
		}
    //查询教练车表，并展示数据
    public List<Map<String,Object>> queryAll() throws Exception{
    	 return carMapper.queryAll();
		}
  //查询随便1条数据，并展示。
	 public Map<String,Object> queryOne (int carId)throws Exception{
	    	 return carMapper.queryOne(carId);
	    }
    //根据条件查询数据，并展示。
    public List<Map<String,Object>> query ()throws Exception{
    	 return carMapper.query();
		}
    
   
    
}

