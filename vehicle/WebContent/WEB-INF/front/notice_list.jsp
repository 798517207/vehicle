<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">   
<script type="text/javascript" src="${pageContext.request.contextPath}/js/base.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知公告列表</title>
</head>
<body>	
<!--内容部分每个界面不同的地方-->
<div class="left con">
    <!--所在位置-->
    <div class="perSerTab"><span>当前位置：</span><a href="javascript:void(0)">【公告列表】</a> </div>
    <!--内容部分-->
    <div class="perSerCon left">
        <div class="perSevchage left backBg">
            <h3 class="staticHsty">公告详情列表<h3/>
            <p id="chageTab"><span class="left listSpan"><a href="javascript:void(0)" title="图表" class="listTable"></a><a href="javascript:void(0)" title="统计图" class="listStatic"></a> </span>
                <span class="right"><label>时间：</label><input type="month" class="timeInput" /></span></p>
        </div>
        <div class="left persolSerCon borderNo staticTit" id="chageBox">
            <div class="staticChange" style="display: block" >
                <table border="0" class="staticTable">
                    <thead>
                    <tr>
                    <td>公告ID</td>
                    <td>公告标题</td>
                    <td>公告内容</td>
                    <td>公告状态</td>
                    <td>发布时间</td>
                    <td>操作</td>
                    </tr>
                    </thead>
                    <tbody>
                     <c:forEach items="${map}" var="map">
                    <tr><td>${map.noticeId}</td>
                    <td>${map.noticeTitle}</td>
                    <td>${map.noticeContent}</td>
                    <td>${map.noticeState}</td>
                    <td>${map.noticeDate}</td>
                    </c:forEach>
                    <td>
                    <input type="button" value="删除">
                    <input type="button" value="修改">
                    </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="staticChange borderStle" >
                <p class="staticChar" id="char"></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>