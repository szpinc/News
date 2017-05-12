package com.szp.service;

import java.util.List;

import com.szp.entity.ArticleType;

public class ArticleTypeService extends BaseService {
	
	
	public void add (ArticleType articleType) {
		String sql = "INSERT INTO tb_article_type(type_name) VALUES(?)";
		dao.update(sql, articleType.getTypeName());
	}
	
	public void update (ArticleType articleType) {
		String sql = "UPDATE tb_article_type SET type_name=? WHERE id=?";
		dao.update(sql, articleType.getTypeName(),articleType.getId());
	}
	
	public ArticleType getById (int id) {
		return dao.queryBean("SELECT * FROM tb_article_type WHERE id=?", ArticleType.class, id);
	}
	
	public List<ArticleType> getAll () {
		return queryAll("tb_article_type", ArticleType.class);
	}

}
