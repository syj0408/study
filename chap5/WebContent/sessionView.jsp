<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>장바구니 보기</title>
</head>
<body>
<%
//cart : 사과 ,자몽
	List<String> cart = (List<String>)session.getAttribute("cart");
	if(cart == null || cart.size() == 0){
%>	<h3>장바구니에 상품이 없습니다.</h3>		
<%	}else {%>
<h3>장바구니 상품</h3>
<%
	for(String p : cart) {%>
	<h4><%=p %></h4>
<% } } 
	
//	session.invalidate(); //기존사용되던 session 객체를 유효하지 않도록 함.
						  //새로운  session객체로 생성됨.
//cart 속성만 제거
	session.removeAttribute("cart");
%>
</body>
</html>