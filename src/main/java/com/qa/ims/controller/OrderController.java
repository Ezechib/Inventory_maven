package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

/**
 * Takes in Items details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order>{

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Order> orderService;

	public OrderController(CrudServices<Order> orderServices) {
		this.orderService = orderServices;
	}


	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all Items to the logger
	 */
	@Override

	public List<Order> readAll() {
		List<Order> orders = orderService.readAll();
		for(Order order: orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}



	/**
	 * Creates a Items by taking in user input
	 */

	public Order create() {
		LOGGER.info("Enter the new customer_id");
		Long customer_id = Long.valueOf(getInput());
		LOGGER.info("enter total_cost");
		Long total_cost = Long.valueOf(getInput());
		LOGGER.info("Enter the number_of_items");
		Long number_of_items = Long.valueOf(getInput());
		Order Orders = orderService.create(new Order(customer_id, total_cost, number_of_items));
		LOGGER.info("Items created");
		return Orders;
	}

	/**
	 * Updates an existing Items by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long order_id = Long.valueOf(getInput());
		LOGGER.info("Enter the new customer id");
		Long customer_id = Long.valueOf(getInput());
		LOGGER.info("Enter the new total cost");
		Long total_cost = Long.valueOf(getInput());
		LOGGER.info("Enter the number of items");
		Long number_of_items = Long.valueOf(getInput());
		Order orders = orderService.update(new Order(order_id ,customer_id, total_cost, number_of_items ));
		LOGGER.info("Order Updated");
		return orders;
	}

	/**
	 * Deletes an existing Items by the id of the Items
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the Items you would like to delete");
		Long user_id = Long.valueOf(getInput());
		orderService.delete(user_id);
		LOGGER.info("Item deleted");
	}



}