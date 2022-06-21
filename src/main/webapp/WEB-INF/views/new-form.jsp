<%--
  Created by IntelliJ IDEA.
  User: yangyunhyeuk
  Date: 2022-06-21
  Time: 오후 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
<!-- http://localhost:8080/sevlet-mvc/members/여기에 action 값이 들어간다. -->
<!-- form의 action을 보면 절대 경로(/로 시작)가 아니라 상대 경로(/로 시작 X)를 타는 것을 볼 수 있다 -->
<!-- 이렇듯 상대경로를 사용하면 현재 계층 경로에 action이 추가되어 호출됨을 확인할 수 있다 -->

<form action="save" method="post">
    username: <input type="text" name="username"/>
    age: <input type="text" name="age"/>
    <button type="submit">전송</button>
</form>

</body>
</html>
