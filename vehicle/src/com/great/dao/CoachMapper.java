package com.great.dao;

import java.util.List;
import java.util.Map;

import com.great.bean.Coach;
import com.great.bean.School;
//教练表的增。删。改。查。登录
public interface CoachMapper {
	//登录
	public Coach login(Map<String,Object> map) throws Exception;
    //查询通知公告表，并展示数据
    public List<Map<String,Object>> queryAll() throws Exception;
    //根据驾校ID查询挂名在该驾校下的教练
    public List<Map<String,Object>> queryBySchoolId(Coach coach) throws Exception;
    
}