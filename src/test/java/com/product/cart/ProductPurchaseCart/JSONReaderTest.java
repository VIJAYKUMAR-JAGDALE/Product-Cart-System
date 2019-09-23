package com.product.cart.ProductPurchaseCart;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.product.cart.input.reader.JSONReader;
import com.product.cart.model.Product;
import com.product.cart.model.TaxDetails;

public class JSONReaderTest {

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
	}

	@Test
	public void getProductListTest(){
		List<Product> productList=reader.getProductDetailsFromJSON();
        Product p=productList.get(0);
        assertEquals("ProductA",p.getProductName()); 
        assertEquals(1,p.getQuantity()); 
        assertEquals(200,p.getPrice(),0.0); 
        assertEquals(1,p.getProductId());
	}
	
	@Test
	public void getTaxDetailsTest(){
		List<Product> productList=reader.getProductDetailsFromJSON();
	    TaxDetails taxDetailsExpected=new TaxDetails();
	     taxDetailsExpected.setProductId(1);
	     taxDetailsExpected.setSalesTax(30);
		 
	     TaxDetails taxDetails=productList.get(0).getTaxDetails();
	     assertEquals(taxDetailsExpected.getProductId(),taxDetails.getProductId());
	     assertEquals(taxDetailsExpected.getSalesTax(),taxDetails.getSalesTax());
	}
}
