package com.great.dao;

import com.great.bean.Notice;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
//通知公告增删改查
public interface NoticeMapper {
	//增加通知公告表
    public int add(Notice notice) throws Exception;
    //修改通知公告表内信息
    public int update(int noticeId) throws Exception;
    //假删除通知公告表
    public int delete(int noticeId) throws Exception;
    //查询通知公告表，并展示数据
    public List<Map<String,Object>> queryAll() throws Exception;
    //根据条件查询数据，并展示。
    public Map<String,Object> query ()throws Exception;
    
    
}