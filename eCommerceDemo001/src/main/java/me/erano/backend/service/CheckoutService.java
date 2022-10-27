package me.erano.backend.service;

import me.erano.backend.dto.Purchase;
import me.erano.backend.dto.PurchaseResponse;

public interface CheckoutService {

	PurchaseResponse placeOrder(Purchase purchase);
}
