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
				<div style="margin:0 auto;width:950px;">
					<div class="col-md-6">
						<img src="${pageContext.request.contextPath}/${p.imageurl}" style="opacity: 1;width:400px;height:350px;" title="" class="medium">
					</div>

					<div class="col-md-6">
						<div><strong>${p.pname}</strong></div>
						<div style="border-bottom: 1px dotted #dddddd;width:350px;margin:10px 0 10px 0;">
							<div>编号:${p.pid}</div>
						</div>

						<div style="margin:10px 0 10px 0;">线上租价<strong style="color:#ef0101;">￥:${p.shop_price}元/时</strong> 参 考 价<del>￥:${p.market_price}元/时</del>
						</div>

						<div style="margin:10px 0 10px 0;">活动: <a target="_blank" title="限时优惠租 (2018-01-01 ~ 2018-07-01)" style="background-color: #f07373;">限时优惠</a> </div>

						<form action="${pageContext.request.contextPath}/AddProductToCartServlet" method="get">
							<div style="padding:10px;border:1px solid #e7dbb1;width:330px;margin:15px 0 10px 0;;background-color: #fffee6;">
								<div style="margin:5px 0 10px 0;">&nbsp;&nbsp;交车地:郑州</div>
	
								<div style="border-bottom: 1px solid #faeac7;margin-top:20px;padding-left: 10px;">租车时间（小时）:
									<input type="text" id="quantity" name="count" value="1" maxlength="4" size="10" > 
									<input type="hidden" name="pid" value="${p.pid}"> 
								</div>
								<div style="margin:20px 0 10px 0;;text-align: center;">
									<a href="javascript:void(0)">
										<input type="submit" value="立即租车！" style="background: url('${pageContext.request.contextPath}/images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0);height:36px;width:127px;">
									</a> &nbsp;收藏一下，下次还选它。
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="clear"></div>
				<div style="width:950px;margin:0 auto;">
					<div style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
						<strong>车辆介绍</strong>
					</div>
					
					<div>
						<img src="${pageContext.request.contextPath}/${p.imageurl}">
					</div>

					<div style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
						<strong>车辆参数</strong>
					</div>
					<div style="margin-top:10px;width:900px;">
						<table class="table table-bordered">
							<tbody>
								<tr class="active">
									<th colspan="2">基本参数</th>
								</tr>
								<tr>
									<th width="10%">乘载</th>
									<td width="30%">${p.rank}人座</td>
								</tr>
								<tr>
									<th width="10%">排量</th>
									<td>${p.displacement}T</td>
								</tr>
								<tr>
									<th width="10%">油耗</th>
									<td>${p.oil}L每百公里</td>
								</tr>
							</tbody>
						</table>
					</div>

					<div style="background-color:#d3d3d3;width:900px;">
						<table class="table table-bordered">
							<tbody>
								<tr class="active">
									<th><strong>商品描述</strong></th>
								</tr>
								<tr class="warning">
									<th>${p.pdesc}</th>
								</tr>
							</tbody>
						</table>
					</div>
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