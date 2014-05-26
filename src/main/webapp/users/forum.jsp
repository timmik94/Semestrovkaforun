<%@ page import="java.util.ArrayList" %>
<%@ page import="forum.hibernateclasses.Message" %>
<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 19.05.2014
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    String title= (String) request.getSession().getAttribute("name");
    %>
<h2><%=title%></h2>

<%
    ArrayList<Message> messages= (ArrayList<Message>) request.getSession().getAttribute("mess");
    for (int i=0;i<messages.size();i++){
        %><p><%=messages.get(i).toString()%></p> <%
    }
%>
<form method="post">
    <input type="hidden" value="<%=request.getAttribute("id")%>"/>
    <input type="text" name="text"/>
    <button type="submit">answer</button>
</form>

<form method="get" action="/users/tema"><button type="submit">to temas</button></form>

<form method="get" action="/exit"><button type="submit">exit</button></form>
</body>
</html>
