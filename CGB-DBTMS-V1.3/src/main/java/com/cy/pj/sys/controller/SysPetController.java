package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysPet;
import com.cy.pj.sys.service.SysPetService;


@Controller
@RequestMapping("/pet/")
public class SysPetController {
	@Autowired
	private SysPetService sysPetService;
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String name,Integer pageCurrent) {
		PageObject<SysPet> pageObject = sysPetService.findPageObjects(name, pageCurrent);
		return new JsonResult(pageObject);
	}

	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysPet entity) {
		sysPetService.SaveObject(entity);
		return new JsonResult("save ok");
	}
	@RequestMapping("doPetEditUI")
	public String doPetEditUI() {
		return "sys/pet_edit";
	} 
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
		SysPet sysPet =sysPetService.findObjectById(id);
		return new JsonResult(sysPet) ;
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysPet sysPet) {
		sysPetService.updateObject(sysPet);
		return new JsonResult("update ok");
	}
}
