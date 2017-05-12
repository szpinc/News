package com.szp.entity;

public class Article {
	private int id;
	private String title;
	private String classify;
	private String attribute;
	private String attributeUrl;
	private String content;
	private String time;
	private int comment;
	private String previewPic;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public String getAttributeUrl() {
		return attributeUrl;
	}
	public void setAttributeUrl(String attributeUrl) {
		this.attributeUrl = attributeUrl;
	}
	public String getPreviewPic() {
		return previewPic;
	}
	public void setPreviewPic(String previewPic) {
		this.previewPic = previewPic;
	}
}
