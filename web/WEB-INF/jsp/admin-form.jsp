<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>听课排课处理</title>
  <meta name="description" content="这是一个form页面">
  <meta name="keywords" content="form">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/admin.css">
  <script src="${pageContext.request.contextPath }/js/main.js"></script>
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar am-topbar-inverse admin-header">
  <div class="am-topbar-brand">
    <a href="http://www.szpinc.com.cn/index"><strong>SZP科技</strong></a> 
  </div>

  
  

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-users"></span> 功能 <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="#"></span> 解析Excel</a></li>
          <li><a href="#"></span> 听课排课</a></li>          
        </ul>
      </li>
    </ul>
  </div>
</header>



<div class="admin-content">
  <div class="admin-content-body">
    <div class="am-cf am-padding am-padding-bottom-0">
      <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">表单</strong> 
        <small>form</small>
      </div>
    </div>

    <hr>

    <div class="am-tabs am-margin" data-am-tabs>
    

      <div class="am-tabs-bd">
        <div class="am-tab-panel am-fade am-in am-active" id="tab1">
          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">选择教师</div>
            <div class="am-u-sm-8 am-u-md-10">
              <select id="t_name" onchange="cascade(this.value)">
                <option value="-1">请选择</option>
                <c:forEach items="${nameMap }" var="name">
					<option value="${name.key }">${name.value }</option>
				</c:forEach>
              </select>
            </div>
          </div>

          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">选择课程</div>
            <div class="am-u-sm-8 am-u-md-10"  id="le_div">
              <select id="lesson">
                <option>请选择</option>
              </select>
            </div>
          </div>

          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">选择地点</div>
			<div class="am-u-sm-8 am-u-md-10"  id="cl_div">
              <select id="lessonClass">
                <option>请选择</option>
              </select>
            </div>          
          </div>

          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">听课教师1</div>
            <div class="am-u-sm-8 am-u-md-10" id="fr_div">
              <select id="ft1">
              	<option>请选择</option>
              </select>
              <select id="ft2">
               <option>请选择</option>
              </select>
            </div>  
          </div>

          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">
              发布时间
            </div>
           <div class="am-u-sm-8 am-u-md-10">
              <form action="" class="am-form am-form-inline">
                <div class="am-form-group am-form-icon">
                  <i class="am-icon-calendar"></i>
                  <input type="date" class="am-form-field am-input-sm" placeholder="日期">
                </div>
              </form>
            </div>
          </div>

        </div>

    <div class="am-margin">
      <button type="button" class="am-btn am-btn-primary am-btn-xs" onclick="submit()">提交保存</button>
      <button type="button" class="am-btn am-btn-primary am-btn-xs">放弃保存</button>
    </div>
  </div>

  <footer class="admin-content-footer">
    <hr>
    <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
  </footer>
</div>

</div>

<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

<footer>
  <hr>
  <p class="am-padding-left">© 2017 SZP, Inc. Licensed under SZP Inc. license.</p>
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="${pageContext.request.contextPath }/assets/js/jquery-3.1.1.min.js"></script>
<!--<![endif]-->
<script src="${pageContext.request.contextPath }/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/app.js"></script>
</body>
</html>
