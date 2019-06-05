<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加订单信息</title>
    <link rel="stylesheet" href="<%=path %>/css/index_work.css" type="text/css"></link>
    <script type="text/javascript" src="<%=path %>/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="<%=path %>/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
    	$(function (){
    		$.post(
    			"<%=path%>/order_getGoodsList.action",
    			{},
    			function (obj){
    				for(var i in obj){
	    				$("#showGoods").append("<input type='checkbox' name='gid' value='"+obj[i].gid+"' />"+obj[i].gname);
    				}
    			},
    			"json"
    		);
    		
    		$("#btn").click(function (){
    			$.post(
    				"<%=path%>/order_addOrder.action",
    				$("form").serialize(),
    				function (){
    					alert("添加成功");
    					location.href = "<%=path%>/order_list.action";
    				},
    				"text"
    			);
    		});
    	});
    </script>
  </head>
  
  <body>
  	<form>
	  	<table>
	  		<tr>
	  			<th colspan="2">修改订单信息<input type="hidden" name="order.oid" /></th>
	  		</tr>
	  		<tr>
	  			<td>下单人</td>
	  			<td>
	  				<input type="text" name="order.oname" />
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>下单时间</td>
	  			<td>
	  				<input type="text" name="order.otime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>支付方式</td>
	  			<td>
	  				<input type="radio" name="order.payType" value="0" />现金
	  				<input type="radio" name="order.payType" value="1" />支付宝
	  				<input type="radio" name="order.payType" value="2" />微信
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>商品信息</td>
	  			<td id="showGoods"></td>
	  		</tr>
	  		<tr>
	  			<td colspan="2">
	  				<input type="button" value="提交" id="btn" />
	  			</td>
	  		</tr>
	  	</table>
  	</form>
  </body>
</html>
