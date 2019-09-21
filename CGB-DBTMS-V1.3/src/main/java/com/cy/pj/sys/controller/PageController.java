package com.cy.pj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 在此controller中
 */
@Controller
@RequestMapping("/")
public class PageController {

	/*
	 * @RequestMapping("log/doLogUI") public String doLogUI() { return
	 * "sys/log_list"; }
	 */
	/*
	 * @RequestMapping("doMenuListUI") public String doMenuListUI(){ return
	 * "sys/menu_list"; }
	 */

	/**返回首页页面 */
	@RequestMapping("doIndexUI") 
	public String doIndexUI() { 
		return "starter"; 
	}
	/**分页div页面 */
	@RequestMapping("doPageUI") 
	public String doPageUI(){ 
		return "common/page"; 
	}

	@RequestMapping("{module}/{page}")
	public String doModuleUI(@PathVariable String page) {
		return "sys/" + page;
	}
	@RequestMapping("doLoginUI")
	public String doLoginUI(){
		return "login";
	}
	
	}
