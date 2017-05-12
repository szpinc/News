package com.szp.service;

import java.util.List;

import com.szp.dao.BaseDao;
import com.szp.util.JdbcUtil;

public class BaseService {
	protected BaseDao dao = new BaseDao(JdbcUtil.getQueryRunner());
	
	protected <T> List<T> queryAll (String tableName, Class<T> bean) {
		return dao.query("SELECT * FROM " + tableName, bean);
	}
}
