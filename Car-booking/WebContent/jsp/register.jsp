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
    <script type="text/javascript">
          function  checkform(){
        	  //var n=document.getElementById("username").value;
        	  
        	  var checkArray=new Array();
        	  var warningArray=new Array();
        	  warningArray[0]=" 用户名!";
        	  warningArray[1]=" 密码!";
        	  warningArray[2]=" E-mail!";
        	  warningArray[3]=" 姓名!";
        	  warningArray[4]=" 性别!";
        	  warningArray[5]=" 出生日期!";
        	  var sexvalue="";
        	  var radio=document.getElementsByName("sex");
        	  
        	  for(var j=0;j<radio.length;j++)
        	  {
        			if(radio[j].checked==true)
        			{
        			  sexvalue=radio[j].value;
        			  break;
        			}
        	  }
        	  
        	  checkArray[0]=document.getElementById("username").value;
        	  checkArray[1]=document.getElementById("inputPassword3").value;
        	  checkArray[2]=document.getElementById("inputEmail3").value;
        	  checkArray[3]=document.getElementById("usercaption").value;
        	  checkArray[4]=sexvalue;
        	  checkArray[5]=document.getElementById("birthday").value;
        	  for(var i=0;i<6;i++)
        	  {
        		 if(checkArray[i]==null||checkArray[i]==""){
            	             alert("请输入完整信息!"+warningArray[i]);
            		         return false;}     
        	  }
        	  
        	  /*if(n==null||n==""){
        	      alert("请输入用户名!");
        		  return false;
        	  }*/
        	  return true;
          }
    </script>
	</head>
<body>
		<!-- 引入header.jsp文件即可拥有网站的头信息 -->
		<%@include file="header.jsp"%>
		
		<div class="col-md-12" style="width:100%;background:url('${pageContext.request.contextPath}/images/regist_bg.jpg');">
			<div class="col-md-2"></div>
			<div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px 30px 20px 45px ;border:7px solid #ccc;width:70%">
				<font>会员注册</font>USER REGISTER
		<!-- ！！！！！！！！！！！！！！！！！！！！！！！！form表单在这里！！！！！！！！！！！！！！！！！！！！！ -->
				<form class="form-horizontal" style="margin-top:5px;" method="post" action="${pageContext.request.contextPath}/RegisterServlet" onsubmit="return checkform()">
					 <div class="form-group">
					    <label for="username" class="col-sm-2 control-label">用户名</label>
					    <div class="col-sm-6">
					      <input type="text" class="form-control" id="username" placeholder="请输入用户名" name="username">
					    </div>
					  </div>
					   <div class="form-group">
					    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					    <div class="col-sm-6">
					      <input type="password" class="form-control" id="inputPassword3" placeholder="请输入密码" name="password">
					    </div>
					  </div>
					   <div class="form-group">
					    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
					    <div class="col-sm-6">
					      <input type="password" class="form-control" id="confirmpwd" placeholder="请输入确认密码">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
					    <div class="col-sm-6">
					      <input type="email" class="form-control" id="inputEmail3" placeholder="Email" name="email">
					    </div>
					  </div>
					 <div class="form-group">
					    <label for="usercaption" class="col-sm-2 control-label">姓名</label>
					    <div class="col-sm-6">
					      <input type="text" class="form-control" id="usercaption" placeholder="请输入姓名" name="realname">
					    </div>
					  </div>
					  <div class="form-group opt">  
					  <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>  
					  <div class="col-sm-6">
					    <label class="radio-inline">
					  <input type="radio" name="sex" id="inlineRadio1" value="1"> 男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="sex" id="inlineRadio2" value="0"> 女
					</label>
					</div>
					  </div>		
					  <div class="form-group">
					    <label for="date" class="col-sm-2 control-label">出生日期</label>
					    <div class="col-sm-6">
					      <input type="date" class="form-control"  name="birthday" id="birthday">		      
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <input type="submit"  width="100" value="注册" name="submit" border="0"
						    style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						    height:35px;width:100px;color:white;">
					    </div>
					  </div>
				</form>
			</div>
		<div class="col-md-2"></div>
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




