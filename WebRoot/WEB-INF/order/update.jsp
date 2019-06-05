<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改订单信息</title>
    <link rel="stylesheet" href="<%=path %>/css/index_work.css" type="text/css"></link>
    <script type="text/javascript" src="<%=path %>/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="<%=path %>/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
    	$(function (){
    		var oid = "${order.oid}";
    		$.post(
    			"<%=path%>/order_getData.action",
    			{"order.oid":oid},
    			function (obj){
    				var o = obj.o;
    				var goodsList = obj.goodsList;
    				var goods = o.goods;
    				for(var i in goodsList){
	    				$("#showGoods").append("<input type='checkbox' name='gid' value='"+goodsList[i].gid+"' />"+goodsList[i].gname);
    				}
    				$("[name='order.oid']").val(oid);
    				$("[name='order.oname']").val(o.oname);
    				$("[name='order.otime']").val(o.otime);
    				$("[name='order.payType'][value='"+o.payType+"']").attr("checked", true);
    				$("[name='order.status'][value='"+o.status+"']").attr("checked", true);
    				for(var i in goods){
	    				$("[name='gid'][value='"+goods[i].gid+"']").attr("checked", true);
    				}
    			},
    			"json"
    		);
    		
    		$("#btn").click(function (){
    			$.post(
    				"<%=path%>/order_updateOrder.action",
    				$("form").serialize(),
    				function (){
    					alert("修改成功");
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
	  			<td>支付状态</td>
	  			<td>
	  				<input type="radio" name="order.status" value="0" />未支付
	  				<input type="radio" name="order.status" value="1" />已支付
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
