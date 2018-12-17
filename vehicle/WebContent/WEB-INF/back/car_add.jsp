<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Validform_v5.3.2.js"></script>  
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.serializejson.js"></script>  
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">   
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/body.css"/> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教练车注册</title>
</head>
<body>
<div class="container">
	<section id="content">
		<form id="reg" method='post' >
			<h1>教练车注册</h1>
			<div>
				<input type="text" placeholder="carNum" required="" name="carNum" id="carNum" datatype="s1-10" errormsg="用户账号至少5个字符,最多10个字符!">
			</div>
			<div>
				<input type="text" placeholder="学员名称" required="" name="userName" id="userName" datatype="s1-10" errormsg="用户名至少5个字符,最多10个字符!"/>
			</div>
			<div>
				<select>
				<option></option>
				</select>
			</div>
		   
			<div>
				<input type="submit" value="注册" class="btn btn-primary" id="js-btn-login" />&nbsp;&nbsp;
				<input type="button" value="返回" class="btn btn-primary" id=""/>
			</div>
		</form>
	</section>
</div>	
</body>

</html>