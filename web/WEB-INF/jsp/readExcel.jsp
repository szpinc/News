<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'readExcel.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
td div {
	width: 200px;
	word-wrap: break-word;
	word-break: break-all;
}
</style>
</head>

<body>

	<s:form action="getExcel" namespace="/" theme="simple" method="post"
		enctype="multipart/form-data">
		<s:file name="file"></s:file>
		<s:submit value="提交"></s:submit>
	</s:form>

	<c:if test="${content!=null }">

		<span>选择要显示的行与列:</span>
		<div>
			<s:form action="show" namespace="/" theme="simple" method="post">
				<span>开始行</span>
				<select name="startRow">
					<c:forEach items="${rows }" var="row">
						<option value="${row }">${row }</option>
					</c:forEach>
				</select>
				<span>结束行</span>
				<select name="endRow">
					<c:forEach items="${rows }" var="row">
						<option value="${row }">${row }</option>
					</c:forEach>
				</select>
				<span>开始列</span>
				<select name="startCell">
					<c:forEach items="${cells }" var="cell">
						<option value="${cell }">${cell }</option>
					</c:forEach>
				</select>
				<span>结束列</span>
				<select name="endCell">
					<c:forEach items="${cells }" var="cell">
						<option value="${cell }">${cell }</option>
					</c:forEach>
				</select>
				<s:submit value="确定"></s:submit>
			</s:form>
		</div>

		<c:if test="${flag }">
			<div>
				<table align="left" border="1" width="100%" cellpadding="0" cellspacing="0">
				<c:choose>
					<c:when test="${startRow==0 }">
						<tr>
								<th colspan="${endCell+1 }">${content[0][0] }</th>
						</tr>
						
						<c:forEach begin="${startRow+1 }" end="${endRow }"
						items="${content }" var="content_1">
							<tr>
								<c:forEach begin="${startCell }" end="${endCell }"
									items="${content_1 }" var="content_2">
									<td><div>${content_2}</div></td>
								</c:forEach>
							</tr>
						</c:forEach>
					</c:when>
					
					<c:otherwise>
						<c:forEach begin="${startRow}" end="${endRow }"
						items="${content }" var="content_1">
						
							<tr>
								<c:forEach begin="${startCell }" end="${endCell }"
									items="${content_1 }" var="content_2">
									<td><div>${content_2}</div></td>
								</c:forEach>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				</table>
			</div>
		</c:if>
		</c:if>
</body>
</html>
