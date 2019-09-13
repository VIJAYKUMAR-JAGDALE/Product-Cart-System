package com.product.cart.ProductPurchaseCart;

import java.util.ArrayList;
import java.util.List;

import com.product.cart.input.reader.JSONReader;
import com.product.cart.model.Product;

public class CartBillGenerator extends TaxCalculator{

	private List<Product> productList=new ArrayList<Product>();
	
	/**
	 * constructor to read products from json file and create list 
	 * of products  
	 */
	public CartBillGenerator(){
		   JSONReader reader=new JSONReader();
	       reader.getProductDetailsFromJSON().forEach(product->{
	    	   productList.add(setAmountValues(product));
	    	   
	       }); 
	}

	/**
	 * @author Vijaykumar Jagdale
	 * method to generate bill depending on products list
	 */
	public void generateBill() {
		System.out
				.println("| Product Name | Product Price | Product Quantity | Product Cost | Sales Tax Paid | Payable Amount |");
		System.out
				.println("=================================================================================================");
		getProductList().stream().forEach(
				product -> {
					System.out.println("| "
							+ product.getProductName()
							+ " | "
							+ product.getPrice()
							+ " | "
							+ product.getQuantity()
							+ " | "
							+ product.getProductCost()
							+ " | "
							+ product.getTaxableAmt()
							+ " | "
							+ product.getPayableAmt()
							+ " | "
							);
				});
		System.out
				.println("=================================================================================================");
		System.out.println("                 Total Amount Payable:"
				+ productList.stream().mapToDouble(x -> x.getPayableAmt()).sum());

	}
	/**
	 * @return List<Product>
	 */
	public List<Product> getProductList() {
		return productList;
	}
	
	/**
	 * @param productList
	 */
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	/**
	 * @author Vijaykumar Jagdale
	 * method to get values of amount and set it to model object of product
	 * @param product
	 * @return Product
	 */
	private Product setAmountValues(Product product){
		final double productCost=CalculatorUtils.getProductCost(product.getPrice(),product.getQuantity());		
		product.setProductCost(productCost);
		
		final double taxableAmt=getSalesTax(product.getTaxDetails().getSalesTax(),productCost);
		product.setTaxableAmt(taxableAmt);
		product.setPayableAmt(product.getProductCost()+product.getTaxableAmt());
		
		return product;
	}
}
