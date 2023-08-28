package me.erano.backend.service;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.erano.backend.dao.CustomerRepository;
import me.erano.backend.dto.Purchase;
import me.erano.backend.dto.PurchaseResponse;
import me.erano.backend.entity.Customer;
import me.erano.backend.entity.Order;
import me.erano.backend.entity.OrderItem;

@Service
public class CheckoutServiceImpl implements CheckoutService{
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		
		//retrieve the order info from dto
			
		Order order= purchase.getOrder();
		
		//generate tracking number
		
		String orderTrackingNumber = generateOrderTrackingNumber();
		
		order.setOrderTrackingNumber(orderTrackingNumber);
		
		//populate order with orderItems
		Set<OrderItem> orderItems = purchase.getOrderItems();
		
		orderItems.forEach(item -> order.add(item));
		
		//populate order with billingAddress and shippingAddress
		
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());
		
		
		//populate customer with order
		
		Customer customer = purchase.getCustomer();
		customer.add(order);
		
		//save to the database
		
		customerRepository.save(customer);
		
		//return a response
		return new PurchaseResponse(orderTrackingNumber);
	}
	
	
	private String generateOrderTrackingNumber(){
		
		//generate a random UUID number (UIID version-4)
		//For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
		
		return UUID.randomUUID().toString();
		
	}
	
}















