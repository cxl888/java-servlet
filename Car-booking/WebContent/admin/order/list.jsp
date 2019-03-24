<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
			function showDetail(oid){
				var but = document.getElementById("but"+oid);
				var div1 = document.getElementById("div"+oid);
				if(but.value == "订单详情"){
					// 1.创建异步对象
					var xhr = createXmlHttp();
					// 2.设置监听
					xhr.onreadystatechange = function(){
						if(xhr.readyState == 4){
							if(xhr.status == 200){
								
								div1.innerHTML = xhr.responseText;
							}
						}
					}
					// 3.打开连接
					xhr.open("GET","${pageContext.request.contextPath}/adminOrder_findOrderItem.action?oid="+oid+"&time="+new Date().getTime(),true);
					// 4.发送
					xhr.send(null);
					but.value = "关闭";
				}else{
					div1.innerHTML = "";
					but.value="订单详情";
				}
				
			}
			function createXmlHttp(){
				   var xmlHttp;
				   try{ // Firefox, Opera 8.0+, Safari
				        xmlHttp=new XMLHttpRequest();
				    }
				    catch (e){
					   try{// Internet Explorer
					         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
					      }
					    catch (e){
					      try{
					         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
					      }
					      catch (e){}
					      }
				    }

					return xmlHttp;
				 }
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/order/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>租单列表</strong>
						</TD>
					</tr>
					
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="10%">
										用户序号
									</td>
									<td align="center" width="10%">
										租单编号
									</td>
									<td align="center" width="10%">
										租单时间
									</td>
									<td align="center" width="10%">
										租车人
									</td>
									<td align="center" width="10%">
										租单状态
									</td>
									<td align="center" width="50%">
										租单详情
									</td>
								</tr>
									<!--  <s:iterator var="o" value="pageBean.list" status="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												<s:property value="#status.count"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#o.oid"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#o.total"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#o.name"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:if test="#o.state==1">
													未付款
												</s:if>
												<s:if test="#o.state==2">
													<a href="${ pageContext.request.contextPath }/adminOrder_updateState.action?oid=<s:property value="#o.oid"/>"><font color="blue">发货</font></a>
												</s:if>
												<s:if test="#o.state==3">
													等待确认收货
												</s:if>
												<s:if test="#o.state==4">
													订单完成
												</s:if>
											
											</td>
											<td align="center" style="HEIGHT: 22px">
												<input type="button" value="订单详情" id="but<s:property value="#o.oid"/>" onclick="showDetail(<s:property value="#o.oid"/>)"/>
												<div id="div<s:property value="#o.oid"/>">
													
												</div>
											</td>
							
										</tr>
									</s:iterator>	-->
									<c:forEach items="${pb.result}" var="o" varStatus="i">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												${o.uid}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${o.oid}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${o.ordertime}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${o.name}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:set var="status" scope="session" value="${o.orderstatus}"/>
												<c:if test="${status==1}">
													未付款
												</c:if>
												<c:if test="${status==2}">
													已付款，请派车
												</c:if>
												<c:if test="${status==3}">
													已派车，用户已确认
												</c:if>
												
											</td>
											<td align="center" style="HEIGHT: 22px">
												<!-- <a href="${ pageContext.request.contextPath }/Dynamic_category_2?pid=${p.pid}&pname=${p.pname}&rank=${p.rank}&market_price=${p.market_price}&shop_price=${p.shop_price}&oil=${p.oil}&displacement=${p.displacement}&pdesc=${p.pdesc}"> -->
												<a href="${ pageContext.request.contextPath }/DetailOrders?oid=${o.oid}&totalmoney=${o.totalmoney}&ordertime=${o.ordertime}&orderstatus=${o.orderstatus}&name=${o.name}&phone=${o.phone}&address=${o.address}&uid=${o.uid}">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
											
										</tr>
									</c:forEach>
							</table>
						</td>
					</tr>
					
				</TBODY>
			</table>
		</form>
		<!--分页 -->
		<div style="width:380px;margin:0 auto;margin-top:50px;">
		<center><ul class="pagination" style="text-align:center; margin-top:10px;">
				
				
				  <c:if test="${pb.pageNumber==1}">
				       <li class="disabled"><a aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				  </c:if>
				  <c:if test="${pb.pageNumber!=1}">
				       <li><a href="${pageContext.request.contextPath}/FindAllOrdersServlet?pageNumber=${pb.pageNumber-1}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				  </c:if>
				  <c:forEach begin="1" end="${pb.totalPage}" var="i">
				      <c:if test="${pb.pageNumber == i}">
				          <li class="active"><a href="#">${i}</a></li>
				      </c:if>
				      <c:if test="${pb.pageNumber!=i}">
				         <li><a href="${pageContext.request.contextPath}/FindAllOrdersServlet?pageNumber=${i}">${i}</a></li>
				      </c:if>
				  </c:forEach>
				<c:if test="${pb.pageNumber==pb.totalPage}">
				<li class="disabled"><a aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				</c:if>
				<c:if test="${pb.pageNumber!=pb.totalPage}">
				<li><a href="${pageContext.request.contextPath}/FindAllOrdersServlet?pageNumber=${pb.pageNumber+1}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				</c:if>
			</ul>
		</div>
		<!-- 分页结束=======================        --></center>	
	</body>
</HTML>

