package com.hehe.integration.hello;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hehe.integration.user.UserService;

@Controller
public class HelloController
{
	@Autowired
	UserService userService;

	@GetMapping("/")
	public String index()
	{
		return "redirect:/user/list";
	}

	@GetMapping("index3")
	public String testHtml(HashMap<String, Object> map)
	{	
		map.put("hello", "欢迎进入HTML页面");
		map.put("userList", userService.list());
		return "index3";//地址指向index3.html
	}
	@GetMapping("index4")
	public String testHtml4(HashMap<String, Object> map)
	{	
		System.out.println("sss");
		map.put("hello", "欢迎进入HTML OUTER页面");
		return "index4";//地址指向index3.html
	}
	@GetMapping("/test")
	public String index2(HttpServletRequest httpServletRequest)
	{
		System.out.println(httpServletRequest.getSession().getId());
		return "redirect:/user/list";
	}
}
