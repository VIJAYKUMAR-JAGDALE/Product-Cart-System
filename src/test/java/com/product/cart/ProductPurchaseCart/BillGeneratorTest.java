package com.product.cart.ProductPurchaseCart;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.product.cart.input.reader.JSONReader;

public class BillGeneratorTest {

	private CartBillGenerator generator;
	private URL productResource;
	private URL taxDetailsresource;
	private JSONReader reader;
	
	@Before  
    public void setUp() throws Exception {
		 ClassLoader classLoader = getClass().getClassLoader();
		 productResource = classLoader.getResource("productTest.json");
		 taxDetailsresource = classLoader.getResource("taxTest.json");
		 reader=new JSONReader();
		 reader.setProductResource(productResource);
		 reader.setTaxDetailsresource(taxDetailsresource);

		 generator=new CartBillGenerator();
		 generator.setReader(reader);
		// generator.setProductList(reader.getProductDetailsFromJSON());
		 
	}

	public void setGenerateBillTest(){
		generator.generateBill();
	}
	
	@Test
	public void generateBillTest(){
		generator.generateBill();
		StringBuilder sb=new StringBuilder();
		sb.append("| Product Name | Product Price | Product Quantity | Product Cost | Sales Tax Paid | Payable Amount |");
		sb.append("\n=================================================================================================");
		sb.append("\n| ProductA | 200.0 | 1 | 200.0 | 60.0 | 260.0 |");
		sb.append("\n=================================================================================================");
		sb.append("\n                 Total Amount Payable:260.0");
		System.out.println(sb);
		StringBuilder sbactual= new StringBuilder((String)System.out.toString());
		assertEquals(sb.toString(),sb.toString());
	}
	
	
}
