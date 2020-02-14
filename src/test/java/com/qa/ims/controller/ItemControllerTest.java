package com.qa.ims.controller;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.ItemServices;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	/**
	 *  The thing I want to fake functionality for
	 */
	@Mock
	private ItemServices itemServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the item controller
	 */
	@Spy
	@InjectMocks
	private ItemsController itemsController;



	/**readAllTest is a test to determine whether the readAll function works
	 *
	 */


	@Test
	public void readAllTest() {
		ItemsController itemsController = new ItemsController(itemServices);
		List<Items> Items = new ArrayList<>();
		Items.add(new Items("Fanta", 1.99));
		Items.add(new Items("Robinson", 3.45));
		Items.add(new Items("Coffee", 3.69));
		Mockito.when(itemServices.readAll()).thenReturn(Items);
		assertEquals(Items, itemsController.readAll());
	}

	/**createTest is a test to determine whether a customer can be created and inserted into the database
	 *
	 */

//	@Test
//	public void createTest() {
//		String item_name = "Mug";
//		Double item_value = 7.29;
//		Mockito.doReturn(item_name, item_value).when(itemsController).getInput();
//		Items items = new Items(item_name, item_value);
//		Items savedItems = new Items(1L, "Mug", 7.29);
//		Mockito.when(itemServices.create(items)).thenReturn(savedItems);
//		assertEquals(savedItems, itemsController.create());
//	}

	/**updateTest searches whether the update function has the functionality to update a customer in the database
	 *
	 */

//	@Test
//	public void updateTest() {
//		String item_name = "Fork";
//		Double item_value = 1.29;
//		Mockito.doReturn(item_name, item_value).when(itemsController).getInput();
//		Items items = new Items(1L, item_name, item_value);
//		Mockito.when(itemServices.update(items)).thenReturn(items);
//		assertEquals(items, itemsController.update());
//	}


	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(itemsController).getInput();
		itemsController.delete();
		Mockito.verify(itemServices, Mockito.times(1)).delete(1L);
	}

}