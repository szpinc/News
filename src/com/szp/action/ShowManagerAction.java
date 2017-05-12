package com.szp.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.szp.entity.Article;
import com.szp.entity.ArticleAttribute;
import com.szp.service.ArticleAttributeService;
import com.szp.service.ArticleService;
import com.szp.util.FileUploadUtil;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ShowManagerAction extends ActionSupport {
	
	private Map<String, Object> request = (Map<String, Object>)ActionContext.getContext().get("request");
	
	private String title;
	private String classify;
	private String attribute;
	private String content;
	
	private File file;
	private String fileFilename;
	private String fileContentType;

	private ArticleAttributeService articleAttributeService = new ArticleAttributeService();
	private ArticleService articleService = new ArticleService();
	
	public String add () {
		List<ArticleAttribute> attributeList = articleAttributeService.getAll();
		request.put("attributeList", attributeList);
		return SUCCESS;
	}

	/**
	 * 添加文章action
	 * @return
	 */
	public String addArticle () throws FileNotFoundException {

		InputStream in = new FileInputStream(file);
		DateFormat format = new SimpleDateFormat("YYYYMMdd");
		String timePath = format.format(new Date());
		String rootPath = ServletActionContext.getRequest().getServletContext().getRealPath("/");
		String fileName = timePath+new Random().nextInt(9999)+".jpg";
		String basePath = "upload/pic/"+timePath;
		FileUploadUtil.upload(in,rootPath+basePath,fileName);


		Article article = new Article();
		article.setTitle(title);
		article.setAttribute(attribute);
		article.setAttributeUrl("/"+articleAttributeService.getByName(attribute).getPath());
		article.setClassify(classify);
		article.setContent(content);
		article.setPreviewPic(basePath+"/"+fileName);
		articleService.add(article);
		return SUCCESS;
	}














	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getClassify() {
		return classify;
	}


	public void setClassify(String classify) {
		this.classify = classify;
	}


	public String getAttribute() {
		return attribute;
	}


	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public String getFileFilename() {
		return fileFilename;
	}


	public void setFileFilename(String fileFilename) {
		this.fileFilename = fileFilename;
	}

	public String getImageContentType() {
		return fileContentType;
	}

	public void setImageContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
}
