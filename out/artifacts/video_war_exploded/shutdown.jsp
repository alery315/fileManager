<%--
  Created by IntelliJ IDEA.
  User: alery
  Date: 18-10-30
  Time: 下午7:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>shutdown</title>
</head>
<body>

<%
    String os = System.getProperties().getProperty("os.name");
    if (os.equalsIgnoreCase("linux")) {
//        Runtime.getRuntime().exec("shutdown -h 1");  // 1分钟
    } else if (os.equalsIgnoreCase("windows")) {
        Runtime.getRuntime().exec("shutdown -s -t 30");  //30秒
    }
%>

</body>
</html>
