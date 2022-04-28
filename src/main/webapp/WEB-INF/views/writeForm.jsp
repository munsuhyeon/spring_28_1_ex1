<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한줄 글쓰기</title>
</head>
<body>
	<h2>한줄 글쓰기</h2>
	<table width="600" cellpadding="0" cellspacing="0" border="1">
		<form action="write" method="post">
			<tr>
				<td align="center" bgcolor="pink" width="100">작성자</td>
				<td><input type="text" name="mwriter" size="60"></td>
			</tr>
			<tr>
				<td align="center" bgcolor="pink" width="100">내용</td>
				<td><input type="text" name="mcontent" size="130"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="글입력">
					<a href="list">글목록보기</a>
				</td>
			</tr>
		</form>
	</table>
</body>
</html>