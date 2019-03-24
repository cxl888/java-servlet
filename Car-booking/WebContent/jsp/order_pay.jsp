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

				<div style="margin:0 auto;margin-top:10px;width:950px;">
					<strong>租单详情</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th colspan="5">租单编号:${orders.oid}</th>
							</tr>
							<tr class="warning">
								<th>汽车图片</th>
								<th>汽车名称</th>
								<th>租单金额</th>
								<th>租车时长</th>
								<th>小计</th>
							</tr>
							<c:forEach items="${orders.list}" var="item">
							 <tr class="active">
								<td width="60" width="40%">
							        <img src="${pageContext.request.contextPath}/${item.product.imageurl}" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank">${item.product.pname}</a>
								</td>
								<td width="20%">
									￥${item.product.shop_price}
								</td>
								<td width="10%">
									${item.pnum}
								</td>
								<td width="15%">
									<span class="subtotal">￥${item.subtotal}</span>
								</td>
							</tr>
							</c:forEach>
							
						</tbody>
					</table>
				</div>

				<div style="text-align:right;margin-right:120px;">
					租赁金额: <strong style="color:#ff6600;">￥${orders.totalmoney}元</strong>
				</div>

			</div>

			<div>
				<hr/>
				<form class="form-horizontal" style="margin-top:5px;margin-left:150px;" id="orderForm" action="${pageContext.request.contextPath}/OrderPayServlet">
					<div class="form-group">
					    <input type="hidden" name="oid" value="${orders.oid}">
						<label for="username" class="col-sm-1 control-label">交车地</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" name="address" value="${orders.address}" placeholder="请输入收货地址">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-1 control-label">租车人</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" name="name" value="${orders.name}" placeholder="请输收货人">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-1 control-label">电&nbsp;&nbsp;&nbsp;&nbsp;话</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" name="phone" value="${orders.phone}" placeholder="请输入联系方式">
						</div>
					</div>
					<div style="margin-top:5px;">
						<strong>选择银行：</strong>
						<p>
							<br/>
							<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked" />工商银行
							<img src="${pageContext.request.contextPath}/bank_img/icbc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="BOC-NET-B2C" />中国银行
							<img src="${pageContext.request.contextPath}/bank_img/bc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="ABC-NET-B2C" />农业银行
							<img src="${pageContext.request.contextPath}/bank_img/abc.bmp" align="middle" />
							<br/>
							<br/>
							<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C" />交通银行
							<img src="${pageContext.request.contextPath}/bank_img/bcc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="PINGANBANK-NET" />平安银行
							<img src="${pageContext.request.contextPath}/bank_img/pingan.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="CCB-NET-B2C" />建设银行
							<img src="${pageContext.request.contextPath}/bank_img/ccb.bmp" align="middle" />
							<br/>
							<br/>
							<input type="radio" name="pd_FrpId" value="CEB-NET-B2C" />光大银行
							<img src="${pageContext.request.contextPath}/bank_img/guangda.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C" />招商银行
							<img src="${pageContext.request.contextPath}/bank_img/cmb.bmp" align="middle" />
						</p>
						<p style="text-align:right;margin-right:100px;">
							<a href="javascript:document.getElementById('orderForm').submit();">
								<img src="${pageContext.request.contextPath}/img/pay_now.PNG" width="204" height="51" border="0" />
							</a>
						</p>
					</div>
				</form>
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