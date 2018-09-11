package com.hehe.integration.user;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hehe.integration.common.R;

@RestController
@RequestMapping("/user/*")
public class UserController
{

	@Autowired
	UserService userService;

	@GetMapping("list")
	public R list()
	{
		try
		{
			return R.isOk().data(userService.list());
		}
		catch (Exception e)
		{
			return R.isFail(e);
		}

	}

	@GetMapping("useradd")
	public void useradd(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletResponse httpServletResponse) throws IOException
	{
		User user = new User();
		user.setUserId(UUID.randomUUID().toString());
		user.setUsername(username);
		user.setPassword(password);
		userService.addUser(user);
		httpServletResponse.sendRedirect("/springdemo/user/list");
	}

}