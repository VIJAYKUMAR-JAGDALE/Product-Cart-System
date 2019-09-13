package com.product.cart.ProductPurchaseCart;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TaxCalculatorTest {
	
	@InjectMocks
	TaxCalculator taxCalculator;	
	
	long percentage;
	double productCost;
	
	@Before  
    public void setUp() throws Exception { 
		percentage=10;
		productCost=200;
	}
	
	@Test
	public void getSalesTaxTest(){
		double taxAmt=taxCalculator.getSalesTax(percentage,productCost);
		assertEquals(20.0,taxAmt,0.0); 
	}

}
