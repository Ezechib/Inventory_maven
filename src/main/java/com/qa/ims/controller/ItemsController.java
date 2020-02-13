package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

/**
 * Takes in item details for CRUD functionality
 *
 */

public class ItemsController implements CrudController<Items> {

	public static final Logger LOGGER = Logger.getLogger(ItemsController.class);

	private CrudServices<Items> ItemsService;

	public ItemsController(CrudServices<Items> itemsService) {

		this.ItemsService = itemsService;

	}

	public String getInput() {

		return Utils.getInput();	
	}

	/**
	 * Reads all customers to the logger
	 */

	@Override
	public List<Items> readAll() {





		List<Items> items = ItemsService.readAll();

		for (Items item : items) {

			LOGGER.info(item.toString());
		}

		return items;
	}



	/**
	 * Creates a customer by taking in user input
	 */



	public Items create() {





		LOGGER.info("Enter the item you require");

		String items_name = getInput();

		LOGGER.info("Please enter the item value");

		Double item_value = Double.valueOf(getInput());

		Items items = ItemsService.create(new Items(items_name, item_value));

		LOGGER.info("Item created");

		return items;
	}





	public Items update() {





		LOGGER.info("Please enter the ID of the item you would like to update");

		Long id = Long.valueOf(getInput());

		LOGGER.info("Please enter the item name");

		String Items_name = getInput();

		LOGGER.info("Please enter the new item value");

		Double Items_value = Double.valueOf(getInput());

		Items items = ItemsService.update(new Items(id, Items_name, Items_value));

		LOGGER.info("Item List Updated");
		return items;

	}
	public void delete() {





		LOGGER.info("Please enter the ID of the item you would like to delete");

		Long id = Long.valueOf(getInput());

		ItemsService.delete(id);
	}
}
