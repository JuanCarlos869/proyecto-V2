/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.com.hyunseda.market.service;

import co.com.hyunseda.market.entities.Category;
import co.com.hyunseda.market.access.CategoryRepository;
import co.com.hyunseda.market.access.ICategoryRepository;
import java.util.ArrayList;
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
public class CategoryServiceTest {
    private ICategoryRepository repository;
    @BeforeEach
    public void setUp() {
        // Inicializa el repository aquí
        repository = new CategoryRepository();
    }
    
    public CategoryServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of saveCategory method, of class CategoryService.
     */
    @Test
    public void testSaveCategory() {
        System.out.println("Category saved");
        //Long IdProduct  = (long)33;
        String name = "100%Seda";
        
        CategoryService categoryService = new CategoryService(repository); // Instanciar ProductService

        // Llamar al método saveProduct de ProductService
        boolean result = categoryService.saveCategory(name);

        // Verificar el resultado
        assertTrue(result); 
    }

    /**
     * Test of findAllCategories method, of class CategoryService.
     */
    @Test
    public void testFindAllCategories() {
        
        List<Category> categories = new ArrayList<>();
        String name = "NCDUANSAN";
        
        CategoryService categoryService = new CategoryService(repository); // Instanciar ProductService

        // Llamar al método saveProduct de ProductService
        boolean result = categoryService.saveCategory(name);
        
        //IdProduct = (long)45;
        name = "RiRaku";
        // Llamar al método saveProduct de ProductService
        result = categoryService.saveCategory(name);
        
        //products = repository.findAll();

        // Llamar al método saveProduct de ProductService
        categories = categoryService.findAllCategories();
        result=true;
        if(categories==null||categories.isEmpty()){
            result=false;
        }
        System.out.println("Categories found");
        // Verificar el resultado
        assertTrue(result);
        
        
        
        
        
        
        //IdProduct = (long)46;
        name = "GLigeT";
        // Llamar al método saveProduct de ProductService
        result = categoryService.saveCategory(name);
        
        //IdProduct = (long)47;
        name = "KGDC";
        // Llamar al método saveProduct de ProductService
        result = categoryService.saveCategory(name);
        
        //products = repository.findAll();

        // Llamar al método saveProduct de ProductService
        categories = categoryService.findAllCategories();
        result=true;
        System.out.println("Categories found");
        if(categories==null||categories.isEmpty()){
            result=false;
        }
        // Verificar el resultado
        assertTrue(result);
    }

    /**
     * Test of findCategoryById method, of class CategoryService.
     */
    @Test
    public void testFindCategoryById() {
        String name = "NCDUANSAN";
        
        CategoryService categoryService = new CategoryService(repository); // Instanciar ProductService
  
        // Llamar al método saveProduct de ProductService
        boolean result = categoryService.saveCategory(name);
       
        //Long id = (long)22;
        String expected="NCDUANSAN";
        String categoryName;
        categoryName = categoryService.findCategoryById((long)1).getName();
        System.out.println("Category found");
        assertEquals(expected,categoryName);
        
        
        
        //IdProduct = (long)23;
        name = "RiRaku";       

        // Llamar al método saveProduct de ProductService
        result = categoryService.saveCategory(name);
        expected="RiRaku";
        
        categoryName = categoryService.findCategoryById((long)2).getName();
        System.out.println("Category found");
        assertEquals(expected,categoryName);
    }

    /**
     * Test of deleteCategory method, of class CategoryService.
     */
    @Test
    public void testDeleteCategory() {
        String name = "NCDUANSAN";
        CategoryService categoryService = new CategoryService(repository); // Instanciar ProductService

        // Llamar al método saveProduct de ProductService
        boolean result = categoryService.saveCategory(name);
        
        result = categoryService.deleteCategory((long)1);
        System.out.println("Category deleted");
        assertTrue(result);
        
        
        
        //IdProduct = (long)34;
        name = "RiRaku";
        
        // Llamar al método saveProduct de ProductService
        result = categoryService.saveCategory(name);
        
        result = categoryService.deleteCategory((long)2);
        System.out.println("Category deleted");
        assertTrue(result);
    }

    /**
     * Test of editCategory method, of class CategoryService.
     */
    @Test
    public void testEditCategory() {
        String name = "NCDUANSAN";
        
        CategoryService categoryService = new CategoryService(repository); // Instanciar ProductService

        // Llamar al método saveProduct de ProductService
        boolean result = categoryService.saveCategory(name);

        Category categoria = new Category();
        categoria.setName("Lumisyne");

        
        result = categoryService.editCategory((long)1, categoria);
        System.out.println("Category edited");
        assertTrue(result);
        
        
        name = "RiRaku";
        // Llamar al método saveProduct de ProductService
        result = categoryService.saveCategory(name);

        categoria = new Category();
        categoria.setName("prettystern");

        result = categoryService.editCategory((long)2, categoria);
        System.out.println("Category edited");
        assertTrue(result);
    }
    
}
