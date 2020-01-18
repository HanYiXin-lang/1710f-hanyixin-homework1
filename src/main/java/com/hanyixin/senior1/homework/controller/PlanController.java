package com.hanyixin.senior1.homework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hanyixin.senior1.homework.entity.Department;
import com.hanyixin.senior1.homework.entity.Plan;
import com.hanyixin.senior1.homework.service.PlanService;

@Controller
public class PlanController {

	@Autowired
	private PlanService planService;
	
	@RequestMapping("select")
	public String selects(Model model,Plan plan,@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "5") Integer pageSize){
		PageInfo<Plan> info = planService.select(plan,page,pageSize);
		model.addAttribute("info",info);
		model.addAttribute("plan",plan);
		return "list";
	}
	
	//根据id查询
	@GetMapping("selectById")
	private String selectById(@RequestParam("id") Integer id,Model model) {
		Plan plan = planService.selectById(id);
		model.addAttribute("plan", plan);
		return "selectById";
	}
	
	@GetMapping("toUpdate")
	public String update(Model model,Integer id) {
		Plan plan = planService.selectById(id);
		List<Plan> dept = planService.selectDept();
		model.addAttribute("plan", plan);
		model.addAttribute("dept", dept);
		return "update";
	}
	
	@PostMapping("update")
	public String update(Model model,Plan plan) {
		planService.update(plan);
		model.addAttribute("plan", plan);
		return "redirect:select";
	}
	
	//ajax批量删除
	@ResponseBody
	@RequestMapping("del")
	public int del(@RequestParam("ids") String ids) {
		int i = planService.del(ids);
		return i;
	}
}


