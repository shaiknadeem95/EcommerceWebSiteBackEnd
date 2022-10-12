package com.shopping.admin;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

	@GetMapping("")
	public String viewHomePage()
	{
		return "index";
	}
}
