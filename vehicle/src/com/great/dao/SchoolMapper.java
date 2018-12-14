package com.great.dao;

import java.util.List;
import java.util.Map;

import com.great.bean.School;

public interface SchoolMapper {
	//驾校申请
	public boolean addSchool(School school)throws Exception;
	public School login(Map<String, Object> map) throws Exception;
	
	//查询驾校表，并展示数据
    public List<Map<String,Object>> queryAll() throws Exception;
}