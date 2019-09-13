package com.product.cart.ProductPurchaseCart;

import java.io.File;

import com.product.cart.input.reader.JSONReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	CartBillGenerator billGenerator=new CartBillGenerator();
    	billGenerator.generateBill();
    }
}
