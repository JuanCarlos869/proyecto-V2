
package co.com.hyunseda.market.presentation;

import co.com.hyunseda.market.access.CategoryRepository;
import co.com.hyunseda.market.access.ProductRepository;
import co.com.hyunseda.market.entities.User;
import co.com.hyunseda.market.service.CategoryService;
import co.com.hyunseda.market.service.ProductService;
import co.com.hyunseda.market.service.ShoppingCartService;

/**
 * Clase principal que representa la aplicación de consola.
 */
public  class Main {

    public static void main(String[] args) {
        // Inicializar servicios y repositorios
        CategoryRepository categoryRepository = new CategoryRepository();
        CategoryService categoryService = new CategoryService(categoryRepository);
        ProductRepository productRepository = new ProductRepository();
        ProductService productService = new ProductService(productRepository);
        
        ShoppingCartService shoppingCartService = new ShoppingCartService(new User());

        
        ListaProductosGUI instance = new ListaProductosGUI(categoryService,productService,shoppingCartService);
        productService.addObserver(instance);
        instance.setVisible(true);
        // Le decimos a la fábrica que nos de el repositorio por defecto
        
        CarroComprasGUI instance2 = new CarroComprasGUI(shoppingCartService,productService); 
        shoppingCartService.addObserver(instance2);
        instance2.setVisible(false);
    }
}
