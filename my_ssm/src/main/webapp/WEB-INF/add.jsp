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
    <form method="post" action="/test/add">
        name:<input type="text" name="name"/>
        address:<input type="text" name="address"/>
        phone:<input type="text" name="phone"/>
        <input type="submit" value="submit"/>
    </form>
</table>
<body>

</body>
