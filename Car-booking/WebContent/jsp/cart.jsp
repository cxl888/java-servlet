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
	
	<script type="text/javascript">
	   function confrimClear(){
		   var v=confirm("确定清空购物车吗?");
		   if(v){
			   window.location.href="${pageContext.request.contextPath}/ClearCartsServlet";
		   }
	   }
	   function Confrimdel(pid){
		   var v=confirm("确定删除该租单吗?");
		   if(v){
			   window.location.href="${pageContext.request.contextPath}/RemoveProductFromCartsServlet?pid="+pid;
		   }
	   }
	</script>
	
	
	
	</head>
<body>
		<!-- 引入header.jsp文件即可拥有网站的头信息 -->
		<%@include file="header.jsp"%>


		<div class="container">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong style="font-size:16px;margin:5px 0;">购物车详情</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th>汽车图片</th>
								<th>汽车名称</th>
								<th>线上租价</th>
								<th>租车时长</th>
								<th>小计</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${cart.map}" var="entry">
							
							<tr class="active">
								<td width="60" width="40%">
									
									<img src="${pageContext.request.contextPath}/${entry.value.product.imageurl}" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank">${entry.value.product.pname}</a>
								</td>
								<td width="20%">
									￥${entry.value.product.shop_price}
								</td>
								<td width="10%">
									${entry.value.count}小时
								</td>
								<td width="15%">
									<span class="subtotal">￥${entry.value.subtotal}</span>
								</td>
								<td>
									<a href="javascript:Confrimdel(${entry.value.product.pid});" class="delete">删除</a>
								</td>
							</tr>
							</c:forEach>
							
						</tbody>
					</table>
				</div>
			</div>

			<div style="margin-right:130px;">
				<div style="text-align:right;">
					<em style="color:#ff6600;">
				登录后确认是否享有优惠&nbsp;&nbsp;
			</em> 赠送积分: <em style="color:#ff6600;">${cart.totalMoney}</em>&nbsp; 租赁金额: <strong style="color:#ff6600;">￥${cart.totalMoney}元</strong>
				</div>
				<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
					<a href="javascript:confrimClear()" id="clear" class="clear">清空购物车</a>
					<a href="${pageContext.request.contextPath}/jsp/order_confirm.jsp">
						<input type="submit" width="100" value="提交订单" name="submit" border="0" style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;">
					</a>
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