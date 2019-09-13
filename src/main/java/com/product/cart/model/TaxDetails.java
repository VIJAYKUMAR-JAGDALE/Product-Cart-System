package com.product.cart.model;

public class TaxDetails {
	private long productId;
	private long salesTax;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(long salesTax) {
		this.salesTax = salesTax;
	}

}
