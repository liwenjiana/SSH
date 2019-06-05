package com.bwie.service;

import java.util.List;
import java.util.Map;

import com.bwie.dto.Order;

public interface OrderService {

	List<?> list();

	void deleteOrder(Order order);

	Map<String, Object> getData(Order order);

	void updateOrder(Order order);

	List<?> getGoodsList();

	void addOrder(Order order);

	Order getOrderByOid(Order order);

	void updateStatus(Order order);

	void deleteMoreOrder(List<Order> list);

}
