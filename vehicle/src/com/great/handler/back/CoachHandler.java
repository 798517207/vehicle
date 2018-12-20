package com.great.handler.back;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.great.bean.Coach;
import com.great.bean.School;
import com.great.service.CoachService;
import com.great.util.Result;
/**后台coach控制器
 * @author 
 *
 */
@Controller
@RequestMapping("/back/coach")
public class CoachHandler {
	@Resource
	private CoachService coachService;
	@RequestMapping(value = "/coachList.handler")
	public String adminLogin(HttpServletRequest request) throws Exception {
		request.setAttribute("coachList",coachService.queryAll());
		return "forward:/WEB-INF/back/coach_list.jsp";
	}
	//查询所有教练
	@RequestMapping(value = "/queryAllCoach.handler")
	public ModelAndView queryAll(ModelAndView mav,HttpSession session) throws Exception {
		List<Map<String,Object>> mapCoach = coachService.queryAll();
		mav.getModel().put("mapCoach", mapCoach);
		mav.setViewName("/back/coach_list");
		return mav;
		
	}
	//查询驾校旗下所有教练
		@RequestMapping(value = "/queryBySchoolId.handler")
		public @ResponseBody Result queryBySchoolId(
				@RequestParam(value="schoolId",required=true) int schoolId,
				HttpServletRequest req) throws Exception {
			Coach coach=new Coach();
			coach.setSchoolId(schoolId);
			List<Map<String,Object>> mapCoach = coachService.queryBySchoolId(coach);
			req.setAttribute("mapCoach", mapCoach);
			return Result.success(mapCoach);
		}
	
		
}
