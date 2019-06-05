package com.bwie.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwie.dao.OrderDao;
import com.bwie.dto.Order;
import com.bwie.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao dao;
	
	public List<?> list() {
		return dao.list();
	}
	
	public void deleteOrder(Order order) {
		dao.deleteOrder(order);
	}
	
	public Map<String, Object> getData(Order order) {
		Map<String, Object> map = new HashMap<String, Object>();
		Order o = dao.getOrderByOid(order);
		List<?> goodsList = dao.getGoodsList();
		map.put("o", o);
		map.put("goodsList", goodsList);
		return map;
	}
	
	public void updateOrder(Order order) {
		dao.updateOrder(order);
	}
	
	public List<?> getGoodsList() {
		return dao.getGoodsList();
	}
	
	public void addOrder(Order order) {
		dao.addOrder(order);
	}
	
	public Order getOrderByOid(Order order) {
		return dao.getOrderByOid(order);
	}
	
	public void updateStatus(Order order) {
		dao.updateStatus(order);
	}
	
	public void deleteMoreOrder(List<Order> list) {
		dao.deleteMoreOrder(list);
	}
	
}
