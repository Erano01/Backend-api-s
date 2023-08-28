package me.erano.backend.dto;


public class PurchaseResponse{
	
	private final String orderTrackingNumber;
	//lombok bize @data ile final field'lar için constructor verir

	public PurchaseResponse(String orderTrackingNumber) {
		super();
		this.orderTrackingNumber = orderTrackingNumber;
	}
	
	
	
}
