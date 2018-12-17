package com.great.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.great.bean.Evaluate;

import com.great.dao.EvaluateMapper;
@Service
public class EvaluateService {
	@Resource
	private EvaluateMapper evaluateMapper;
	 //增加评价表
    public boolean add( Evaluate evaluate) throws Exception{
    	return evaluateMapper.add(evaluate)>0;
    }
    //查询教练车表，并展示数据
    public List<Map<String,Object>> queryAll() throws Exception{
    	return evaluateMapper.queryAll();
    }

}
