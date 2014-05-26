<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 19.05.2014
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%String m= (String) request.getAttribute("message");
    if(m!=null){%><h2><%=m%></h2><%}%>
<form method="post" action="/reg">
    <p>login: <input type="text" name="login"/></p>
    <p>password:<input type="password" name="password"/></p>
    <button type="submit">registration</button>
</form>
</body>
</html>
