package com.product.cart.model;

public class Product {

	private long productId;
	private String productName;
	private double price;
	private long quantity;
	
	private double productCost;
	private double taxableAmt;
	private double PayableAmt;
	
	private TaxDetails taxDetails;
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public TaxDetails getTaxDetails() {
		return taxDetails;
	}
	public void setTaxDetails(TaxDetails taxDetails) {
		this.taxDetails = taxDetails;
	}
	public double getProductCost() {
		return productCost;
	}
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	public double getTaxableAmt() {
		return taxableAmt;
	}
	public void setTaxableAmt(double taxableAmt) {
		this.taxableAmt = taxableAmt;
	}
	public double getPayableAmt() {
		return PayableAmt;
	}
	public void setPayableAmt(double payableAmt) {
		PayableAmt = payableAmt;
	}
	
}
