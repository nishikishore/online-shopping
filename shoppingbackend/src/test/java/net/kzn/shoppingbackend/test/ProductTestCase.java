package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dto.Product;
import net.kzn.shoppingbackend.dto.ProductDAO;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	/*
	 * @Test public void testAddCategory(){ category = new Category();
	 * 
	 * category.setName("Television"); category.setDescription(
	 * "description for television"); category.setImageURL("CAT_1.png");
	 * 
	 * assertEquals("Successfully added a category inside the table",
	 * true,categoryDAO.add(category)); }
	 */
	/*
	 * @Test public void testGetCategory(){ 
	 * category = categoryDAO.get(1);
	 * assertEquals("Successfully fetched a single category from the table",
	 * "Television",category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory(){ category = categoryDAO.get(1);
	 * category.setName("TV"); assertEquals(
	 * "Successfully updated a single category from the table",
	 * true,categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory(){ category = categoryDAO.get(1);
	 * assertEquals("Successfully deleted a single category from the table",
	 * true,categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory(){ assertEquals(
	 * "Successfully fetched the list of  categories from the table",
	 * 2,categoryDAO.list().size()); }
	 */

	/*@Test
	public void testCRUDCategory() {
		
		// add operation
		product = new Product();

		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobile phone");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);

		assertEquals("Something went wrong while inserting a new product",
				true, productDAO.add(product));
		
		// fetching and updating the product
		product = productDAO.get(2);
		product.setName("Samsung Galaxy S7"); 
		assertEquals(
		 "Something went wrong while updating the existing record",
		 true,productDAO.update(product)); 
		 
		 // delete operation
		 
		 assertEquals("Something went wrong while deleting the existing record",
		 true,productDAO.delete(product));
		 
		 // fetching the list
		 assertEquals(
				 "Something went wrong while fetching the list of products",
				 6,productDAO.list().size());
		 
	}
	*/
	
	/*@Test
	public void testListActiveProducts(){
		assertEquals(
				 "Something went wrong while fetching the list of products",
				 5,productDAO.listActiveProducts().size());
	}*/
	
	/*@Test
	public void testListActiveProductsByCategory(){
		assertEquals(
				 "Something went wrong while fetching the list of products",
				 3,productDAO.listActiveProductsByCategory(3).size());
		assertEquals(
				 "Something went wrong while fetching the list of products",
				 2,productDAO.listActiveProductsByCategory(1).size());
	}*/
	
	@Test
	public void testGetLatestActiveProduct(){
		assertEquals(
				 "Something went wrong while fetching the list of products",
				 3,productDAO.getLatestActiveProducts(3).size());
		
	}
}
