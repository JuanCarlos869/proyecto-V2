/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.com.hyunseda.market.access;

import co.com.hyunseda.market.entities.Product;
import java.util.List;
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
public class IProductRepositoryTest {
    
    public IProductRepositoryTest() {
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
     * Test of save method, of class IProductRepository.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Product newProduct = null;
        IProductRepository instance = new IProductRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.save(newProduct);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class IProductRepository.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        IProductRepository instance = new IProductRepositoryImpl();
        List<Product> expResult = null;
        List<Product> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class IProductRepository.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Long id = null;
        Product product = null;
        IProductRepository instance = new IProductRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.edit(id, product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class IProductRepository.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        IProductRepository instance = new IProductRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class IProductRepository.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Long id = null;
        IProductRepository instance = new IProductRepositoryImpl();
        Product expResult = null;
        Product result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByName method, of class IProductRepository.
     */
    @Test
    public void testFindByName() {
        System.out.println("findByName");
        String name = "";
        IProductRepository instance = new IProductRepositoryImpl();
        Product expResult = null;
        Product result = instance.findByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByCategory method, of class IProductRepository.
     */
    @Test
    public void testFindByCategory() {
        System.out.println("findByCategory");
        Long categoryId = null;
        IProductRepository instance = new IProductRepositoryImpl();
        List<Product> expResult = null;
        List<Product> result = instance.findByCategory(categoryId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IProductRepositoryImpl implements IProductRepository {

        public boolean save(Product newProduct) {
            return false;
        }

        public List<Product> findAll() {
            return null;
        }

        public boolean edit(Long id, Product product) {
            return false;
        }

        public boolean delete(Long id) {
            return false;
        }

        public Product findById(Long id) {
            return null;
        }

        public Product findByName(String name) {
            return null;
        }

        public List<Product> findByCategory(Long categoryId) {
            return null;
        }
    }
    
}
