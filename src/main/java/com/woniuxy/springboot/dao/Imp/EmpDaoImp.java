package com.woniuxy.springboot.dao.Imp;

import java.util.List;


import com.woniuxy.springboot.dao.EmpDao;
import com.woniuxy.springboot.po.Emp;

public class EmpDaoImp implements EmpDao {

	@Override
	public List<Emp> findAllEmps() {
		String sql="SELECT * FROM  emp,dep  WHERE dep.did=emp.did";
		
		return null;
	}

}
