package com.great.handler.back;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.great.bean.Dynamic;

import com.great.service.DynamicService;
import com.great.util.Result;

@Controller("backDynamicHandler")
@RequestMapping("/back/dynamic")
public class DynamicHandler {
	//行业动态的service
		@Resource
		private DynamicService dynamicService;
	//增加行业动态表
		@RequestMapping(value = "/addDynamic.handler")
		public @ResponseBody Result add(
				@RequestParam(value="dynamicTitle",required=true) String dynamicTitle,
				@RequestParam(value="dynamicContent",required=true) String dynamicContent,
				HttpSession session) throws Exception {
			Dynamic dynamic = new Dynamic();
			dynamic.setDynamicTitle(dynamicTitle);
			dynamic.setDynamicContent(dynamicContent);
			boolean flag=false;
			flag = dynamicService.add(dynamic);
			if(flag==true){
				return Result.success("增加成功");
			}else{
			return Result.fail("增加失败");
			}
			
		}
}
