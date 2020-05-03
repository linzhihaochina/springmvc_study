<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.youngforcoding.pojo.Resume" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
     
    <base href="<%=basePath%>">
       
      <title>My JSP 'register.jsp' starting page</title>
       
     
    <meta http-equiv="pragma" content="no-cache">
     
    <meta http-equiv="cache-control" content="no-cache">
     
    <meta http-equiv="expires" content="0">
       
     
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
     
    <meta http-equiv="description" content="This is my page">
     
</head>

<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>address</th>
        <th>phone</th>
    </tr>
    <%
        List<Resume> list = (List<Resume>) request.getAttribute("list");
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
    %>
    <tr>
        <td><%=list.get(i).getId()%></td>
        <td><%=list.get(i).getName()%></td>
        <td><%=list.get(i).getAddress()%></td>
        <td><%=list.get(i).getPhone()%></td>
    </tr>
    <%

            }
        }
    %>
</table>
<body>

</body>
