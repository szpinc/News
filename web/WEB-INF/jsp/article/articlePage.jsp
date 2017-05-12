<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/9
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>SZP科技|文章|第${page.currentPage}页</title>
    <%--引入样式表--%>
    <jsp:include page="${basePath}/WEB-INF/jsp/public/styles.jsp"/>
</head>
    <body class="home blog nav_fixed list-comments-r site-layout-2">

        <%--头部--%>
        <header class="header"><jsp:include page="${basePath}/WEB-INF/jsp/public/header.jsp"></jsp:include></header>
        <!-- 搜索模块 -->
        <div class="site-search">
            <div class="container">
                <form method="get" class="site-search-form"
                      action="${basePath}/s">
                    <input class="search-input" name="s" type="text" placeholder="输入关键字"
                           value="">
                    <button class="search-btn" type="submit">
                        <i class="fa fa-search"></i>
                    </button>
                </form>
            </div>
        </div>
        <%--主干--%>
        <section class="container">
            <div class="content-wrap">
                <%--文章列表--%>
                <div class="content">
                    <div class="title">
                        <h3>最新发布</h3>
                    </div>
                    <jsp:include page="${basePath}/WEB-INF/jsp/article/article_list.jsp"></jsp:include>
                </div>
            </div>
            <%--侧边栏--%>
            <aside class="sidebar">
                <jsp:include page="${basePath}/WEB-INF/jsp/public/aside.jsp"></jsp:include>
            </aside>
        </section>

        <%--引入js文件--%>
        <jsp:include page="${basePath}/WEB-INF/jsp/public/scripts.jsp"/>

        <%--底部--%>
        <footer class="footer">
            <jsp:include page="${basePath}/WEB-INF/jsp/public/footer.jsp"></jsp:include>
        </footer>
    </body>
</html>
