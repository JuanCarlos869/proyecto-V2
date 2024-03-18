/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.com.hyunseda.market.service;

import java.lang.reflect.AccessFlag.Location;
import co.com.hyunseda.market.entities.User;
import co.com.hyunseda.market.entities.Category;
import co.com.hyunseda.market.entities.Product;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author shadi
 */
public class ProductTest {
    
    public ProductTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getProductId method, of class Product.
     */
    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        Product instance = new Product();
        Long expResult = null;
        Long result = instance.getProductId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductId method, of class Product.
     */
    @Test
    public void testSetProductId() {
        System.out.println("setProductId");
        Long productId = null;
        Product instance = new Product();
        instance.setProductId(productId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Product.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Product.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Product instance = new Product();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Product.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Product.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Product instance = new Product();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Product.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Product instance = new Product();
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Product.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 0.0;
        Product instance = new Product();
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategory method, of class Product.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        Product instance = new Product();
        Category expResult = null;
        Category result = instance.getCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategory method, of class Product.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        Category category = null;
        Product instance = new Product();
        instance.setCategory(category);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Product.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Product instance = new Product();
        Location expResult = null;
        //Location result = instance.getLocation();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class Product.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        Location location = null;
        Product instance = new Product();
        //instance.setLocation(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class Product.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        Product instance = new Product();
        User expResult = null;
        User result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class Product.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        User user = null;
        Product instance = new Product();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSlug method, of class Product.
     */
    @Test
    public void testGetSlug() {
        System.out.println("getSlug");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getSlug();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSlug method, of class Product.
     */
    @Test
    public void testSetSlug() {
        System.out.println("setSlug");
        String slug = "";
        Product instance = new Product();
        instance.setSlug(slug);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKeywords method, of class Product.
     */
    @Test
    public void testGetKeywords() {
        System.out.println("getKeywords");
        Product instance = new Product();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getKeywords();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKeywords method, of class Product.
     */
    @Test
    public void testSetKeywords() {
        System.out.println("setKeywords");
        ArrayList<String> keywords = null;
        Product instance = new Product();
        instance.setKeywords(keywords);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImagenes method, of class Product.
     */
    @Test
    public void testGetImagenes() {
        System.out.println("getImagenes");
        Product instance = new Product();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getImagenes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImagenes method, of class Product.
     */
    @Test
    public void testSetImagenes() {
        System.out.println("setImagenes");
        ArrayList<String> imagenes = null;
        Product instance = new Product();
        instance.setImagenes(imagenes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStock method, of class Product.
     */
    @Test
    public void testGetStock() {
        System.out.println("getStock");
        Product instance = new Product();
        int expResult = 0;
        int result = instance.getStock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStock method, of class Product.
     */
    @Test
    public void testSetStock() {
        System.out.println("setStock");
        int stock = 0;
        Product instance = new Product();
        instance.setStock(stock);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCaracteristicas method, of class Product.
     */
    @Test
    public void testGetCaracteristicas() {
        System.out.println("getCaracteristicas");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getCaracteristicas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCaracteristicas method, of class Product.
     */
    @Test
    public void testSetCaracteristicas() {
        System.out.println("setCaracteristicas");
        String caracteristicas = "";
        Product instance = new Product();
        instance.setCaracteristicas(caracteristicas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
