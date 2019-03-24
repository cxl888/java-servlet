<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确认是否修改图片</title>
<script type="text/javascript">
function ConfirmEditImageurl(){
	   var v=confirm("车辆基本信息修改成功,是否修改该车辆图片?");
	   if(v){
		   window.location.href="${pageContext.request.contextPath}/EditImageurlByPid1?pid="+${pid};
	   }
}
window.onload=ConfirmEditImageurl();
</script>
</head>
<body>
<div style="text-align: center;color:red;font-size:30px;">车辆修改成功!</div>
</body>
</html>