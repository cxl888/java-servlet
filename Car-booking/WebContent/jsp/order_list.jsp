<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>详细租单</title>
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
								<td align="center" style="HEIGHT: 22px">租车时间</td>
								<td align="center" style="HEIGHT: 22px">租单状态</td>
								<td align="center" style="HEIGHT: 22px">租单详情</td>
							</tr>
							<c:forEach items="${olist}" var="order">
							  <tr class="success">
								<td align="center" style="HEIGHT: 22px">${order.oid}</td>
								<td align="center" style="HEIGHT: 22px">${order.name}</td>
								<td align="center" style="HEIGHT: 22px">${order.address}</td>
								<td align="center" style="HEIGHT: 22px">${order.ordertime}</td>
								<c:if test="${order.orderstatus ==1}">
								  <td align="center" style="HEIGHT: 22px">未付款,请&nbsp&nbsp<a href="${pageContext.request.contextPath}/OrderPayServlet?oid=${order.oid}">付款</a>&nbsp&nbsp或&nbsp&nbsp<a href="${pageContext.request.contextPath}/DelOrderByOid?oid=${order.oid}">删除</a>&nbsp&nbsp订单</td>
								</c:if>
								<c:if test="${order.orderstatus ==2}">
								  <td align="center" style="HEIGHT: 22px">已付款,管理员正在派送车辆,等车辆到达后请&nbsp&nbsp<a href="${pageContext.request.contextPath}/OrderReciveServlet?oid=${order.oid}">确认交车</a></td>
								</c:if>
								<c:if test="${order.orderstatus ==3}">
								  <!-- <td>订单已完成,您可以&nbsp&nbsp<a href="${pageContext.request.contextPath}/DelOrderByOid?oid=${order.oid}">删除</a>&nbsp订单</td> -->
								  <td align="center" style="HEIGHT: 22px">请按时还车</td>
								</c:if>
								<td align="center" style="HEIGHT: 22px">
												
												<a href="${ pageContext.request.contextPath }/DetailOrdersForUser?oid=${order.oid}&totalmoney=${order.totalmoney}&ordertime=${order.ordertime}&orderstatus=${order.orderstatus}&name=${order.name}&phone=${order.phone}&address=${order.address}">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
							</td>
							</tr>
						   </c:forEach>
							
							
						</table>
					</div>
				</div>
			</div>
				<!--分页 -->
		<div style="width:380px;margin:0 auto;margin-top:50px;">
			<ul class="pagination" style="text-align:center; margin-top:10px;">
				
				<c:if test="${pb.pageNumber == 1}">
				  <li class="disabled"><a aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				</c:if>
				<c:if test="${pb.pageNumber != 1}">
				  <li><a href="${pageContext.request.contextPath}/FindAllOrdersByUserServlet?pageNumber=${pb.pageNumber-1}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				</c:if>
				<c:forEach begin="1" end="${pb.totalPage}" var="i">
				    <c:if test="${pb.pageNumber==i}">
				    	<li class="active"><a href="#">${i}</a></li>
				    </c:if>
					<c:if test="${pb.pageNumber != i}">
						<li><a href="${pageContext.request.contextPath}/FindAllOrdersByUserServlet?pageNumber=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pb.pageNumber == pb.totalPage}">
				  <li class="disabled"><a aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				</c:if>
				<c:if test="${pb.pageNumber != pb.totalPage}">
				  <li><a href="${pageContext.request.contextPath}/FindAllOrdersByUserServlet?pageNumber=${pb.pageNumber+1}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				</c:if>
				
			</ul>
		</div>
		<!-- 分页结束=======================        -->
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