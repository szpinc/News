package com.szp.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.szp.entity.Article;
import com.szp.entity.Carousel;
import com.szp.service.ArticleService;
import com.szp.service.CarouselService;

public class ShowArticleAction extends ActionSupport {
	
	@Override
	public String execute() throws Exception {
		
		ArticleService articleService = new ArticleService();
		
		CarouselService carouselService = new CarouselService();
		
		List<Article> articleList = articleService.getAll();
		
		List<Carousel> carouselList = carouselService.getAll();
		
		Map<String, Object> application = ActionContext.getContext().getApplication();
		
		application.put("articleList", articleList);
		application.put("carouselList", carouselList);
		return super.execute();
	}
	
	
}
