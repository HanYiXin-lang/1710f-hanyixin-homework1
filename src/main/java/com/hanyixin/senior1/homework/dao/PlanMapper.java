package com.hanyixin.senior1.homework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hanyixin.senior1.homework.entity.Plan;

public interface PlanMapper {

	boolean insert(Plan plan);

	List<Plan> select(Plan plan);

	Plan selectById(Integer id);

	List<Plan> selectDept();

	boolean update(Plan plan);

	int del(@Param("ids")String ids);
}
