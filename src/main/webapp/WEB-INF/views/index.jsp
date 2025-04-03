<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
  <h1>글 등록</h1>
  <form method="post" action="${pageContext.request.contextPath}/post">
    <label>닉네임: <input name="nickname" required></label>
    <label>비밀번호: <input type="password" name="password" required></label>
    <label>제목: <input name="title" required></label>
    <label>내용: <input name="contents" required></label>
    <input type="submit" value="등록">
  </form>
</body>
</html>