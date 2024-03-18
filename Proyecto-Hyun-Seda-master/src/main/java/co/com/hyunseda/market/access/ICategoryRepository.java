/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.access;

import co.com.hyunseda.market.entities.Category;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface ICategoryRepository {
    public boolean save(Category newCategory);
    public List<Category> findAll();
    public boolean edit(Long id, Category category);
    public boolean delete(Long id);
    public Category findById(Long id);
}
