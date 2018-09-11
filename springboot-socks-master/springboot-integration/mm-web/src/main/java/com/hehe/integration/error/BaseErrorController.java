package com.hehe.integration.error;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("error")
public class BaseErrorController implements ErrorController
{

	@Override
	public String getErrorPath()
	{
		return "error";
	}

	@RequestMapping
	public String error()
	{
		return getErrorPath();
	}
}
