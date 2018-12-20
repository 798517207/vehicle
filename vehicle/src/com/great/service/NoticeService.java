package com.great.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.great.bean.Notice;
import com.great.dao.NoticeMapper;

@Service
public class NoticeService {
	@Resource
	private NoticeMapper noticeMapper;
	//增加通知公告表
	public boolean add(Notice notice) throws Exception{
		return noticeMapper.add(notice)>0;
		}
	 //修改通知公告表内信息
	public boolean update(BigDecimal noticeId,String noticeTitle,String noticeContent) throws Exception{
		Notice notice=new Notice();
		notice.setNoticeId(noticeId);
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		
		return noticeMapper.update(notice)>0;
	    }
	 //假删除通知公告表
	 public boolean delete(BigDecimal noticeId,BigDecimal noticeState) throws Exception{
		 Notice notice=new Notice();
		 notice.setNoticeId(noticeId);
		 notice.setNoticeState(noticeState);
		 return noticeMapper.delete(notice)>0;
	    }
	//查询通知公告表，并展示数据
	 public List<Map<String,Object>> queryAll() throws Exception{
		 return noticeMapper.queryAll();
	    }
	//查询随便1条数据，并展示。
		 public Map<String,Object> queryOne (BigDecimal noticeId)throws Exception{
		    	 return noticeMapper.queryOne(noticeId);
		    }
	//查询随便5条数据，并展示。
	 public Map<String,Object> query ()throws Exception{
	    	 return noticeMapper.query();
	    }
}
