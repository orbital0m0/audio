<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>청취 파일 리스트</title>
<link href="./style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function popup(url, name){
		var options = "width = 500; height = 300;"
		window.open(url, name, options)
	}
</script>
</head>
<body>
<c:if test="${id == null }">
	<script type="text/javascript">
		alert("로그인 화면으로 이동");
		location.href = '../member/signIn';
	</script>
</c:if>
<div class="title">
	<h3>파일 리스트</h3>
</div>
<div>
	<table>
		<thead>
			<tr>
				<th>no</th>
				<th>title</th>
				<th>id</th>
				<th>time</th>
				<th>play</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${list }">
				<tr>
					<td><c:out value="${list.codenum }" />
					<c:set var="number" value="${list.codenum }"/></td>
					<td><a href = "javascript:popup('./play?codenum=${list.codenum }', 'popup');">${list.title }</a></td>
					<td>${list.m_id }</td>
					<td>${list.update_time }</td>
					<td><a href = "javascript:popup('./play?codenum=${list.codenum }', 'popup');">▶</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="page">
	<c:if test="${count > 0 }">
		<c:set var="imsi" value="${ count % pageSize == 0 ? 0: 1 }" />
		<c:set var="pageCount" value="${count / pageSize + imsi }"/>
		<c:set var="pageBlock" value="${5 }" />
		<fmt:parseNumber var="result" value="${(currentPage - 1) / pageBlock }" integerOnly="true" />
		<c:set var="startPage" value="${result * pageBlock +1 }"/>
		<c:set var="endPage" value="${startPage + pageBlock - 1 }"/>
		<c:if test="${endPage > pageCount }">
			<c:set var="endPage" value="${pageCount }" />
		</c:if>
		<c:if test="${startPage > pageBlock }">
			<a href="../audio/list?pageNum=${startPage - pageBlock}">◁</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<a href="../audio/list?pageNum=${i}">${i }</a>
		</c:forEach>
		<c:if test="${endPage < pageCoun }">
			<a href="../audio/list?pageNum=${startPage + pageBlock}">▷</a>
		</c:if>
	</c:if>
</div>
</body>
</html>