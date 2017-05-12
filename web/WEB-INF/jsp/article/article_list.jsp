<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
    pageContext.setAttribute("basePath", basePath);
%>

<c:forEach var="article" items="${articleList }">
	<article class="excerpt excerpt-1">
		<a target="_blank" class="focus" href="${pageContext.request.contextPath }/archives/${article.id}"><img
			data-src="${basePath}/${article.previewPic}" alt=""
			src="${pageContext.request.contextPath }/images/thumbnail.png" class="thumb"> </a>

		<header>
			<a class="cat" href="${article.attributeUrl }">${article.attribute }<i></i>
			</a>
			<h2>
				<a target="_blank" href="${basePath }/archives/${article.id}"
					title="${article.title }">${article.title }</a>
			</h2>

			<p class="meta">
				<time>
					<i class="fa fa-clock-o"></i>${article.time }
				</time>
				<a class="pc"
					href="${basePath }/archives/${article.id}#comment"><i
					class="fa fa-comments-o"></i>评论(${article.comment })</a>
			</p>

			<p class="note">${article.classify }</p>
		</header>
	</article>
</c:forEach>

<!-- 分页 -->
<div class="pagination">
	<ul>
		<li class="next-page"><a
			href="${basePath}/page/${page.nextPage}">下一页</a></li>
		<li><span>共 ${page.totalPage} 页</span></li>
	</ul>
</div>
