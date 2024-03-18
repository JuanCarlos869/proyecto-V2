/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.hyunseda.market.access;

import co.com.hyunseda.market.entities.Product;
import java.util.List;

/**
 *
 * @author JUAN CARLOS MELO
 */

public interface IProductRepository {
    public boolean save(Product newProduct);
    public List<Product> findAll();
    public boolean edit(Long id, Product product);
    public boolean delete(Long id);
    public Product findById(Long id);
    public Product findByName(String name); // Método para buscar un producto por nombre
    public List<Product> findByCategory(Long categoryId); // Método para buscar productos por categoría
}
