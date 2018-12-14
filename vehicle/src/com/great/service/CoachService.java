package com.great.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.great.bean.Coach;
import com.great.dao.CoachMapper;
@Service
public class CoachService {
	@Resource
	private CoachMapper coachMapper;
	public Coach login(Map<String,Object> map) throws Exception{
		return coachMapper.login(map);
	}
	//查询通知公告表，并展示数据
	 public List<Map<String,Object>> queryAll() throws Exception{
	   return coachMapper.queryAll();
	    }
}
