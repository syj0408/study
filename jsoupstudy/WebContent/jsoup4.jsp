<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@ page import="java.io.IOException" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  jsoup4.jsp : jsoup3.jsp 에서 통화 국가명 추가
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>class 속성으로 조회하기</title>
<style type="text/css">
	table,td,th{border : 2px solid grey;
				border-collapse: collapse;}
 </style>
</head>
<body>
<%
	String url = "https://www.koreaexim.go.kr/site/program/financial/exchange?menuid=001001004002001";
	String line ="";
	Document doc = null;
	List<String> list = new ArrayList<String>();
	List<String> list2 = new ArrayList<String>();
	try{
		doc = Jsoup.connect(url).get();
		Elements e1 = doc.select(".tc");//class 속성 값이 tc인 태그 선택
		Elements e2 = doc.select(".tl2.bdl");//class 속성 값이 tl2.bdl인 태그 선택
		for(Element ele : e1){
			list.add(ele.html());
		}
		for(Element ele : e2){
			list2.add(ele.html());
		}
	}catch(IOException e){
			e.printStackTrace();
	} 
	pageContext.setAttribute("list", list);
	pageContext.setAttribute("list2", list2);
%>
<table> 
<c:forEach items="${list}" var="v" varStatus="stat">
	<c:choose>
		<c:when  test="${stat.index % 7== 0}">
			<tr><td rowspan="6">${v}</td>
				<td rowspan="6">${list2[stat.index/7]}</td> <!-- //국가코드 -->
		</c:when>
		<c:when test="${stat.index % 7 == 1}">
			<td>${v}</td></tr>
		</c:when>
		<c:otherwise>
			<tr><td>${v}</td></tr>
		</c:otherwise>
	</c:choose>
</c:forEach> 
</table>
</body>
</html>