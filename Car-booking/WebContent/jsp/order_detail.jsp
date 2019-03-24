<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
		<script src="${pageContext.request.contextPath}/js/jquery-2.1.0.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
		<style>
		  body{
		   margin-top:20px;
		   margin:0 auto;
		 }
		 .carousel-inner .item img{
			 width:100%;
			 height:300px;
		 }
		 .container .row div{ 
			 /* position:relative;
			 float:left; */
		 }
		 
		font {
		    color: #3164af;
		    font-size: 18px;
		    font-weight: normal;
		    padding: 0 10px;
		}
		 </style>
	</head>
<body>
		<!-- 引入header.jsp文件即可拥有网站的头信息 -->
		<%@include file="header.jsp"%>

		<div class="container">
			<div class="row">
				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong>我的租单</strong>
					<table class="table table-bordered">
							<tr class="success">
								<td align="center" style="HEIGHT: 22px">租单编号</td>
								<td align="center" style="HEIGHT: 22px">租车人</td>
								<td align="center" style="HEIGHT: 22px">交车地址</td>
								<td align="center" style="HEIGHT: 22px">联系电话</td>
								<td align="center" style="HEIGHT: 22px">汽车名称</td>
								<td align="center" style="HEIGHT: 22px">下单时间</td>
								<td align="center" style="HEIGHT: 22px">租车时长</td>
								<td align="center" style="HEIGHT: 22px">租单金额</td>
								<td align="center" style="HEIGHT: 22px">租单状态</td>
								
							</tr>
							
							  <tr class="success">
								<td align="center" style="HEIGHT: 22px"><%=request.getParameter("oid") %></td>
								<td align="center" style="HEIGHT: 22px"><%=request.getParameter("name") %></td>
								<td align="center" style="HEIGHT: 22px"><%=request.getParameter("address") %></td>
								<td align="center" style="HEIGHT: 22px"><%=request.getParameter("phone") %></td>
								<td align="center" style="HEIGHT: 22px"><%=request.getSession().getAttribute("pname") %></td>
								<td align="center" style="HEIGHT: 22px"><%=request.getParameter("ordertime") %></td>
								<td align="center" style="HEIGHT: 22px"><%=request.getSession().getAttribute("pnum") %>小时</td>
								<td align="center" style="HEIGHT: 22px"><%=request.getParameter("totalmoney")%>元</td>
								<c:set var="status" scope="session" value="${orderstatus}"/>
												<c:if test="${status==1}">
													<td align="center" style="HEIGHT: 22px">未付款,请&nbsp&nbsp<a href="${pageContext.request.contextPath}/OrderPayServlet?oid=${order.oid}">付款</a>&nbsp&nbsp或&nbsp&nbsp<a href="${pageContext.request.contextPath}/DelOrderByOid?oid=${order.oid}">删除</a>&nbsp&nbsp订单</td>
												</c:if>
												<c:if test="${status==2}">
													<td align="center" style="HEIGHT: 22px">已付款,管理员正在派送车辆,等车辆到达后请&nbsp&nbsp<a href="${pageContext.request.contextPath}/OrderReciveServlet?oid=${order.oid}">确认交车</a></td>
												</c:if>
												<c:if test="${status==3}">
													 <td align="center" style="HEIGHT: 22px">请按时还车</td>
												</c:if>
								
								
								  <!-- <td>订单已完成,您可以&nbsp&nbsp<a href="${pageContext.request.contextPath}/DelOrderByOid?oid=${order.oid}">删除</a>&nbsp订单</td> -->
								 
								
							</tr>
						   
							
							
						</table>
						<strong>我的汽车</strong>
					<table class="table table-bordered">
							<tr class="success">
								<td align="center" style="HEIGHT: 22px">汽车名称</td>
								<td align="center" style="HEIGHT: 22px">汽车图片</td>
								<td align="center" style="HEIGHT: 22px">类别</td>
								<td align="center" style="HEIGHT: 22px">油耗</td>
								<td align="center" style="HEIGHT: 22px">排量</td>
								<td align="center" style="HEIGHT: 22px">级别</td>
								
								
								
							</tr>
							
							  <tr class="success">
								<td align="center" style="HEIGHT: 22px"><%=request.getSession().getAttribute("pname") %></td>
								
								<td align="center" style="HEIGHT: 22px"><img src="${pageContext.request.contextPath}/${product.imageurl}" width="70" height="60"></td>
								
								<td align="center" style="HEIGHT: 22px"><%=request.getSession().getAttribute("category") %></td>
								<td align="center" style="HEIGHT: 22px"><%=request.getSession().getAttribute("oil") %>百公里每时</td>
								
								<td align="center" style="HEIGHT: 22px"><%=request.getSession().getAttribute("displacement") %>T</td>
								<td align="center" style="HEIGHT: 22px"><%=request.getSession().getAttribute("rank") %>人座</td>
								
						   
							</tr>
							
							
						</table>
						<center><INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/></center>
					</div>
				</div>
			</div>
			
		<div style="margin-top:50px;">
			<img src="${pageContext.request.contextPath}/image/footer1.png" width="100%" height="50%" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a>关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a>友情链接</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2017-2018  版权所有
		</div>
	</body>
</html>