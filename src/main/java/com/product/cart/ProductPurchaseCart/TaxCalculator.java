package com.product.cart.ProductPurchaseCart;

public class TaxCalculator {

	public double getSalesTax(long salesTaxPercent,double productCost){
		
		return (productCost*salesTaxPercent)/100;
	}
}
