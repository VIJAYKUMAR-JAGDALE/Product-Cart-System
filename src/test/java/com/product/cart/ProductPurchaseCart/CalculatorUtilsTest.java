package com.product.cart.ProductPurchaseCart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorUtilsTest {
	
	@InjectMocks
	CalculatorUtils util;
	
	double price;
	long quantity;
	
	@Before  
    public void setUp() throws Exception { 
		price=100;
		quantity=2;
	}

	@Test
	public void getProductCostTest(){
		double productCost=util.getProductCost(price, quantity);
		assertEquals(200.0,productCost,0.0); 
	}
	
	@Test
	public void getProductCostZeroPriceTest(){
		double productCost=util.getProductCost(0, quantity);
		assertEquals(0.0,productCost,0.0); 
	}
	
	@Test
	public void getProductCostZeroQtyTest(){
		double productCost=util.getProductCost(price,0);
		assertEquals(0.0,productCost,0.0); 
	}
	
	@Test
	public void getProductCostZeroTest(){
		double productCost=util.getProductCost(0,0);
		assertEquals(0.0,productCost,0.0); 
	}
}
