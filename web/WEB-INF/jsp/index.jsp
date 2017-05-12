<%@page import="com.szp.service.UserService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>SZP科技-首页</title>
		<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/public/styles.jsp"/>
	</head>

	<body class="home blog nav_fixed list-comments-r site-layout-2">
		<header class="header"><jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/public/header.jsp"></jsp:include></header>

		<!-- 搜索模块 -->
		<div class="site-search">
			<div class="container">
				<form method="get" class="site-search-form"
					  action="${pageContext.request.contextPath}/s">
					<input class="search-input" name="s" type="text" placeholder="输入关键字"
						   value="">
					<button class="search-btn" type="submit">
						<i class="fa fa-search"></i>
					</button>
				</form>
			</div>
		</div>


		<!-- 轮播图 -->
		<section class="container">
			<div class="content-wrap">
				<div class="content">
					<div id="focusslide" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#focusslide" data-slide-to="0" class="active"></li>
							<li data-target="#focusslide" data-slide-to="1"></li>
							<li data-target="#focusslide" data-slide-to="2"></li>
							<li data-target="#focusslide" data-slide-to="3"></li>
							<li data-target="#focusslide" data-slide-to="4"></li>
						</ol>
						<div class="carousel-inner" role="listbox">

							<div class="item active">
									<a target="_blank" href="${carouselList[0].url }"><img
										src="${carouselList[0].pic }"> </a>
								</div>
							<c:forEach var="carousel" items="${carouselList }" begin="1">
								<div class="item">
									<a target="_blank" href="${carousel.url }"><img
										src="${carousel.pic }"> </a>
								</div>
							</c:forEach>
						</div>
						<a class="left carousel-control" href="#focusslide" role="button"
							data-slide="prev"><i class="fa fa-angle-left"></i>
						</a><a class="right carousel-control" href="#focusslide" role="button"
							data-slide="next"><i class="fa fa-angle-right"></i>
						</a>
					</div>

					<div class="title">
						<h3>最新发布</h3>
					</div>
					<!-- 文章列表 -->
					<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/article/article_list.jsp"></jsp:include>
				</div>
			</div>

			<aside class="sidebar">
				<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/public/aside.jsp"></jsp:include>
			</aside>

		</section>


	<footer class="footer">
		<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/public/footer.jsp"></jsp:include>
	</footer>


	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/public/scripts.jsp"/>
</body>
</html>