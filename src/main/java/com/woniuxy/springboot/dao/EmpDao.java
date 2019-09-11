package com.woniuxy.springboot.dao;

import java.util.List;

import com.woniuxy.springboot.po.Emp;

public interface EmpDao {
	List<Emp> findAllEmps();
}
