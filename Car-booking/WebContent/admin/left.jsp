<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
	<script type="text/javascript">
	
		d = new dTree('d');
		d.add('01',-1,'系统菜单树');
		d.add('0101','01','用户管理','','','mainFrame');
		d.add('010101','0101','用户管理','${pageContext.request.contextPath}/FindAllUsersServlet1','','mainFrame');
		d.add('0102','01','分类管理','','','mainFrame');
		d.add('010201','0102','分类管理','${pageContext.request.contextPath}/FindAllCategoryServlet','','mainFrame');
		d.add('0104','01','车辆管理');
		d.add('010401','0104','车辆管理','${pageContext.request.contextPath}/admin/product/Operating_classification.jsp','','mainFrame');
		d.add('0105','01','租单管理');
		d.add('010501','0105','租单管理','${pageContext.request.contextPath}/FindAllOrdersServlet','','mainFrame');
		document.write(d);
		
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
