package co.com.hyunseda.market.service;


import co.com.hyunseda.market.entities.Category;
import co.com.hyunseda.market.entities.Product;
import co.com.hyunseda.market.access.IProductRepository;
import co.com.hyunseda.market.entities.ShoppingCart;
import co.com.hyunseda.market.infra.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class ProductService extends Subject {
    
    private IProductRepository repository;

    public ProductService(IProductRepository repository) { 
        this.repository = repository;
    }

    public boolean saveProduct(Product newProduct) {  
        boolean respuesta=repository.save(newProduct);
        if(respuesta){
            notifyAllObserves();
        }
        return respuesta;
        }

    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        products = repository.findAll();

        return products;
    }
    
    public Product findProductById(Long id){
        return repository.findById(id);
    }
    
    public boolean deleteProduct(Long id){
        boolean respuesta=repository.delete(id);
        if(respuesta){
            notifyAllObserves();
        }
        return respuesta;
    }

    public boolean editProduct(Long productId, Product prod) {
        
        //Validate product
        if (prod == null || prod.getName().isEmpty() || prod.getCategory() == null ) {
            return false;
        }
        boolean respuesta=repository.edit(productId, prod);
        if(respuesta){
            notifyAllObserves();
        }
        return respuesta;
    }
    
    public Product findProductByName(String name) {
        return repository.findByName(name);
    }
    
    public List<Product> findProductsByCategory(Long categoryId) {
        List<Product> products = new ArrayList<>();
        products = repository.findByCategory(categoryId);

        return products;
    }
    
    public boolean actualizarStockCompra(ShoppingCart shoppingCart){
        
        for(Product sh: shoppingCart.getCarro()){
            Product aux = findProductById(sh.getProductId());
            aux.setStock(aux.getStock() - sh.getStock());
            boolean auxRespuesta = editProduct(sh.getProductId(), aux);
        }
        return true;
    }
}
