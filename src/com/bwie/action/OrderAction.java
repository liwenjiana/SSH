package com.bwie.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bwie.dto.Goods;
import com.bwie.dto.Order;
import com.bwie.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class OrderAction extends ActionSupport{

	@Autowired
	private OrderService service;
	private List<?> orderList;
	private Order order;
	private String gid;
	
	public String list(){
		orderList = service.list();
		return "list";
	}
	
	public String deleteOrder() {
		service.deleteOrder(order);
		return SUCCESS;
	}
	
	public String toUpdate() {
		return "update";
	}
	
	public void getData() throws Exception {
		Map<String, Object> map = service.getData(order);
		String json = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
	}
	
	public void updateOrder() {
		Set<Goods> goods = new HashSet<Goods>();
		String[] gids = gid.split(", ");
		for (String s : gids) {
			goods.add(new Goods(Integer.parseInt(s)));
		}
		order.setGoods(goods);
		service.updateOrder(order);
	}
	
	public String toAdd() {
		return "add";
	}
	
	public void getGoodsList() throws Exception {
		List<?> list = service.getGoodsList();
		String json = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
	}
	
	public void addOrder() {
		Set<Goods> goods = new HashSet<Goods>();
		String[] gids = gid.split(", ");
		for (String s : gids) {
			goods.add(new Goods(Integer.parseInt(s)));
		}
		order.setGoods(goods);
		service.addOrder(order);
	}
	
	public String payOrder() {
		/**
		 * 1、现将要修改的订单信息查询，在进行修改支付状态
		 */
		/*Order o = service.getOrderByOid(order);
		o.setStatus(1);
		service.updateOrder(o);*/
		/**
		 * 2、实现自定义修改
		 */
		service.updateStatus(order);
		return SUCCESS;
	}
	
	public String deleteMoreOrder() {
		List<Order> list = new ArrayList<Order>();
		String oids = "1, 2";
		String[] ss = oids.split(", ");
		for (String s : ss) {
			list.add(new Order(Integer.parseInt(s)));
		}
		service.deleteMoreOrder(list);
		return SUCCESS;
	}

	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++
	 */
	public List<?> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<?> orderList) {
		this.orderList = orderList;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}
}
