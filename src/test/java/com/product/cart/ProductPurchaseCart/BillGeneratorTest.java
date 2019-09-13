package com.product.cart.ProductPurchaseCart;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.product.cart.model.Product;

public class BillGeneratorTest {

	long percentage;
	double productCost;
	
	@InjectMocks
	private CartBillGenerator generator;
	
	@Mock
	private Product product;
	
	@Before  
    public void setUp() throws Exception {
		product.setPrice(10);
		product.setProductCost(200);
	}

	public void setGenerateBillTest(){
		generator.generateBill();
	}
}
