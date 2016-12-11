<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.InetAddress"%>
<html>
<head><title>Hello World v<%=application.getInitParameter("version")%></title></head>
<body>
<h1>Hello World v<%=application.getInitParameter("version")%></h1>
<p>
Running version <%=application.getInitParameter("version")%> on host <%= InetAddress.getLocalHost().getHostAddress() %>
</p>
</body>
</html>