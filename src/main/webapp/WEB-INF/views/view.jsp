<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용 보기</title>
</head>
<body>
	글번호 : ${dto.mid}<br><br>
	작성자 : ${dto.mwriter }<br><br>
	글내용 :  ${dto.mcontent }<br><br>
	<a href="list">글목록보기</a>
</body>
</html>