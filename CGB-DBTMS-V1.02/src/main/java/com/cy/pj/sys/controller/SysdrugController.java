package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.service.SysDrugService;

@Controller
@RequestMapping("/drug/")
public class SysdrugController {
	@Autowired
	private SysDrugService sysDrugService;
	
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects() {
		return new JsonResult(sysDrugService.findObjects());
	}
	
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer...ids) {
		sysDrugService.deleteObjects(ids);
		return new JsonResult("delete ok");
	}
}
