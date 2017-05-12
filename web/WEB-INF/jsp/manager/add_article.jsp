<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>完整demo</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<script type="text/javascript" charset="utf-8"
	src="/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="/ueditor/lang/zh-cn/zh-cn.js"></script>

<style type="text/css">
div {
	width: 100%;
}
</style>
</head>

<body>

	<div>
		
		
		<s:form action="add_article"  namespace="/manage" method="post" enctype="multipart/form-data">
		
				<i>标题</i><input type="text" name="title"/><br/>
				<i>简介</i><input type="text" name="classify"/><br/>
				<i>所属类别</i> <select name="attribute">
					<c:forEach items="${attributeList }" var="attribute">
						<option value="${attribute.name }">${attribute.name }</option>
					</c:forEach>
				</select>
				<i>预览图</i><input type="file" name="file" id="file">
				<textarea name="content" id="myEditor" style="width:1024px;height:500px;"></textarea>
				<input type="submit" value="提交"/><br/>
		</s:form>
	</div>
	
		
		  <!-- 配置文件 -->
    <script type="text/javascript" src="/ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="/ueditor/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
        var editor = UE.getEditor('myEditor');
    </script>

</body>
</html>
