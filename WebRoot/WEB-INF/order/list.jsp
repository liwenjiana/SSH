<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    <link rel="stylesheet" href="<%=path %>/css/index_work.css" type="text/css"></link>
    <script type="text/javascript" src="<%=path %>/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript">
    	/**
    		已支付的订单只能删除
    		未支付的订单可以修改和支付，但是不能删除
    		表示方式为该按钮在页面中被禁用，或者点击之后给出相应提示
    	*/
    	function deleteOrder(oid, status){
    		
    		location.href = "<%=path%>/order_deleteOrder.action?order.oid="+oid;
    	}
    	function updateOrder(oid, status){
    		
    		location.href = "<%=path%>/order_toUpdate.action?order.oid="+oid;
    	}
    	function payOrder(oid, status){
    		
    		location.href = "<%=path%>/order_payOrder.action?order.oid="+oid;
    	}
    	function addOrder(){
    		location.href = "<%=path%>/order_toAdd.action";
    	}
    </script>
  </head>
  
  <body>
  	<table>
  		<tr>
  			<th colspan="10">订单列表</th>
  		</tr>
  		<tr>
  			<th>订单编号</th>
  			<th>下单人</th>
  			<th>下单日期</th>
  			<th>支付方式</th>
  			<th>支付状态</th>
  			<th>订单总额</th>
  			<th>商品信息</th>
  			<th>操作<input type="button" value="添加" onclick="addOrder()" /></th>
  		</tr>
  		<c:forEach items="${orderList }" var="order">
  			<tr>
  				<td>${order.oid }</td>
  				<td>${order.oname }</td>
  				<td>${order.otime }</td>
  				<td>
					${order.payType == 0 ? "现金" : (order.payType == 1 ? "支付宝" : "微信") }  				
  					
  				</td>
  				<td>${order.status == 0 ? "未支付" : "已支付" }</td>
  				<td>${order.totalPrice }</td>
  				<td>
  					<c:forEach items="${order.goods }" var="goods" varStatus="status">
  						<c:if test="${status.index > 0 }">,</c:if>
  						${goods.gname }
  					</c:forEach>
  				</td>
  				<td>
  					<input type="button" value="删除" ${order.status == 0 ? "disabled='disabled'" : "" } onclick="deleteOrder(${order.oid}, ${order.status })" />
  					<input type="button" value="修改" ${order.status == 1 ? "disabled='disabled'" : "" } onclick="updateOrder(${order.oid}, ${order.status })" />
  					<input type="button" value="支付" ${order.status == 1 ? "disabled='disabled'" : "" } onclick="payOrder(${order.oid}, ${order.status })" />
  				</td>
  			</tr>
  		</c:forEach>
  	</table>
  </body>
</html>
