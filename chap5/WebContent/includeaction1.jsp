<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Include action 태그 예제</title>
</head>
<body>
<h3>include 액션태그는 다른 페이지의 내용을 가져 올 수 있는 기능이다.
단 출력버퍼만 공유 되므로 변수는 공유 되지 않는다.
=> 포함하는 페이지와 포함되는 페이지는 각각의 서블릿으로 생성되고 단지 출력 버퍼만 공유된다.
</h3>
<jsp:include page="includeaction2.jsp"/>
</body>
</html>