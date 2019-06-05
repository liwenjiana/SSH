package com.bwie.dao;

import java.util.List;

import com.bwie.dto.Order;

public interface OrderDao {

	List<?> list();

	void deleteOrder(Order order);

	Order getOrderByOid(Order order);

	List<?> getGoodsList();

	void updateOrder(Order order);

	void addOrder(Order order);

	void updateStatus(Order order);

	void deleteMoreOrder(List<Order> list);

}
