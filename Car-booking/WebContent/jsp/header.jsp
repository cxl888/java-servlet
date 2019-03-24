<%@ page language="java" import="java.util.*,cn.itcast.demo02_service.CategoryService,cn.itcast.demo03_serviceImpl.CategoryServiceImpl,cn.itcast.demo06_domain.Category" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<!--
            	描述：菜单栏(c 标签)
            -->

            <%
                CategoryService cs=new CategoryServiceImpl();
                List<Category> cname_list=cs.findAllCategory();
                request.setAttribute("cname_list", cname_list);
            %>
			<div class="container-fluid">
				<div class="col-md-4" style="color:#CC0000" >
					<img src="${pageContext.request.contextPath}/img/logo3.png" />
					&nbsp;&nbsp;&nbsp;&nbsp;租车网
				</div>
				<div class="col-md-5">
					<img src="${pageContext.request.contextPath}/img/header2.png" />
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
					<c:if test="${not empty user}">
					
					    <li>欢迎您:${user.username}</li>
					    <li><a href="${pageContext.request.contextPath}/jsp/cart.jsp">购物车</a></li>
					    <li><a href="${pageContext.request.contextPath}/FindAllOrdersByUserServlet">订单</a></li>
					    <li><a href="${pageContext.request.contextPath}/LogoutServlet">退出</a></li>
					</c:if>
					<c:if test="${empty user}">
					    <li><a href="${pageContext.request.contextPath}/jsp/login.jsp">登录</a></li>
						<li><a href="${pageContext.request.contextPath}/jsp/register.jsp">注册</a></li>
					</c:if>
					
						
						
					</ol>
				</div>
			</div>
			<!--
            	描述：导航条
            -->
            <div>
			<div class="container-fluid">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="${pageContext.request.contextPath}/FindProductByCategoryName">首页</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
							    <c:forEach items="${cname_list}" var="cnl" varStatus="i">
							    <li><a href="${pageContext.request.contextPath}/FindProductByCategoryName?cname=${cnl.cname}">${cnl.cname}</a></li>
							    </c:forEach>
								
								
								
							</ul>
							<form class="navbar-form navbar-right" role="search" action="${pageContext.request.contextPath}/FindProductBySearchName" method="post">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Search" name="search">
								</div>
								<button type="submit" class="btn btn-default">Submit</button>
							</form>

						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>
		</div>