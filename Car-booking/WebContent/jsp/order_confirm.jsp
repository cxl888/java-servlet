<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

				<div style="margin:0 auto;margin-top:10px;width:950px;">
					<strong>租单详情</strong>
					<table class="table table-bordered">
						<tbody>
							
							<tr class="warning">
								<th>汽车图片</th>
								<th>汽车名称</th>
								<th>租单金额</th>
								<th>租车时长</th>
								<th>小计</th>
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
								
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div style="text-align:right;margin-right:120px;">
					租赁金额: <strong style="color:#ff6600;">￥${cart.totalMoney}元</strong>
				</div>

			</div>

			<div>
				<hr/>
				<form class="form-horizontal" style="margin-top:5px;margin-left:200px;" id="orderForm" action="${pageContext.request.contextPath}/OrderConfirmServlet">
					<div class="form-group">
						<label for="username" class="col-sm-1 control-label">交车地</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" name="address" value="${orders.address}" placeholder="请输入交车地址">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-1 control-label">租车人</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" name="name" value="${orders.name}" placeholder="请输入租车人">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-1 control-label">电&nbsp;&nbsp;&nbsp;&nbsp;话</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" name="phone" value="${orders.phone}" placeholder="请输入联系方式">
						</div>
					</div>
					<p style="text-align:right;margin-right:100px;">
						<a href="javascript:document.getElementById('orderForm').submit();">
							<img src="${pageContext.request.contextPath}/images/finalbutton.gif" width="204" height="51" border="0" />
						</a>
					</p>
				</form>
				<hr/>
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
			Copyright &copy; 2017-2018   版权所有
		</div>

	</body>

</html>