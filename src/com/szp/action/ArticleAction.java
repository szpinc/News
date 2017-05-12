package com.szp.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ExceptionHolder;
import com.szp.entity.Article;
import com.szp.entity.Comment;
import com.szp.entity.Page;
import com.szp.service.ArticleService;
import com.szp.service.CommentService;
import org.apache.struts2.ServletActionContext;

import java.util.List;
import java.util.Map;

/**
 * Created by GhostDog on 2017/5/6.
 */
public class ArticleAction extends ActionSupport {
    private Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
    private Map<String, Object> session = ActionContext.getContext().getSession();
    private ArticleService articleService = new ArticleService();


    @Override
    public String execute() throws Exception {
        StringBuffer requestURL = ServletActionContext.getRequest().getRequestURL();
        int i = requestURL.lastIndexOf("/");
        String substring = requestURL.substring(i + 1);
        int id = 0;
        try {
            id = Integer.parseInt(substring);
        } catch (Exception e) {
            return "404";
        }

        Article article = articleService.getById(id);
        if (article == null) {
            return "404";
        }

        request.put("article", article);
        showNewComment();
        return SUCCESS;
    }

    private void showNewComment() {
        CommentService commentService = new CommentService();
        List<Comment> commentList = commentService.getByTimeDescLimit(10);
        request.put("commentList", commentList);
    }

    /**
     *
     * @return
     */
    public String pageAction () {



        String url = ServletActionContext.getRequest().getRequestURL().toString();
        String[] split = url.split("page/");
        if (split.length!=2) {
            for (String str : split){
                System.out.println(str+"------------------");
            }
            System.out.println("-----------");
            return "404";
        }

        Page page = (Page)session.get("page");

        if (page == null){
            page.setTotalPage(articleService.getArticleCount());
            page.setPageSize(8);
        }

        int count = 0;

        try {
            count = Integer.parseInt(split[1]);
            if (count>(page.getTotalPage()/page.getPageSize()+1)||count<=0){
                return "404";
            }if (count==1){
                return "index";
            }
            page.setCurrentPage(count);
        }catch (Exception e){
            e.printStackTrace();
            return "404";
        }
        page.setNextPage(count+1);
        List<Article> articleList = articleService.getByDesc((count - 1) * page.getPageSize(), page.getPageSize());
        request.put("articleList",articleList);
        session.put("page",page);
        showNewComment();
        return SUCCESS;
    }

}
