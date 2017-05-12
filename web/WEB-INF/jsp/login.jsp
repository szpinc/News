<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta name="apple-mobile-web-app-title" content="SZP科技"">
<meta name="applicable-device" content="pc,mobile">
<meta name="MobileOptimized" content="width" />
<meta name="HandheldFriendly" content="true" />


<title>SZP科技-登陆</title>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/public/styles.jsp"/>

</head>

<body class="home blog nav_fixed list-comments-r site-layout-2">



	<header class="header">
		<jsp:include page="./public/header.jsp"></jsp:include>
	</header>



	<!-- 搜索模块 -->
	<div class="site-search">
		<div class="container">
			<form method="get" class="site-search-form"
				action="https://www.landiannews.com/">
				<input class="search-input" name="s" type="text" placeholder="输入关键字"
					value="">
				<button class="search-btn" type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form>
		</div>
	</div>

	<div class="am-g">
		<div class="am-u-lg-4 am-u-md-8 am-u-sm-centered">
			<h3>登录</h3>
			<hr>
			<div class="am-btn-group">
				<a href="#" class="am-btn am-btn-secondary am-btn-sm"><i
					class="am-icon-qq am-icon-sm"></i> QQ</a> <a href="#"
					class="am-btn am-btn-success am-btn-sm"><i
					class="am-icon-wechat am-icon-sm"></i> 微信</a> <a href="#"
					class="am-btn am-btn-primary am-btn-sm"><i
					class="am-icon-weibo am-icon-sm"></i> 微博</a>
			</div>
			<br> <br>

			<form method="post" class="am-form">
				<label for="email">邮箱:</label> <input type="email" name=""
					id="email" value=""> <br> <label for="password">密码:</label>
				<input type="password" name="" id="password" value=""> <br>
				<label for="remember-me"> <input id="remember-me"
					type="checkbox"> 记住密码
				</label> <br />
				<div class="am-cf">
					<input type="submit" name="" value="登 录"
						class="am-btn am-btn-primary am-btn-sm am-fl"> <input
						type="submit" name="" value="忘记密码 ^_^? "
						class="am-btn am-btn-default am-btn-sm am-fr">
				</div>
			</form>
		</div>
	</div>
	
	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/public/scripts.jsp"/>
</body>
</html>