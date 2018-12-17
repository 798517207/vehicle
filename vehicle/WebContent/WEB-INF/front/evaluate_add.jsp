<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增评价表</title>
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
					<th>新增评价表</th>
				</thead>
				<tbody>
				<tr>
					<td>
				      <select>请选择教练:
				      <option value="">
				      </option>
				      </select>
					</td>
				</tr>
				
					<tr>
						<td>评价内容: <input type="text" name="evaluateContent" id="evaluateContent"></td>
					</tr>
					
				</tbody>
			</table>
	</div>
	</form>
	<div class="button">
		<input type="button" value="添加" class="b-r" onClick="add()"> <input
			type="button" value="返回" class="b-r" onClick="back()">
	</div>
</body>
<script>
	function back() {
		window.history.back();
	}
	function add() {
		$.ajax({
					url : "${pageContext.request.contextPath}/back/Link/linkAdd.handler",
					type : "post",
					data : $('#form').serialize(),
					success : function(data) {
						if (data.status == 'y') {
							window.alert(data.info);
							window.location.href = '${pageContext.request.contextPath}/back/Link/linkQueryAll.handler';
						} else {
							window.alert(data.info);
						}
					}
				});
	}
</script>
</html>