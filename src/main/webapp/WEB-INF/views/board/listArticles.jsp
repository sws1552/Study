<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%-- pageContext : jsp의 내장객체로 pageContext 객체를 참조할때 사용한다. --%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록창</title>
	<style>
		.cls1{text-decoration:none;}
		.cls2{text-align:center; font-size:30px;}
	</style>
	<script>
		function fn_articleForm(isLogOn, articleForm, loginForm){
			if(isLogOn != ' ' && isLogOn != 'false'){
				location.href=articleForm;
			}else{
				alert("로그인 후 글쓰기가 가능합니다.")
				location.href=loginForm + '?action=/board/articleForm.do';
			}
		}
	</script>
</head>
<body>
	<table align="center" border="1" width="80%">
		<tr height="10" align="center" bgcolor="lightgreen">
			<td>글번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>작성일</td>
		</tr>
		<%-- <c:choose> : switch문을 사용합니다. <c:when>과 <c:otherwise> 서브 태그를 갖습니다.
			<c:when test="조건식1">본문내용1</c:when>
			<c:when test="조건식2">본문내용2</c:when> 모든 조건이 거짓이면
			<c:otherwise>본문내용n</c:otherwise>태그의 본문 내용을 수행한다.
		 --%>
	<c:choose>
		<%-- <c:when> : 조건 --%>
		<c:when test="${articlesList == null}">
			<tr height="10">
				<td colspan="4">
					<p align="center">
						<b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
					</p>
				</td>
			</tr>			
		</c:when>
		<c:when test="${articlesList != null}">
			<%-- <c:forEach> : 반복문을 사용한다.
				<c:forEach var="반복할변수이름" items="반복할객체이름" begin="반복시작값" end="반복마지막값" step="증가값" varStatus="반복상태변수이름">
			 --%>
			<c:forEach var="article" items="${articlesList}" varStatus="articleNum">
				<tr align="center">
					<%-- count : varStatus의 속성 몇번째 반복인지 타나낸다. 1부터 시작한다. --%>
					<td width="5%">${articleNum.count}</td>
					<td width="10%">${article.id}</td>
					<td align='left' width="35%">
						<span style="padding-right:30px"></span>
							<c:choose>
								<%--level이 1보다 크면 답글을 표시한다. --%>
								<c:when test='${article.level > 1 }'>
									<c:forEach begin="1" end="${article.level }" step="1">
										<span style="padding-left:20px"></span>
									</c:forEach>
									<span style="font-size:12px; color:blue;">[답변]</span>
										<a class='cls1' href="${contextPath }
										/board/viewArticle.do?articleNO=${article.articleNO}">${article.title}</a>
								</c:when>
								<%--level이 1보다 작으면 부모 글을 표시한다. --%>
								<c:otherwise>
										<a class='cls1' href="${contextPath }
										/board/viewArticle.do?articleNO=${article.articleNO}">${article.title}</a>
								</c:otherwise>
							</c:choose>
					</td>
					<td width="10%">${article.writeDate }</td>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>		
	</table>
		<a class="cls1" href="javascript:fn_articleForm('${isLogOn}','${contextPath}/board/articleForm.do')
															,'${contextPath}/member/loginForm.do')"><p class="cls2">글쓰기</p></a>
</body>
</html>