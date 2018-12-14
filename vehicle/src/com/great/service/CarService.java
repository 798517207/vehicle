package com.great.service;

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
    public boolean update(int carId) throws Exception{
		return carMapper.update(carId)>0;
		}
    //假删除教练车表
    public boolean delete(int carId) throws Exception{
		return carMapper.delete(carId)>0;
		}
    //查询教练车表，并展示数据
    public List<Map<String,Object>> queryAll() throws Exception{
    	 return carMapper.queryAll();
		}
    //根据条件查询数据，并展示。
    public List<Map<String,Object>> query ()throws Exception{
    	 return carMapper.query();
		}
}

