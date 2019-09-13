package com.product.cart.input.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



import com.product.cart.model.Product;import com.product.cart.model.TaxDetails;


public class JSONReader {
	URL productResource;
	URL taxDetailsresource;
	List<Product> productList = new ArrayList<Product>();
	List<TaxDetails> taxDetailsList = new ArrayList<TaxDetails>();
	public JSONReader(){
		ClassLoader classLoader = getClass().getClassLoader();
		 productResource = classLoader.getResource("product.json");
		 taxDetailsresource = classLoader.getResource("tax.json");
	}
	public List<Product> getProductDetailsFromJSON() {
		return getProductList(productResource);
	}

	@SuppressWarnings("unchecked")
	private List<Product> getProductList(URL productResource) {
      JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader(productResource.getFile())) {
			Object obj = jsonParser.parse(reader);
			JSONArray productJsonList = (JSONArray) obj;
			productJsonList.forEach(product -> {
				final Product productVO = new Product();
				final JSONObject productObject = (JSONObject)product;
				JSONObject productObject1=(JSONObject) productObject.get("product");
				final long productId = (long) productObject1.get("productId");
				productVO.setProductId(productId);
				final String productName = (String) productObject1.get("productName");
				productVO.setProductName(productName);
				final double productPrice = (double) productObject1.get("productPrice");
				productVO.setPrice(productPrice);
				final long productQty = (long) productObject1.get("productQuantity");
				productVO.setQuantity(productQty);
				
				this.getTaxDetails(taxDetailsresource).forEach(taxDetails->{
					if(taxDetails.getProductId()==productVO.getProductId()){
						productVO.setTaxDetails(taxDetails);
					}
				});
				
				productList.add(productVO);
			});
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return productList;
	
	}
	
	@SuppressWarnings("unchecked")
	private List<TaxDetails> getTaxDetails(URL taxDetailsresource){
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader(taxDetailsresource.getFile())) {
			Object obj = jsonParser.parse(reader);
			JSONArray taxProductJsonList = (JSONArray) obj;
			taxProductJsonList.forEach(tax -> {
				TaxDetails taxDetails=new TaxDetails();
				final JSONObject productObject = (JSONObject)tax;
				JSONObject productObject1=(JSONObject) productObject.get("tax");
				final long inputProductId = (long) productObject1.get("productId");
				taxDetails.setProductId(inputProductId);
				final long salestax = (long) productObject1.get("salestax");
				taxDetails.setSalesTax(salestax);
				taxDetailsList.add(taxDetails);
			});
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return taxDetailsList;
	}
}
