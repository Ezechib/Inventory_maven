package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

	private Items items;
	private Items other;

	@Before
	public void setUp() {
		items = new Items(1L, "Mug",4.75);
		other = new Items(1L, "Mug", 4.75);
	}

//	@Test
//	public void settersTest() {
//		assertNotNull(items.getId());
//		assertNotNull(items.getItem_name());
//		assertNotNull(items.getItem_value());
//		
//		items.setId(null);
//		assertNull(items.getId());
//		items.setItem_name(null);
//		assertNull(items.getItem_name(),0);
//		items.setItem_value(null);
//		assertNull(items.getItem_value());
//		
//	}

	@Test
	public void equalsWithNull() {
		assertFalse(items.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(items.equals(new Object()));
	}

	@Test
	public void createitemsWithId() {
		assertEquals(1L, items.getId(), 0);
		assertEquals("Mug", items.getItem_name());
		assertEquals(4.75, items.getItem_value(),0);
	}

	@Test
	public void checkEquality() {
		assertTrue(items.equals(items));
	}

//	@Test
//	public void checkEqualityBetweenDifferentObjects() {
//		assertTrue(items.equals(other));
//	}

	@Test
	public void itemsNameNullButOtherNameNotNull() {
		items.setItem_name(null);
		assertFalse(items.equals(other));
	}

	@Test
	public void itemsNamesNotEqual() {
		other.setItem_name("");
		assertFalse(items.equals(other));
	}

//	@Test
//	public void checkEqualityBetweenDifferentObjectsNullItem_name() {
//		items.setItem_name(null);
//		other.setItem_name(null);
//		assertTrue(items.equals(other));
//	}

	@Test
	public void nullId() {
		items.setId(0);
		assertFalse(items.equals(other));
	}

//	@Test
//	public void nullIdOnBoth() {
//		items.setId(0);
//		other.setId(0);
//		assertTrue(items.equals(other));
//	}

	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(items.equals(other));
	}

	@Test
	public void nullItem_name() {
		items.setItem_name(null);
		assertFalse(items.equals(other));
	}

//	@Test
//	public void nullItem_nameOnBoth() {
//		items.setItem_name(null);
//		other.setItem_name(null);
//		assertTrue(items.equals(other));
//	}
//	
	@Test
	public void otherItem_nameDifferent() {
		other.setItem_name("Haggis");
		assertFalse(items.equals(other));
	}

//	@Test
//	public void constructorWithoutId() {
//		Items items = new Items("Mug",4.75);
//		assertNull(items.getId());
//		assertNotNull(items.getItem_name());
//		assertNotNull(items.getItem_value());
//	}

	@Test
	public void hashCodeTest() {
		assertEquals(items.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Items items = new Items(null, null);
		Items other = new Items(null, null);
		assertEquals(items.hashCode(), other.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "id:1 item_name:Mug item_value:4.75";
		assertEquals(toString, items.toString());
	}
}
