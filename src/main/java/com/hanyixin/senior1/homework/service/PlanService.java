package com.hanyixin.senior1.homework.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hanyixin.senior1.homework.entity.Plan;

public interface PlanService {

	PageInfo<Plan> select(Plan plan, Integer page, Integer pageSize);

	boolean insert(Plan plan);

	Plan selectById(Integer id);

	List<Plan> selectDept();

	boolean update(Plan plan);

	int del(String ids);
}
