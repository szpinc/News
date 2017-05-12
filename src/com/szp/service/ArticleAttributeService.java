package com.szp.service;

import java.util.List;

import com.szp.entity.ArticleAttribute;

public class ArticleAttributeService extends BaseService implements Service<ArticleAttribute> {

	private String sql;
	
	@Override
	public void add(ArticleAttribute t) {
		sql = "INSERT INTO tb_article_attribute(name,path) VALUES(?,?)";
		dao.update(sql, t.getName(),t.getPath());
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArticleAttribute t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArticleAttribute getById(int id) {
		
		return null;
	}

	public ArticleAttribute getByName(String name) {
		return dao.queryBean("SELECT * FROM tb_article_attribute WHERE name=?",ArticleAttribute.class,name);
	}

	@Override
	public List<ArticleAttribute> getAll() {
		return queryAll("tb_article_attribute", ArticleAttribute.class);
	}

}
