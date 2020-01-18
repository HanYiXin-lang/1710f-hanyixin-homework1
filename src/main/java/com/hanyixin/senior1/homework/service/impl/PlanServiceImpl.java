package com.hanyixin.senior1.homework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hanyixin.senior1.homework.dao.PlanMapper;
import com.hanyixin.senior1.homework.entity.Plan;
import com.hanyixin.senior1.homework.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanMapper planMapper;

	@Override
	public PageInfo<Plan> select(Plan plan, Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<Plan> list = planMapper.select(plan);
		return new PageInfo<Plan>(list);
	}

	@Override
	public boolean insert(Plan plan) {
		return planMapper.insert(plan);
	}

	@Override
	public Plan selectById(Integer id) {
		return planMapper.selectById(id);
	}

	@Override
	public List<Plan> selectDept() {
		return planMapper.selectDept();
	}

	@Override
	public boolean update(Plan plan) {
		return planMapper.update(plan);
	}

	@Override
	public int del(String ids) {
		return planMapper.del(ids);
	}

}
