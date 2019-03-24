<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
	</HEAD>
	
	<body>
	<%  request.setCharacterEncoding("UTF-8"); %>
		<form id="userAction_edit_cname" name="Form6" action="${pageContext.request.contextPath}/EditCategoryServlet" method="post">
			<input type="hidden" name="cid" value="<%=request.getParameter("cid") %>">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑分类名称</STRONG>
						</strong>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						原分类名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="cname1" value="<%=request.getParameter("cname")%>" id="userAction_cname" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						现分类名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="cname2" value="" id="userAction_edit_cname" class="bg"/>
					</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>