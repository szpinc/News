<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.szp.entity.User"%>
<%@page import="com.szp.entity.Article"%>
<%@page import="com.szp.entity.Comment"%>
<%@page import="com.szp.service.ArticleService"%>
<%@page import="com.szp.service.UserService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
	pageContext.setAttribute("basePath", basePath);
	UserService userService = new UserService();
	ArticleService articleService = new ArticleService();
	List<Comment> list = (List<Comment>)request.getAttribute("commentList");
 %>


		<%-- 	<div class="widget widget_text">
				<div class="textwidget">
					<div class="NOTICE">
						<span style="position:absolute"> <script async
								src="${basePath }/js/adsbygoogle.js"></script>
							<!-- Adsense_Landian_336*280_Sidebar_Top --> <ins
								class="adsbygoogle"
								style="display:inline-block;width:336px;height:280px"
								data-ad-client="ca-pub-8597288383599884"
								data-ad-slot="1329018455"></ins> <script>
									(adsbygoogle = window.adsbygoogle || [])
											.push({});
								</script> </span> <span> <a
							href="https://www.landiannews.com/archives/23957.html"
							target="_blank" rel="external nofollow"
							title="[代理工具] ShadowSocks下载、配置和使用指南"> <img
								src="//static.lancdn.com/tmp2/bwg_tool.jpg" width="336"
								height="280" alt="BWG Server" /> </a> </span>
					</div>
				</div>
			</div> --%>
			<!-- <div class="widget widget_text">
				<div class="textwidget">
					<a
						href="https://www.landiannews.com/archives/34235.html?utm_sources=Tool"
						target="_blank" title="网络加速器cFosSpeed正版团购 全球最低价19.9元 [已补货]"><img
						src="https://static.lancdn.com/tmp2/2017/cFosSpeed0414.png"
						alt="网络加速器cFosSpeed正版团购 全球最低价19.9元 [已补货]" width="349" height="160" />
					</a>
				</div>
			</div> -->
			<div class="widget widget_text">
				<div class="textwidget">
					<a href="https://www.landiannews.com/archives/33577.html"
						target="_blank" title="Windows 10 创意者更新全版本iso镜像下载"><img
						src="https://img.lancdn.com/landian/2017/04/W10-CU-ISO-DOWNLOAD.png"
						alt="Windows 10 创意者更新全版本ISO镜像下载" width="349" height="120" />
					</a>
				</div>
			</div>
			<div class="widget widget_text">
				<div class="textwidget">
					<img src="${basePath }/images/wx.png"
						alt="蓝点网微信公众号" width="336" />
				</div>
			</div>
			<div class="widget widget_ui_posts">
				<h3>随机推荐</h3>
				<ul class="nopic">
		<!-- 			<li><a target="_blank"
						href="https://www.landiannews.com/archives/12405.html"><span
							class="text">Windows Phone Lumia Denim推送计划延迟至12月第二周</span><span
							class="muted">2014-11-27</span><span class="muted">评论(1)</span>
					</a>
					</li>
					<li><a target="_blank"
						href="https://www.landiannews.com/archives/19369.html"><span
							class="text">微软新旗舰Lumia 950/950XL售价曝光 着实不便宜</span><span
							class="muted">2015-09-22</span><span class="muted">评论(7)</span>
					</a>
					</li>
					<li><a target="_blank"
						href="https://www.landiannews.com/archives/8782.html"><span
							class="text">Windows 10 发布为微软旗下设备大变脸，包括Xbox One</span><span
							class="muted">2014-10-01</span><span class="muted">评论(2)</span>
					</a>
					</li>
					<li><a target="_blank"
						href="https://www.landiannews.com/archives/4512.html"><span
							class="text">商讨阶段:微软或将推出Windows 365</span><span class="muted">2014-05-01</span><span
							class="muted">评论(2)</span>
					</a>
					</li>
					<li><a target="_blank"
						href="https://www.landiannews.com/archives/6865.html"><span
							class="text">微软回应反垄断调查：中国业务始终合法合规</span><span class="muted">2014-07-31</span><span
							class="muted">评论(10)</span>
					</a>
					</li>
					<li><a target="_blank"
						href="https://www.landiannews.com/archives/15600.html"><span
							class="text">华硕即将推出最便宜的C201 Chromebook：售价低于$199</span><span
							class="muted">2015-03-23</span><span class="muted">评论(2)</span>
					</a>
					</li> -->
				</ul>
			</div>
			<div class="widget widget_text">
				<!-- <div class="textwidget">
					<a href="http://www.qy.com.cn/" target="_blank"
						rel="external nofollow"><img
						src="//static.lancdn.com/tmp2/qy_20161222_20170316.jpg" />
					</a>
				</div> -->
			</div>
			<%-- <div class="widget widget_text">
				<div class="textwidget">
					<div class="NOTICE">
						<span style="position:absolute"> <script async
								src="${basePath }/js/adsbygoogle.js"></script>
							<!-- Adsense_Landian_336*280_Sidebar_Center --> <ins
								class="adsbygoogle"
								style="display:inline-block;width:336px;height:280px"
								data-ad-client="ca-pub-8597288383599884"
								data-ad-slot="4282484855"></ins> <script>
									(adsbygoogle = window.adsbygoogle || [])
											.push({});
								</script> </span> <span> <a
							href="https://www.landiannews.com/white-list-in-adblock"
							target="_blank" rel="external nofollow"> <img
								src="//static.lancdn.com/tmp2/lds_tool_right2.png" width="336"
								height="280" alt="" /> </a> </span>
					</div>
				</div>
			</div> --%>
			<div class="widget widget_ui_comments">
				<h3>最新评论</h3>
				<ul>
				
				
				
					<% 
					
					 
					 	for(Comment comment : list) {
					 	
					 	Article article = articleService.getById(comment.getArticleId());
					 	User user = userService.getById(comment.getUserId());
					 	pageContext.setAttribute("comment", comment);
					 	pageContext.setAttribute("commentArticle", article);
					 	pageContext.setAttribute("commentUser", user);
					 	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
						Date commentDate = format.parse(comment.getTime());
						int hour = (int)((new Date().getTime()-commentDate.getTime())/(1000*60*60));
					 	pageContext.setAttribute("hour", hour);
					 %>
					 	<li><a
						href="${commentArticle.articleUrl }"
						title="${commentArticle.articleTitle }上的评论"><img
							data-src="${basePath }${commentUser.logoPath }"
							class="avatar avatar-100" height="50" width="50"> <strong>${commentUser.username }</strong>
							${hour }小时前说：<br>${comment.content }</a>
						</li>	
					<%} %> 
					
					<%-- <c:forEach var="comment" items="${commentList }">
						<li><a
						href="${comment.article }"
						title="${comment.articleTitle }上的评论"><img
							data-src="${basePath }/user/logo?id=${comment.userId}"
							class="avatar avatar-100" height="50" width="50"> <strong>${comment.userName }</strong>
							<!-- 2小时前说： --><br>${comment.info }</a>
						</li>
					</c:forEach> --%>	
				</ul>
			</div>
			<div class="widget widget_links">
				<h3>友情链接</h3>
				<ul class='xoxo blogroll'>
					
				</ul>
			</div>