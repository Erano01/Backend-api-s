package me.erano.backend.dto;

import lombok.Data;

@Data
public class PurchaseResponse{
	
	private final String orderTrackingNumber;
	//lombok bize @data ile final field'lar için constructor verir
	
}
