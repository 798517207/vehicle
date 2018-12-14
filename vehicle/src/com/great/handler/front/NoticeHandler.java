package com.great.handler.front;

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
			@RequestBody Notice notice,
			HttpSession session
			) throws Exception {
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
					@RequestParam(value = "noticeId",required=true) int noticeId,
					HttpSession session
					) throws Exception {
				boolean flag=false;
				flag=noticeService.delete(noticeId);
				if(flag==true){
					return Result.success("删除成功");
				}else{
				return Result.fail("删除失败");
				}
				
			}
			
			 //修改教练车
			@RequestMapping(value = "/updateNotice.handler")
			public @ResponseBody Result update(
					@RequestParam(value = "noticeId",required=true) int noticeId,
					HttpSession session
					) throws Exception {
				boolean flag=false;
				flag=noticeService.update(noticeId);
				if(flag==true){
					return Result.success("删除成功");
				}else{
				return Result.fail("删除失败");
				}
				
			}
	
	@RequestMapping(value = "/queryallNotice.handler")
	public ModelAndView queryall(ModelAndView mav,HttpSession session) throws Exception {
		List<Map<String,Object>> map = noticeService.queryall();
		mav.getModel().put("map", map);
		mav.setViewName("/front/notice_list");
		return mav;
		
	}
}
