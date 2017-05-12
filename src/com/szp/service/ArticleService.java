package com.szp.service;

import java.util.List;
import com.szp.entity.Article;
import org.junit.Test;

public class ArticleService extends BaseService {
	
	public void add (Article article) {
		String sql = "INSERT INTO tb_article(title,classify,attribute,attributeUrl,content,time,previewPic) VALUES(?,?,?,?,?,NOW(),?)";
		dao.update(sql,article.getTitle(),article.getClassify(),article.getAttribute(),article.getAttributeUrl(),article.getContent(),article.getPreviewPic());
	}
	
	public void update (Article article) {
		String sql = "UPDATE tb_article SET title=?,classify=?,attribute=?,attributeUrl=?,content=?,previewPic=?) WHERE id=?";
		dao.update(sql,article.getTitle(),article.getClassify(),article.getAttribute(),article.getAttributeUrl(),article.getContent(),article.getPreviewPic(),article.getId());
	}
	
	public Article getById (int id) {
		return dao.queryBean("SELECT * FROM tb_article WHERE id=?", Article.class, id);
	}

	/**
	 * 按照文章创建时间顺序（倒序）查询
	 * @return
	 */
	public List<Article> getAllDesc () {
		String sql = "SELECT * FROM (SELECT * FROM tb_article ORDER BY time DESC) temp ORDER BY time DESC";
		return dao.query(sql, Article.class);
	}

	/**
	 * 按照文章创建时间顺序（倒序）查询,限制数量
	 * @return
	 */
	public List<Article> getByDesc (int index,int count) {
		String sql = "SELECT * FROM (SELECT * FROM tb_article ORDER BY time DESC) temp ORDER BY time DESC LIMIT ?,?";
		return dao.query(sql, Article.class,index,count);
	}

	public int getArticleCount () {
		String sql = "SELECT id FROM tb_article";
		return dao.query(sql,Article.class).size();
	}
	
	public List<Article> getAll () {
		return queryAll("tb_article", Article.class);
	}

	@Test
	public void test () {

    }

}
