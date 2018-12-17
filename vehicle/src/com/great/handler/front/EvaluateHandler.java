package com.great.handler.front;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.great.bean.Evaluate;
import com.great.bean.Notice;
import com.great.service.EvaluateService;
import com.great.service.NoticeService;
import com.great.util.Result;

@Controller
@RequestMapping("/front/evaluate")
public class EvaluateHandler {
	@Resource
	private EvaluateService evaluateService;
	@RequestMapping(value = "/addEvaluate.handler")
	public @ResponseBody Result add(
			@RequestBody Evaluate evaluate,
			HttpSession session
			) throws Exception {
		boolean flag=false;
		flag = evaluateService.add(evaluate);
		if(flag==true){
			return Result.success("增加成功");
		}else{
		return Result.fail("增加失败");
		}
		
	}
	//查询
	@RequestMapping(value = "/queryAllEvaluate.handler")
	public ModelAndView queryAll(ModelAndView mav,HttpSession session) throws Exception {
		List<Map<String,Object>> map = evaluateService.queryAll();
		mav.getModel().put("map", map);
	
		mav.setViewName("/front/evaluate_list");
		return mav;
		}
}
