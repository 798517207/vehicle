package com.great.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.great.bean.Dynamic;
import com.great.dao.CarMapper;
import com.great.dao.DynamicMapper;

@Service
public class DynamicService {
	@Resource
	private DynamicMapper dynamicMapper;
	//增加教练车表
    public boolean add(Dynamic dynamic) throws Exception{
		return dynamicMapper.add(dynamic)>0;
		}
  //查询教练车表，并展示数据
    public List<Map<String,Object>> queryAll() throws Exception{
    	 return dynamicMapper.queryAll();
		}
}
