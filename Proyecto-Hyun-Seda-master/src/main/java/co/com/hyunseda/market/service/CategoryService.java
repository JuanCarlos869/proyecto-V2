/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.service;

import co.com.hyunseda.market.entities.Category;
import co.com.hyunseda.market.access.ICategoryRepository;
import java.util.List;

/**
 * Servicio para operaciones CRUD relacionadas con las categorías de productos.
 */
/**
 *
 * @author usuario
 */
public class CategoryService {
    
    private ICategoryRepository repository;

    public CategoryService(ICategoryRepository repository) { 
        this.repository = repository;
    }

    public boolean saveCategory(String name) {
        
        Category newCategory = new Category();
        newCategory.setName(name);
        
        // Validar categoría
        if (newCategory.getName().isEmpty()) {
            return false;
        }

        return repository.save(newCategory);
    }

    public List<Category> findAllCategories() {
        return repository.findAll();
    }
    
    public Category findCategoryById(Long id){
        return repository.findById(id);
    }
    
    public boolean deleteCategory(Long id){
        return repository.delete(id);
    }

    public boolean editCategory(Long categoryId, Category category) {
        
        // Validar categoría
        if (category == null || category.getName().isEmpty()) {
            return false;
        }
        
        return repository.edit(categoryId, category);
    }
}
