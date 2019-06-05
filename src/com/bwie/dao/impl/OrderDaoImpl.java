package com.bwie.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bwie.dao.OrderDao;
import com.bwie.dto.Order;

@Repository
public class OrderDaoImpl implements OrderDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<?> list() {
		return hibernateTemplate.find("from Order");
	}
	
	public void deleteOrder(Order order) {
		hibernateTemplate.delete(order);
	}
	
	public Order getOrderByOid(Order order) {
		return hibernateTemplate.get(Order.class, order.getOid());
	}
	
	public List<?> getGoodsList() {
		return hibernateTemplate.find("from Goods");
	}
	
	public void updateOrder(Order order) {
		hibernateTemplate.update(order);
	}
	
	public void addOrder(Order order) {
		hibernateTemplate.save(order);
	}
	
	public void updateStatus(final Order order) {
		hibernateTemplate.execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery sqlQuery = session.createSQLQuery("update t_order set status = 1 where oid = " + order.getOid());
				int i = sqlQuery.executeUpdate();
				return i;
			}
		});
	}
	
	public void deleteMoreOrder(List<Order> list) {
		hibernateTemplate.deleteAll(list);
	}
}
