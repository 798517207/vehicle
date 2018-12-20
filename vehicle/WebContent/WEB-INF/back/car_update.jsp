<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改教练车</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<style>
.table {
	width: 50%;
	margin: 50px auto;
}

.table table {
	width: 100%;
	background-color: #eeeeee;
}

.table table td {
	border: 1px solid white;
}

.t-l {
	text-align: right;
	width: 85px;
}

.button {
	width: 80%;
	margin: 40px auto;
	text-align: center;
}

.button input {
	width: 80px;
	height: 40px;
}

.liuling {
	display: none;
}
</style>
<body>
	<div class="table">
		<form id="form">
			<!-- 			<input type="hidden" name="method" value="linkAdd"> -->
			<!-- <input name="method" value="adminAdd" style="display:none" readonly="true"> -->
			<table cellspacing="0px">
				<thead>
					<th>修改教练车</th>
				</thead>
				<tbody>
					<tr>
						<td>车牌号: <input type="text" name="carNum" id="carNum" value="${map.CAR_NUM}"></td>
					</tr>
					<tr>
						<td>选择驾校: 
						<select name="schoolId" id="schoolId" onchange="querryCoach()">
							<option value="0">请选择</option>
							<c:forEach items= "${requestScope.schoolList}" var="School">
								<option value="${School.schoolId}">${School.schoolName}</option>
							</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<td>请选择教练: 
						<select name="coachId" id="coachId">
							<option value="0">请选择</option>
						</select>
						</td>
					</tr>
				</tbody>
			</table>
	</div>
	</form>
	<div class="button">
		<input type="button" value="修改" class="b-r" onClick="update()"> <input
			type="button" value="返回" class="b-r" onClick="back()">
	</div>
</body>
<script>
function querryCoach() {
	var id = $("#schoolId").val();
	var url = "${pageContext.request.contextPath}/back/coach/queryBySchoolId.handler?schoolId="+id;
	 $.ajax({	
		 url:url,
		 type:"post",	
		 success : function(data) {
			 var str =  "";			 
			 for(var i = 0;i<data.info.length;i++){
				 var car = data.info[i];
				 str += "<option value='"+car.COACH_ID+"'>"+car.COACH_NAME+"</option>";
			 }
			$("#coachId").html(str);
		 }
	 });
}
	function back() {
		window.history.back();
	}
	function update() {
		$.ajax({
					url : "${pageContext.request.contextPath}/back/car/addCar.handler",
					type : "post",
					data : $('#form').serialize(),
					success : function(data) {
						if (data.status == 'y') {
							window.alert(data.info);
							window.location.href = '${pageContext.request.contextPath}/back/car/queryCar.handler';
						} else {
							window.alert(data.info);
						}
					}
				});
	}
</script>
</html>