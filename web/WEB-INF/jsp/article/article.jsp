<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>${article.title }</title>
    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/public/styles.jsp"/>
</head>

<body class="post-template-default single single-post postid-${article.id} single-format-standard nav_fixed list-comments-r comment-open site-layout-2">

<header class="header">
    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/public/header.jsp"/>
</header>
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

<section class="container">
    <div class="content-wrap">
        <div class="content">
            <header class="article-header">
                <h1 class="article-title"><a
                        href="${pageContext.request.contextPath}/archives/${article.id }">${article.title }</a>
                </h1>

                <div class="article-meta">
                    <span class="item">${article.time }</span>
                    <span class="item">
						 	分类：<a href="${article.attributeUrl }" rel="category tag">${article.attribute }</a>
						</span>
                    <span class="item">评论(${article.comment })</span>
                    <span class="item"></span>
                </div>
            </header>

            <article class="article-content">${article.content }</article>

            <div class="post-copyright">转载请注明<a href="https://www.szpinc.com.cn/">SZP科技</a> » <a
                    href="${pageContext.request.contextPath}/archives/${article.id }">${article.title }</a></div>

            <div class="relates">
                <div class="title"><h3>相关推荐</h3></div>
                <ul>
                    <c:forEach items="${relateArticles}" var="relateArticle">
                        <li>
                            <a href="${pageContext.request.contextPath}/archives/${relateArticle.id }">${relateArticle.title }</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <div class="title" id="comments">
                <h3>评论 <b>${article.comment }</b></h3>
            </div>

            <div id="respond" class="no_webshot">

                <s:form action="submit" method="post" id="commentform" namespace="/comment">

                    <div class="comt">
                        <div class="comt-box">
                            <textarea placeholder="所有评论均需人工审核才会发布，因此请不要重复提交。" class="input-block-level comt-area"
                                      name="comment" id="comment" cols="100%" rows="3" tabindex="1"
                                      onkeydown="if(event.ctrlKey&amp;&amp;event.keyCode==13){document.getElementById(&#39;submit&#39;).click();return false};"></textarea>
                            <div class="comt-ctrl">
                                <div class="comt-tips">
                                    <input type="hidden" name="comment_post_ID" value="34935" id="comment_post_ID">
                                    <input type="hidden" name="comment_parent" id="comment_parent" value="0">
                                    <label for="comment_mail_notify" class="checkbox inline hide" style="padding-top:0">
                                        <input type="checkbox" name="comment_mail_notify" id="comment_mail_notify"
                                               value="comment_mail_notify" checked="checked">有人回复时邮件通知我
                                    </label>
                                    <div class="comt-tip comt-loading" style="display: none;">评论提交中...</div>
                                    <div class="comt-tip comt-error" style="display: none;">提交失败</div>
                                </div>
                                <button type="submit" name="submit" id="submit" tabindex="5">提交审核</button>
                            </div>
                        </div>

                        <div class="comt-comterinfo" id="comment-author-info">
                            <ul>
                                <li class="form-inline"><label class="hide" for="author">昵称</label><input class="ipt"
                                                                                                          type="text"
                                                                                                          name="author"
                                                                                                          id="author"
                                                                                                          value=""
                                                                                                          tabindex="2"
                                                                                                          placeholder="昵称"><span
                                        class="text-muted">昵称 (必填)</span></li>
                                <li class="form-inline"><label class="hide" for="email">邮箱</label><input class="ipt"
                                                                                                         type="text"
                                                                                                         name="email"
                                                                                                         id="email"
                                                                                                         value=""
                                                                                                         tabindex="3"
                                                                                                         placeholder="邮箱"><span
                                        class="text-muted">邮箱 (必填)</span></li>
                                <li class="form-inline"><label class="hide" for="url">网址</label><input class="ipt"
                                                                                                       type="text"
                                                                                                       name="url"
                                                                                                       id="url" value=""
                                                                                                       tabindex="4"
                                                                                                       placeholder="网址"><span
                                        class="text-muted">网址</span></li>
                            </ul>
                        </div>

                    </div>

                </s:form>

            </div>


        <%--    <div id="postcomments">
                <ol class="commentlist">
                    <li class="comment even thread-even depth-1" id="comment-65532">
                        <span class="comt-f">#1</span>
                        <div class="comt-avatar">
                            <img data-src="https://secure.gravatar.com/avatar/df66c08ef82e83379b599dfe810d3cef?s=100&amp;d=mm"
                                 class="avatar avatar-100" height="50" width="50"
                                 src="./NASA将开始使用HoloLens帮助宇航员维修空间站_蓝点网_files/df66c08ef82e83379b599dfe810d3cef"
                                 style="display: block;">
                        </div>
                        <div class="comt-main" id="div-comment-65532">
                            <div class="wp-useragent">
                                <img src="./NASA将开始使用HoloLens帮助宇航员维修空间站_蓝点网_files/chrome.png"
                                     title="Google Chrome 59.0.3071.9" style="border:0px;vertical-align:middle;"
                                     alt="Google Chrome 59.0.3071.9" height="16" width="16"> Google Chrome 59.0.3071.9
                                <img src="./NASA将开始使用HoloLens帮助宇航员维修空间站_蓝点网_files/win-4.png"
                                     title="Windows 7 x64 Edition" style="border:0px;vertical-align:middle;"
                                     alt="Windows 7 x64 Edition" height="16" width="16"> Windows 7 x64 Edition
                            </div>
                            <p>我刚刚才发现一个问题，鸭子哥你发的文章都好整齐啊，一行恰好说完一句话。</p>
                            <div class="comt-meta">
                                <span class="comt-author">peanut</span>3小时前
                                <a rel="nofollow" class="comment-reply-link" href="javascript:;"
                                   onclick="return addComment.moveForm( &quot;div-comment-65532&quot;, &quot;65532&quot;, &quot;respond&quot;, &quot;34935&quot; )"
                                   aria-label="回复给peanut">回复</a>
                            </div>
                        </div>

                        <ul class="children">
                            <li class="comment byuser comment-author-admin bypostauthor odd alt depth-2"
                                id="comment-65535">
                                <div class="comt-avatar">
                                    <img data-src="https://secure.gravatar.com/avatar/e8dd8f45edcb9fd090e813d6d839f950?s=100&amp;d=mm"
                                         class="avatar avatar-100" height="50" width="50"
                                         src="./NASA将开始使用HoloLens帮助宇航员维修空间站_蓝点网_files/e8dd8f45edcb9fd090e813d6d839f950"
                                         style="display: block;">
                                </div>
                                <div class="comt-main" id="div-comment-65535">
                                    <div class="wp-useragent">
                                        <img src="./NASA将开始使用HoloLens帮助宇航员维修空间站_蓝点网_files/chrome.png"
                                             title="Google Chrome 58.0.3029.81"
                                             style="border:0px;vertical-align:middle;" alt="Google Chrome 58.0.3029.81"
                                             height="16" width="16"> Google Chrome 58.0.3029.81
                                        <img src="./NASA将开始使用HoloLens帮助宇航员维修空间站_蓝点网_files/win-6.png"
                                             title="Windows 10 x64 Edition" style="border:0px;vertical-align:middle;"
                                             alt="Windows 10 x64 Edition" height="16" width="16"> Windows 10 x64 Edition
                                    </div>
                                    <p>只是为了排版。。。</p>
                                    <div class="comt-meta">
												<span class="comt-author">
													<a href="http://www.landiannews.com/" rel="external nofollow"
                                                       class="url" target="_blank">山外的鸭子哥</a>
												</span>
                                        3小时前
                                        <a rel="nofollow" class="comment-reply-link" href="javascript:;"
                                           onclick="return addComment.moveForm( &quot;div-comment-65535&quot;, &quot;65535&quot;, &quot;respond&quot;, &quot;34935&quot; )"
                                           aria-label="回复给山外的鸭子哥">回复</a>
                                    </div>
                                </div>
                            </li>
                            <!-- #comment-## -->
                        </ul><!-- .children -->
                    </li><!-- #comment-## -->
                </ol>

                <div class="pagenav">
                </div>
            </div>--%>

        </div>
    </div>
    <aside class="sidebar">
        <jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/public/aside.jsp"/>
    </aside>
</section>

<footer class="footer">
    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/public/footer.jsp"></jsp:include>
</footer>
<!-- 引入js文件 -->
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/public/scripts.jsp"/>

</body>
</html>
