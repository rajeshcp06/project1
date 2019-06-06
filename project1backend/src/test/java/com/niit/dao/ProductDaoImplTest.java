package com.niit.dao;


import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Configuration.DBConfiguration;
import com.niit.models.Product;

import junit.framework.TestCase;

public class ProductDaoImplTest extends TestCase {
	 ApplicationContext context=new AnnotationConfigApplicationContext(DBConfiguration.class,ProductDaoImpl.class);
	   ProductDao productDao=(ProductDao)context.getBean("productDaoImpl");
@Test
	   public void testSaveProduct() 
	   {
		Product product =new Product();
		product.setPrice(500000);
		product.setQuantity(5);
		product.setProductname("ford ecosport");
		product.setProductdesc("ford ecosport latest model");
		
		product=productDao.saveProduct(product);
		
		assertTrue(product.getId()>0); //TC
		
	}
	@Ignore
@Test
	public void testGetProduct() {
		  Product product3=productDao.getProduct(1);
		   Product product1=productDao.getProduct(3);//id=3,
		   Product product2=productDao.getProduct(4);//id==4,
		   Product product4=productDao.getProduct(2);//id==2
		   //Null or Not null
		   assertNotNull(product1);
		   assertNotNull(product3);//product3!=null, if it is true, success
		   assertNotNull(product2);//product2!=null,if it is true,success
		   //check for prices [actual price returned is same as expected price for id=3
		   double expectedPrice=1000000;
		   double actualPrice=product1.getPrice();
	
		   assertTrue(expectedPrice==actualPrice);//if true, success
	}
@Ignore
@Test
	public void testUpdateProduct() {
		//Get product object for the id=3
		//Update the price and quantity of the product id=3
		Product product=productDao.getProduct(3);
		product.setPrice(2000);
		product.setQuantity(25);
		productDao.updateProduct(product);//product has updated price and update quantity
		assertTrue(product.getPrice()==2000);
		assertTrue(product.getQuantity()==25);
	}

}


