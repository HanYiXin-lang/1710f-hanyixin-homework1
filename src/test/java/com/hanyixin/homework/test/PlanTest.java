package com.hanyixin.homework.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hanyixin.common.utils.FileUtil;
import com.hanyixin.senior1.homework.entity.Plan;
import com.hanyixin.senior1.homework.service.PlanService;

public class PlanTest {
	
	@Test
	public void test() {
		ApplicationContext as = new ClassPathXmlApplicationContext("spring-beans.xml");
		PlanService bean = as.getBean(PlanService.class);
		//读取文件
		List<String> list = FileUtil.readTextFileToList("D:\\Java\\hanyixin-senior1-homework1\\src\\test\\resources//data.txt");
		for(String string : list) {
			//||为转移字符 拆分需要加上//
			String[] split = string.split("\\|\\|");
			Plan p = new Plan();
			p.setName(split[0]);
			p.setAmount(split[1]);
			p.setManager(split[2]);
			p.setContent(split[3]);
			if(split[4].equals("炸药厂")) {
				p.setDept_id(1);
			}else if(split[4].equals("生产服务中心")) {
				p.setDept_id(2);
			}else if(split[4].equals("准能选煤厂")) {
				p.setDept_id(3);
			}else if(split[4].equals("洗选车间")) {
				p.setDept_id(4);
			}else if(split[4].equals("生产服务中心")) {
				p.setDept_id(5);
			}else if(split[4].equals("矸电公司")) {
				p.setDept_id(6);
			}else if(split[4].equals("大准铁路公司")) {
				p.setDept_id(7);
			}
			bean.insert(p);
		}
		
	}
}
