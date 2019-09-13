package com.product.cart.ProductPurchaseCart;

public class CalculatorUtils {

	public static double getProductCost(double price,long quantity){
		if(quantity!=0 && price!=0){
			return price*quantity;
		}
		return 0;
	}
	
	
}
