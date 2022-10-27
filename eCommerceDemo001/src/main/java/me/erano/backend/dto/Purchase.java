package me.erano.backend.dto;

import java.util.Set;

import lombok.Data;
import me.erano.backend.entity.Address;
import me.erano.backend.entity.Customer;
import me.erano.backend.entity.Order;
import me.erano.backend.entity.OrderItem;

@Data
public class Purchase {

	private Customer customer;
	
	private Address shippingAddress;
	
	private Address billingAddress;
	
	private Order order;
	
	private Set<OrderItem> orderItems;
	
	
	
	
}






