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


		
		<c:forEach items="${pb.result}" var="p" varStatus="i">
		   <c:if test="${i.count==1||i.count==7}">
		        <div class="row" style="width:1210px;margin:0 auto;">
		   </c:if>
		    <div class="col-md-2">
				<a href="${pageContext.request.contextPath}/FindProductByPid?pid=${p.pid}">
					<img src="${pageContext.request.contextPath}/${p.imageurl}" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="${pageContext.request.contextPath}/FindProductByPid?pid=${p.pid}" style='color:green'>${p.pname}</a></p>
				<p><font color="#FF0000">线上租价：&yen;${p.shop_price}</font></p>
			</div>
			<c:if test="${i.count==6||i.count==12||i.last}">
			     </div>
			</c:if>
		</c:forEach>
			
        

		<!--分页 -->
		<div style="width:380px;margin:0 auto;margin-top:50px;">
			<ul class="pagination" style="text-align:center; margin-top:10px;">
				
				
				  <c:if test="${pb.pageNumber==1}">
				       <li class="disabled"><a aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				  </c:if>
				  <c:if test="${pb.pageNumber!=1}">
				       <li><a href="${pageContext.request.contextPath}/FindProductByCategoryName?pageNumber=${pb.pageNumber-1}&cname=${cname}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				  </c:if>
				  <c:forEach begin="1" end="${pb.totalPage}" var="i">
				      <c:if test="${pb.pageNumber == i}">
				          <li class="active"><a href="#">${i}</a></li>
				      </c:if>
				      <c:if test="${pb.pageNumber!=i}">
				         <li><a href="${pageContext.request.contextPath}/FindProductByCategoryName?pageNumber=${i}&cname=${cname}">${i}</a></li>
				      </c:if>
				  </c:forEach>
				<c:if test="${pb.pageNumber==pb.totalPage}">
				<li class="disabled"><a aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				</c:if>
				<c:if test="${pb.pageNumber!=pb.totalPage}">
				<li><a href="${pageContext.request.contextPath}/FindProductByCategoryName?pageNumber=${pb.pageNumber+1}&cname=${cname}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				</c:if>
			</ul>
		</div>
		<!-- 分页结束=======================        -->

		<!--
       		商品浏览记录:
        -->
		<div style="width:1210px;margin:0 auto; padding: 0 9px;border: 1px solid #ddd;border-top: 2px solid #999;height: 246px;">

			<h4 style="width: 50%;float: left;font: 14px/30px " 微软雅黑 ";">浏览记录</h4>
			<div style="width: 50%;float: right;text-align: right;"><a href="">more</a></div>
			<div style="clear: both;"></div>
            
            
			<div style="overflow: hidden;">
               <c:forEach items="${linkedList}" var="linked" varStatus="i">
				<ul style="list-style: none;">
					<li style="width: 150px;height: 216;float: left;margin: 0 8px 0 0;padding: 0 18px 15px;text-align: center;"><img src="${pageContext.request.contextPath}/${linked}" width="130" height="130" style="display: inline-block;"/></li>
				</ul>
               </c:forEach>
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