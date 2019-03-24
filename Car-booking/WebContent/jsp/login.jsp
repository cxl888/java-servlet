<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head></head>
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
<%
     //记住用户名
     String uN=null;
     //String pWD=null;
     Cookie c[]=request.getCookies();
     if(c!=null){
          for(int i=0;i<c.length;i++)
          {
	            if(c[i].getName().equals("u")){
		           uN=c[i].getValue().split("-")[0];
		         //pWD=c[i].getValue().split("-")[1];
	             }
          }
     }
     if(uN==null)
	    uN="";
     /*if(pWD==null)
	     pWD="";*/
%>

	<!-- 引入header.jsp文件即可拥有网站的头信息 -->
		<%@include file="header.jsp"%>

	
<div class="container"  style="width:100%;height:460px;background:#000000 url('${pageContext.request.contextPath}/images/loginbg2.jpg') no-repeat;">
<div class="row"> 
	<div class="col-md-7">
		<!--<img src="${pageContext.request.contextPath}/image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
	</div>
	
	<div class="col-md-5">
				<div style="width:440px;border:1px solid #E7E7E7;padding:20px 0 20px 30px;border-radius:5px;margin-top:40px;background:#fff;margin-left:80px;">
				<font>会员登录</font>USER LOGIN 
				<div style="color:blue;font-size:20px;">${msg}</div>
				
<!-- ！！！！！！！！！！！！！！！！！！！！！！！！form表单在这里！！！！！！！！！！！！！！！！！！！！！-->
					<form class="form-horizontal" name="form1"
						action="${pageContext.request.contextPath }/LoginServlet" method="post">
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="username"
									placeholder="请输入用户名" name="username" value="<%=uN%>">   
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
							<div class="col-sm-6">
								<input type="password" class="form-control" id="inputPassword3"
									placeholder="请输入密码" name="password">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">验证码</label>
							<div class="col-sm-6">
							     <input type="text" class="form-control" id="checkcode"
									placeholder="请输入验证码" name="code"><br>
							     <img id="code" src="${pageContext.request.contextPath}/ImageAction">
							     <br>
							     <br>
                                 <input type="submit" value="看不清，换一张" onclick="form1.action='${pageContext.request.contextPath}/ChangImage'">
                                 
						    </div>
						</div>	
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									<label> <input type="checkbox" name="r1" value="1"> 自动登录
									</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label> <input
										type="checkbox" name="r2" value="1" checked="checked"> 记住用户名
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" width="100" value="登录" name="submit"
									border="0"
									style="background: url('${pageContext.request.contextPath}/images/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
    height:35px;width:100px;color:white;">
							</div>
						</div>
					</form>
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
			Copyright &copy; 20017-2018  版权所有
		</div>
</body></html>