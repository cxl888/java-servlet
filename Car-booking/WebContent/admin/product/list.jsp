<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" /> 
		
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
			function addProduct(){
				window.location.href = "${pageContext.request.contextPath}/Dynamic_category";
			}
			function Confrimdel(pid){
				   var v=confirm("确定删除该商品吗?");
				   if(v){
					   window.location.href="${pageContext.request.contextPath}/DelProductByPid?pid="+pid;
				   }
			   }
		</script>
		<style type="text/css">
		   li{float:left;list-style:none;}
		</style>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/product/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>车辆列表</strong>
						</td>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addProduct()">
&#28155;&#21152;
</button>

						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="18%">
										序号
									</td>
									
									<td align="center" width="17%">
										车辆名称
									</td>
									<td align="center" width="17%">
										市场租价
									</td>
									<td align="center" width="17%">
										线上租价
									</td>
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										删除
									</td>
								</tr>
								<c:forEach items="${pb.result}" var="p" varStatus="i">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												${p.pid}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.pname}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.market_price}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.shop_price}
											</td>
											
											<td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/Dynamic_category_2?pid=${p.pid}&pname=${p.pname}&rank=${p.rank}&market_price=${p.market_price}&shop_price=${p.shop_price}&oil=${p.oil}&displacement=${p.displacement}&pdesc=${p.pdesc}">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
									
											<td align="center" style="HEIGHT: 22px">
												
												<a href="javascript:Confrimdel(${p.pid});">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
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
				       <li><a href="${pageContext.request.contextPath}/FindAllProductServlet?pageNumber=${pb.pageNumber-1}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				  </c:if>
				  <c:forEach begin="1" end="${pb.totalPage}" var="i">
				      <c:if test="${pb.pageNumber == i}">
				          <li class="active"><a href="#">${i}</a></li>
				      </c:if>
				      <c:if test="${pb.pageNumber!=i}">
				         <li><a href="${pageContext.request.contextPath}/FindAllProductServlet?pageNumber=${i}">${i}</a></li>
				      </c:if>
				  </c:forEach>
				<c:if test="${pb.pageNumber==pb.totalPage}">
				<li class="disabled"><a aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				</c:if>
				<c:if test="${pb.pageNumber!=pb.totalPage}">
				<li><a href="${pageContext.request.contextPath}/FindAllProductServlet?pageNumber=${pb.pageNumber+1}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				</c:if>
			</ul>
		</div>
		<!-- 分页结束=======================        --></center>	
	</body>
</HTML>

