package com.great.dao;


import java.util.List;
import java.util.Map;

import com.great.bean.Dynamic;

public interface DynamicMapper {
    
  //增加行业动态表
    public int add(Dynamic dynamic) throws Exception;
  //查询教练车表，并展示数据
    public List<Map<String,Object>> queryAll() throws Exception;
}