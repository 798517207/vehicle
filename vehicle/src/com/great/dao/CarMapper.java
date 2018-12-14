package com.great.dao;

import java.util.List;
import java.util.Map;

import com.great.bean.Car;

//教练车表的增删改查
public interface CarMapper {
	//增加教练车表
  public int add(Car car) throws Exception;
  //修改教练车表内信息
  public int update(int carId) throws Exception;
  //假删除教练车表
  public int delete(int carId) throws Exception;
  //查询教练车表，并展示数据
  public List<Map<String,Object>> queryAll() throws Exception;
  //根据条件查询数据，并展示。
  public List<Map<String,Object>> query ()throws Exception;
  
}