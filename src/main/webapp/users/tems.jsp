<%@ page import="java.util.ArrayList" %>
<%@ page import="forum.hibernateclasses.Tema" %>
<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 09.05.2014
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    ArrayList<Tema>tems= (ArrayList<Tema>) request.getSession().getAttribute("tems");
%><p><%=tems.size()%></p><%
    for(int i=0;i<tems.size();i++){
        Tema t=tems.get(i);
        %>
       <form method="get" action="/users/message">
          <p> <%=t.toString()%> <input name="id" type="hidden" value="<%=t.getId()%>" /><button type="submit">discuss</button></p>
       </form>
        <%
    }

%>
<form action="/users/tema" method="post">
   <p>name: <input type="text" name="tema"/><p/>
    <button type="submit">create tema</button>
</form>
<form method="get" action="/exit"><button type="submit">exit</button></form>
</body>
</html>
