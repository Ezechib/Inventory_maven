package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Order;

public class OrderServices implements CrudServices<Order> {

	private Dao<Order> OrderDao;

	public OrderServices(Dao<Order> ItemsDao) {
		this.OrderDao = ItemsDao;
	}

	public List<Order> readAll() {
		return OrderDao.readAll();
	}

	public Order create(Order Orders) {
		return OrderDao.create(Orders);
	}

	public Order update(Order Orders) {
		return OrderDao.update(Orders);
	}

	public void delete(Long order_id) {
		OrderDao.delete(order_id);
	}

}
