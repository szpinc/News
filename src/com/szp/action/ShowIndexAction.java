package com.szp.action;

import java.util.List;
import java.util.Map;

import com.szp.entity.*;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.szp.service.ArticleService;
import com.szp.service.CarouselService;
import com.szp.service.CommentService;
import com.szp.service.UserService;

public class ShowIndexAction extends ActionSupport {
	private Map<String, Object> request = (Map<String, Object>)ActionContext.getContext().get("request");
	private Map<String, Object> session = ActionContext.getContext().getSession();
	
	@Override
	public String execute() throws Exception {
		showArticleList();
		showCarousel();
		showNewComment();
		return super.execute();
	}

	/**
	 * 显示首页新闻列表数据
	 */
	public void showArticleList () {

		ArticleService articleService = new ArticleService();
		Page page = new Page();
		page.setTotalPage(articleService.getArticleCount());
		page.setNextPage(2);
		page.setPageSize(8);
		List<Article> articleList = articleService.getByDesc(0,page.getPageSize());
		request.put("articleList", articleList);
		session.put("page", page);
	}

	/**
	 * 显示轮播图数据
	 */
	public void showCarousel () {
		CarouselService carouselService = new CarouselService();
		List<Carousel> carouselList = carouselService.getAll();
		request.put("carouselList", carouselList);
	}

	/**
	 * 显示首页评论数据
	 */
	public void showNewComment () {
		CommentService commentService = new CommentService();
		List<Comment> commentList = commentService.getByTimeDescLimit(10);
//		application.put("commentList", commentList);
		request.put("commentList", commentList);
	}
}
