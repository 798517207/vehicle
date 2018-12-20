package com.great.handler.front;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.great.bean.Notice;
import com.great.bean.User;
import com.great.service.NoticeService;
/**前台通知公告控制器
 * @author 
 *
 */
import com.great.util.Result;
@Controller
@RequestMapping("/front/notice")
public class NoticeHandler {
	@Resource
	private NoticeService noticeService;
	
	@RequestMapping(value = "/addNotice.handler")
	public @ResponseBody Result add(
			@RequestParam(value="noticeTitle",required=true) String noticeTitle,
			@RequestParam(value="noticeContent",required=true) String noticeContent,
			HttpSession session
			) throws Exception {
		Notice notice=new Notice();
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		boolean flag=false;
		flag = noticeService.add(notice);
		if(flag==true){
			return Result.success("增加成功");
		}else{
		return Result.fail("增加失败");
		}
		
	}
	   //删除教练车
			@RequestMapping(value = "/deleteNotice.handler")
			public @ResponseBody Result delete(
					@RequestParam(value = "noticeId",required=true) BigDecimal noticeId,
					@RequestParam(value = "noticeState",required=true) BigDecimal noticeState,
					HttpSession session
					) throws Exception {
				boolean flag=false;
				flag=noticeService.delete(noticeId,noticeState);
				if(flag==true){
					return Result.success("删除成功");
				}else{
				return Result.fail("删除失败");
				}
				
			}
			
			 //修改教练车
			@RequestMapping(value = "/updateNotice.handler")
			public @ResponseBody Result update(
					@RequestParam(value = "noticeId",required=true) BigDecimal noticeId,
					@RequestParam(value="noticeTitle",required=true) String noticeTitle,
					@RequestParam(value="noticeContent",required=true) String noticeContent,
					HttpSession session
					) throws Exception {
				boolean flag=false;
				flag=noticeService.update(noticeId,noticeTitle,noticeContent);
				if(flag==true){
					return Result.success("删除成功");
				}else{
				return Result.fail("删除失败");
				}
				
			}
	
	@RequestMapping(value = "/queryAllNotice.handler")
	public ModelAndView queryAll(ModelAndView mav,HttpSession session) throws Exception {
		List<Map<String,Object>> map = noticeService.queryAll();
		mav.getModel().put("map", map);
	
		mav.setViewName("/front/notice_list");
		return mav;
		
	}
     //查询单条的信息发回来
	@RequestMapping(value = "/queryOneNotice.handler")
	public ModelAndView queryOnce(ModelAndView mav,
			@RequestParam(value = "noticeId",required=true) BigDecimal noticeId,
			HttpSession session) throws Exception {
		Map<String,Object> map = noticeService.queryOne(noticeId);
		mav.getModel().put("map", map);
	
		mav.setViewName("/front/notice_update");
		return mav;
		
	} 
	
}
