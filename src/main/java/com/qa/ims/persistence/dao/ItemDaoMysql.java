package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Items;

public class ItemDaoMysql implements Dao<Items>{

	public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public ItemDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.239.193.215:3306/projectdb";
		this.username = username;
		this.password = password;
	}

	public ItemDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;

	}	

	Items itemFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		String item_name = resultSet.getString("item_name");
		Double item_value = resultSet.getDouble("item_value");
		return new Items(id,item_name, item_value);
	}

	/**
	 * Reads all the items from the database
	 *
	 * The function (@return) retrieves the list of items and their value from the database
	 */





	@Override
	public List<Items> readAll() {



	try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
	    Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from Items");) {

		ArrayList<Items>item = new ArrayList<>();
		while (resultSet.next()) {
			item.add(itemFromResultSet(resultSet));
		}
		return item;
	} catch (SQLException e) {
		LOGGER.debug(e.getStackTrace());
		LOGGER.error(e.getMessage());
	}
	return new ArrayList<>();

}	



	/**
	 * Creates an item in the database
	 *
	 * @param item - takes in a item object. id will be ignored
	 */
	@Override	

	public Items create(Items item) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into Items(item_name, item_value) values('" + item.getItem_name()
					+ "','" + item.getItem_value() + "')");
			
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}	





	public Items readItems(Long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT FROM Items where id = " + id);) {
			resultSet.next();
			return itemFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;

	}

	/**
	 * Updates a customer in the database
	 *
	 * @param customer - takes in a customer object, the id field will be used to
	 *                 update that customer in the database
	 * @return
	 */

	@Override

	public Items update(Items item) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update Items set item_name ='" + item.getItem_name() + "', item_value ='"
					+ item.getItem_value()+ "' where id =" + item.getId());
			return readItems(item.getId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a customer in the database
	 *
	 * @param id - id of the customer
	 */



	@Override

	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from Items where id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}









	}