package com.great.dao;

import java.util.List;
import java.util.Map;

import com.great.bean.Car;
import com.great.bean.Evaluate;

public interface EvaluateMapper {
    int deleteByPrimaryKey(Integer evaluateId);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(Integer evaluateId);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);
   //增加评价表
    public int add(Evaluate evaluate) throws Exception;
    //查询教练车表，并展示数据
    public List<Map<String,Object>> queryAll() throws Exception;
}