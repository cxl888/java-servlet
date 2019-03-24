<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
	</HEAD>
	
	<body>
		<!--  -->
		<form id="userAction_edit_do" name="Form3" action="${pageContext.request.contextPath}/FindAllOrdersServlet" method="post">
			
			
			
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>详细租单</STRONG>
						</strong>
					</td>
				</tr>
                <tr>
					
					
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						用户序号：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<%=request.getParameter("uid") %>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						租单编号：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<%=request.getParameter("oid") %>
					</td>
				</tr>
				
				<tr>
					
					
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						租车人：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<%=request.getParameter("name") %>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						联系电话：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<%=request.getParameter("phone") %>
					</td>
				</tr>
				<tr>
					
					
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						汽车名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<%=request.getSession().getAttribute("pname") %>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						租车时长：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<%=request.getSession().getAttribute("pnum") %>小时
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						租&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;金：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<%=request.getParameter("totalmoney")%>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						租单时间：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<%=request.getParameter("ordertime")%>
					</td>
				</tr>
			    <tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						交车地址：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<%=request.getParameter("address") %>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						租单状态：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<c:set var="status" scope="session" value="${orderstatus}"/>
												<c:if test="${status==1}">
													未付款
												</c:if>
												<c:if test="${status==2}">
													已付款，请派车
												</c:if>
												<c:if test="${status==3}">
													已派车，用户已确认
												</c:if>
					</td>
				</tr>
				
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<c:if test="${status==2}">
						<button type="submit" id="userAction_save_do_submit" value="派车" class="button_ok">派车
							<!-- &#30830;&#23450; -->
						</button>
                        </c:if>
						

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>