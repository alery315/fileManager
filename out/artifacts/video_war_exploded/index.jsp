<%@ page import="java.util.List" %>
<%@ page import="bean.Video" %>
<%@ page import="util.Directory" %><%--
  Created by IntelliJ IDEA.
  User: alery
  Date: 18-10-30
  Time: 下午4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://vjs.zencdn.net/7.2.3/video-js.css" rel="stylesheet">
    <script src="https://vjs.zencdn.net/7.2.3/video.js"></script>
    <title>index</title>
</head>
<body>

<%--
    配置文件在conf文件夹下的server.xml中,
--%>

<%--<video id="my-video"--%>
<%--class="video-js vjs-default-skin vjs-big-play-centered"--%>
<%--controls preload="auto"--%>
<%--width="1000" height="800"--%>
<%--poster="" data-setup="{}">--%>
<%--<source src="video/2.mp4" type='video/mp4'>--%>
<%--&lt;%&ndash;<source src="MY_VIDEO.webm" type='video/webm'>&ndash;%&gt;--%>
<%--<p class="vjs-no-js">--%>
<%--To view this video please enable JavaScript, and consider upgrading to a web browser that--%>
<%--<a href="https://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>--%>
<%--</p>--%>
<%--</video>--%>

<%
    String para;
    para = request.getParameter("dir") == null ? "/home/alery" : request.getParameter("dir");
//    String dir = pageContext.getServletContext().getRealPath(para);
    String dir = para;
    System.out.println(dir);
%>
<span><a href="index.jsp?dir=<%=Directory.upDirectory(para)%>"><%=dir%></a></span>
<%
    out.print("<br>-------------------------------------------------------------<br>");
    List<Video> list = Directory.listDirectory(dir);
    if (list.size() == 0) {
        out.print("此目录为空!<br>");
    } else {
        for (Video video : list) {
            if (video.isDir()) {
%>
            <li><img style="width: 26px;height: 20px" src="img/file2.png"><a href="index.jsp?dir=<%=video.getPath()%>"><%=video.getFileName()%></a></li>
<%
            } else {
%>
                <li>
                    <img style="width: 20px;height: 20px" src="img/file1.png">
                    <a target="_blank" href="<%=video.getPath().replaceFirst("home", "video")%>">
                        <%=video.getFileName() + " &nbsp;&nbsp;size: " + video.getSize() + " "%>
                    </a>
                </li>
<%          }
        }
    }

    out.print("-------------------------------------------------------------<br>");
%>


<div style="margin-left: 150px">
    <a href="shutdown.jsp"><img style="width: 20px;height: 20px" src="img/shutdown.png"></a>
</div>

</body>
</html>
