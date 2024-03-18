/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.com.hyunseda.market.service;

import co.com.hyunseda.market.entities.Category;
import co.com.hyunseda.market.entities.Product;
import co.com.hyunseda.market.access.CategoryRepository;
import co.com.hyunseda.market.access.ICategoryRepository;
import co.com.hyunseda.market.access.IProductRepository;
import co.com.hyunseda.market.access.ProductRepository;
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
public class ProductServiceTest {
    private IProductRepository repository;
    private ICategoryRepository repositoryC;
    @BeforeEach
    public void setUp() {
        // Inicializa el repository aquí
        repository = new ProductRepository();
        repositoryC = new CategoryRepository();
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
     * Test of saveProduct method, of class ProductService.
     */
    @Test
    
    public void testSaveProduct() {
               

        System.out.println("saveProduct");
        //Long IdProduct  = (long)33;
        String name = "NCDUANSAN";
        String description = "Esta es una bufanda de seda de morera de alta calidad, con una textura de sarga y una sensación dura al tacto. No es tan suave y liso como el satén, algunos son ligeros y frescos, mientras que otros son transpirables y absorben el sudor.";
        Long idCategory = (long)2233;
        ProductService productService = new ProductService(repository); // Instanciar ProductService

        // Llamar al método saveProduct de ProductService
        boolean result = productService.saveProduct(name, description, idCategory,0,0);

        // Verificar el resultado
        assertTrue(result); 
        
        
        
        
        
        System.out.println("saveProduct");
        //IdProduct = (long)34;
        name = "GLigeT";
        description = "Bufanda 100% gusano de seda bufanda de seda moda salvaje sección delgada mantón de verano protector solar mantón de seda Abrigarse en invierno.";
        idCategory = (long)2235;
        

        // Llamar al método saveProduct de ProductService
        result = productService.saveProduct(name, description, idCategory,0,0);

        // Verificar el resultado
        assertTrue(result);
    }

    /**
     * Test of findAllProducts method, of class ProductService.
     */
    @Test
    public void testFindAllProducts() {
        //Long IdProduct = (long)44;
        String name = "NCDUANSAN";
        String description = "Esta es una bufanda de seda de morera de alta calidad, con una textura de sarga y una sensación dura al tacto. No es tan suave y liso como el satén, algunos son ligeros y frescos, mientras que otros son transpirables y absorben el sudor.";
        Long idCategory = (long)2243;
        ProductService productService = new ProductService(repository); // Instanciar ProductService

        // Llamar al método saveProduct de ProductService
        boolean result = productService.saveProduct(name, description, idCategory,0,0);
        
        //IdProduct = (long)45;
        name = "RiRaku";
        description = "Bufanda de seda de gusano de seda, tippet de seda, flor de gasa 70 primavera patata ranúncula bufanda cuadrada, chal de protección solar de seda para mujer.";
        idCategory = (long)2244;
        

        // Llamar al método saveProduct de ProductService
        result = productService.saveProduct(name, description, idCategory,0,0);
        
        List<Product> products = new ArrayList<>();
        //products = repository.findAll();

        // Llamar al método saveProduct de ProductService
        products = productService.findAllProducts();
        result=true;
        if(products==null||products.isEmpty()){
            result=false;
        }
        // Verificar el resultado
        assertTrue(result);
        
        
        
        
        
        
        //IdProduct = (long)46;
        name = "GLigeT";
        description = "Bufanda 100% gusano de seda bufanda de seda moda salvaje sección delgada mantón de verano protector solar mantón de seda Abrigarse en invierno.";
        idCategory = (long)2245;
        // Llamar al método saveProduct de ProductService
        result = productService.saveProduct(name, description, idCategory,0,0);
        
        //IdProduct = (long)47;
        name = "KGDC";
        description = "Bufanda Mantón 100% Gusano de Seda Bufanda de Seda Moda Salvaje sección Delgada mantón de Verano Protector Solar mantón de Seda Elegante Estolas Fular (Color : White).";
        idCategory = (long)2246;
        

        // Llamar al método saveProduct de ProductService
        result = productService.saveProduct(name, description, idCategory,0,0);
        
        //products = repository.findAll();

        // Llamar al método saveProduct de ProductService
        products = productService.findAllProducts();
        result=true;
        if(products==null||products.isEmpty()){
            result=false;
        }
        // Verificar el resultado
        assertTrue(result);
    }

    /**
     * Test of findProductById method, of class ProductService.
     */
    @Test
    public void testFindProductById() {
        //Long IdProduct=(long)22;
        String name = "NCDUANSAN";
        String description = "Esta es una bufanda de seda de morera de alta calidad, con una textura de sarga y una sensación dura al tacto. No es tan suave y liso como el satén, algunos son ligeros y frescos, mientras que otros son transpirables y absorben el sudor.";
        Long idCategory = (long)2243;
        ProductService productService = new ProductService(repository); // Instanciar ProductService
  
        // Llamar al método saveProduct de ProductService
        boolean result = productService.saveProduct(name, description, idCategory,0,0);
        
        System.out.println("FindIdProduct");
        //Long id = (long)22;
        String expected="NCDUANSAN";
        String productName;
        productName = productService.findProductById((long)1).getName();
        assertEquals(expected,productName);
        
        
        
        //IdProduct = (long)23;
        name = "RiRaku";
        description = "Bufanda de seda de gusano de seda, tippet de seda, flor de gasa 70 primavera patata ranúncula bufanda cuadrada, chal de protección solar de seda para mujer.";
        idCategory = (long)2244;
        

        // Llamar al método saveProduct de ProductService
        result = productService.saveProduct(name, description, idCategory,0,0);
        System.out.println("FindIdProduct");

        expected="RiRaku";
        
        productName = productService.findProductById((long)2).getName();
        assertEquals(expected,productName);
    }

    /**
     * Test of deleteProduct method, of class ProductService.
     */
    @Test
    public void testDeleteProduct() {
        //Long IdProduct = (long)33;
        String name = "NCDUANSAN";
        String description = "Esta es una bufanda de seda de morera de alta calidad, con una textura de sarga y una sensación dura al tacto. No es tan suave y liso como el satén, algunos son ligeros y frescos, mientras que otros son transpirables y absorben el sudor.";
        Long idCategory = (long)2243;
        ProductService productService = new ProductService(repository); // Instanciar ProductService

        // Llamar al método saveProduct de ProductService
        boolean result = productService.saveProduct(name, description, idCategory,0,0);
        System.out.println("deleteProduct");
        //Long id = (long)2243;
        
        result = productService.deleteProduct((long)1);
        assertTrue(result);
        
        
        
        //IdProduct = (long)34;
        name = "RiRaku";
        description = "Bufanda de seda de gusano de seda, tippet de seda, flor de gasa 70 primavera patata ranúncula bufanda cuadrada, chal de protección solar de seda para mujer.";
        idCategory = (long)2244;
        

        // Llamar al método saveProduct de ProductService
        result = productService.saveProduct(name, description, idCategory,0,0);
        System.out.println("deleteProduct");
        //id = (long)2244;
        
        result = productService.deleteProduct((long)1);
        assertTrue(result);
    }

    /**
     * Test of editProduct method, of class ProductService.
     */
    @Test
    public void testEditProduct() {

        String name = "NCDUANSAN";
        String description = "Esta es una bufanda de seda de morera de alta calidad, con una textura de sarga y una sensación dura al tacto. No es tan suave y liso como el satén, algunos son ligeros y frescos, mientras que otros son transpirables y absorben el sudor.";
        Long idCategory = (long)2243;
        ProductService productService = new ProductService(repository); // Instanciar ProductService

        // Llamar al método saveProduct de ProductService
        boolean result = productService.saveProduct(name, description, idCategory,0,0);

        Product producto = new Product();
        producto.setName("Lumisyne");
        producto.setDescription("Bufandas De Seda Para Mujer Estampado Floral Estilo Moda y Elegante Estolas Largo y Suave Chal De Boda Fulares Caliente Toda La Temporada.");
        Category newCategory = new Category();
        newCategory.setCategoryId((long)221);
        producto.setCategory(newCategory);

        System.out.println("editProduct");
        result = productService.editProduct((long)1, producto);
        assertTrue(result);
        
        
        name = "RiRaku";
        description = "Bufanda de seda de gusano de seda, tippet de seda, flor de gasa 70 primavera patata ranúncula bufanda cuadrada, chal de protección solar de seda para mujer.";
        idCategory = (long)2246;
        

        // Llamar al método saveProduct de ProductService
        result = productService.saveProduct(name, description, idCategory,0,0);

        producto = new Product();
        producto.setName("prettystern");
        producto.setDescription("Chal foulard de seda mujer con impresión de arte Claude Monet 90cm cuadrado.");
        newCategory = new Category();
        newCategory.setCategoryId((long)227);
        producto.setCategory(newCategory);

        System.out.println("editProduct");
        result = productService.editProduct((long)2, producto);
        assertTrue(result);
        
        
    }
    

    /**
     * Test of findProductByName method, of class ProductService.
     */
    @Test
    public void testFindProductByName() {
        String name = "NCDUANSAN";
        String description = "Esta es una bufanda de seda de morera de alta calidad, con una textura de sarga y una sensación dura al tacto. No es tan suave y liso como el satén, algunos son ligeros y frescos, mientras que otros son transpirables y absorben el sudor.";
        Long idCategory = (long)2243;
        ProductService productService = new ProductService(repository); // Instanciar ProductService
  
        // Llamar al método saveProduct de ProductService
        boolean result = productService.saveProduct(name, description, idCategory,0,0);
        
        System.out.println("FoundProductByName");
        //Long id = (long)22;
        String expected="Esta es una bufanda de seda de morera de alta calidad, con una textura de sarga y una sensación dura al tacto. No es tan suave y liso como el satén, algunos son ligeros y frescos, mientras que otros son transpirables y absorben el sudor.";
        String productDesc;
        productDesc = productService.findProductByName("NCDUANSAN").getDescription();
        assertEquals(expected,productDesc);
        
        
        

        name = "RiRaku";
        description = "Bufanda de seda de gusano de seda, tippet de seda, flor de gasa 70 primavera patata ranúncula bufanda cuadrada, chal de protección solar de seda para mujer.";
        idCategory = (long)2244;
        

        // Llamar al método saveProduct de ProductService
        result = productService.saveProduct(name, description, idCategory,0,0);
        System.out.println("FoundProductByName");

        expected="Bufanda de seda de gusano de seda, tippet de seda, flor de gasa 70 primavera patata ranúncula bufanda cuadrada, chal de protección solar de seda para mujer.";
        
        productDesc = productService.findProductByName("RiRaku").getDescription();
        assertEquals(expected,productDesc);
        
        
        /*public Product findProductByName(String name) {
        return repository.findByName(name);
        }*/
    }

    /**
     * Test of findProductsByCategory method, of class ProductService.
     */
    @Test
    public void testFindProductsByCategory() {
        
        /*public List<Product> findProductsByCategory(Long categoryId) {
        List<Product> products = new ArrayList<>();
        products = repository.findByCategory(categoryId);

        return products;
        }*/
        String nameC = "SEDA";
        
        CategoryService categoryService = new CategoryService(repositoryC); // Instanciar ProductService

        // Llamar al método saveProduct de ProductService
        boolean resultC = categoryService.saveCategory(nameC);
        List<Product> products = new ArrayList<>();
        
        String name = "NCDUANSAN";
        String description = "Esta es una bufanda de seda de morera de alta calidad, con una textura de sarga y una sensación dura al tacto. No es tan suave y liso como el satén, algunos son ligeros y frescos, mientras que otros son transpirables y absorben el sudor.";
        Long idCategory = (long)1;
        ProductService productService = new ProductService(repository); // Instanciar ProductService
  
        // Llamar al método saveProduct de ProductService
        boolean result = productService.saveProduct(name, description, idCategory,0,0);
        
        
        name = "RiRaku";
        description = "Bufanda de seda de gusano de seda, tippet de seda, flor de gasa 70 primavera patata ranúncula bufanda cuadrada, chal de protección solar de seda para mujer.";
        idCategory = (long)1;
        

        // Llamar al método saveProduct de ProductService
        result = productService.saveProduct(name, description, idCategory,0,0);
        
        System.out.println("FoundProductByCategory");
        //Long id = (long)22;
        products = productService.findProductsByCategory((long)1);
        result=true;
        if(products==null||products.isEmpty()||products.size()!=2){
            result=false;//false
        }
        // Verificar el resultado
        assertTrue(result);
        
        
        
        nameC = "SEDA2";

        // Llamar al método saveProduct de ProductService
        resultC = categoryService.saveCategory(nameC);
        products = new ArrayList<>();
        name = "RiRaku";
        description = "Bufanda de seda de gusano de seda, tippet de seda, flor de gasa 70 primavera patata ranúncula bufanda cuadrada, chal de protección solar de seda para mujer.";
        idCategory = (long)2;
        

        // Llamar al método saveProduct de ProductService
        result = productService.saveProduct(name, description, idCategory,0,0);
        
        
        name = "NCDUANSAN";
        description = "Esta es una bufanda de seda de morera de alta calidad, con una textura de sarga y una sensación dura al tacto. No es tan suave y liso como el satén, algunos son ligeros y frescos, mientras que otros son transpirables y absorben el sudor.";
        idCategory = (long)2;
  
        // Llamar al método saveProduct de ProductService
        result = productService.saveProduct(name, description, idCategory,0,0);

        
        System.out.println("FoundProductByCategory");
        products = productService.findProductsByCategory((long)idCategory);
        result=true;
        if(products==null||products.isEmpty()||products.size()!=2){
            result=false;//false
        }
        // Verificar el resultado
        assertTrue(result);
        
        
    }
    
}
