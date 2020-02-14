package com.qa.ims.persistence.domain;

public class Order {

	private Long order_id;
	private Long customer_id;
	private Long total_cost;
	private Long number_of_items;

	public Order(long customer_id, long total_cost, long number_of_items) {
		this.customer_id = customer_id;
		this.total_cost = total_cost;
		this.number_of_items = number_of_items;

	}

	public Order(long order_id, long customer_id, long total_cost, long number_of_items) {
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.total_cost = total_cost;
		this.number_of_items = number_of_items;
	}



	public long getOrder_Id() {
		return order_id;
	}

	public void setOrder_Id(long order_id) {
		this.order_id = order_id;
	}

	public long getCustomer_Id() {
		return customer_id;
	}

	public void setCustomer_id(String order_id) {
		this.order_id = customer_id;
	}

	public long getTotal_Cost() {
		return total_cost;
	}
	public void setTotal_Cost(long total_cost) {
		this.total_cost = total_cost;
	}
	public long getNumber_Of_Items() {
		return number_of_items;
	}
	public void setNumber_Of_Items(long total_cost) {
		this.number_of_items = total_cost;
	}


	public Order(long total_cost) {
		this.total_cost = total_cost;
	}

	public Order(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

	public Order(String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}

	public Order(long l, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "order_id:" + order_id + " customer_id:" + customer_id + " total cost:" + total_cost + " number_of_items:" + number_of_items;
	}
	@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
	result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
	result = prime * result + ((total_cost == null) ? 0 : total_cost.hashCode());
	result = prime * result + ((number_of_items == null) ? 0 : number_of_items.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Order other = (Order) obj;
	if (order_id == null) {
		if (other.order_id != null)
			return false;
	} else if (!order_id.equals(other.order_id))
		return false;
	if (order_id == null) {
		if (other.order_id != null)
			return false;
	} else if (!order_id.equals(other.order_id))
		return false;
	if (total_cost == null) {
		if (other.total_cost != null)
			return false;
	} else if (!total_cost.equals(other.total_cost))
		return false;
	if (number_of_items == null) {
		if (other.number_of_items != null)
			return false;
	} else if (!number_of_items.equals(other.number_of_items))
		return false;
	return true;
}
}
