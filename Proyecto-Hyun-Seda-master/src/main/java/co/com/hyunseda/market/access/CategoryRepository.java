/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.access;

import co.com.hyunseda.market.entities.Category;
import co.com.hyunseda.market.service.CategoryService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class CategoryRepository implements ICategoryRepository{
    private Connection conn;

    public CategoryRepository() {
        try {
            conn = DatabaseConnection.getConnection();
            initDatabase();
            categoriasIniciales();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void categoriasIniciales(){
        Category category = new Category();
        category.setName("aretes");
        save(category);
        category.setName("bufandas");
        save(category);
        category.setName("chales");
        save(category);
        category.setName("poncho");
        save(category);
        category.setName("ruana");
        save(category);
        category.setName("prenda");
        save(category);
        category.setName("accesorio");
        save(category);
    }
    
    @Override
    public boolean save(Category newCategory) {
        try {
            if (newCategory == null || newCategory.getName().isEmpty()) {
                return false;
            }

            String sql = "INSERT INTO categories (name) VALUES (?)";

            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, newCategory.getName());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {
            String sql = "SELECT * FROM categories";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryId(rs.getLong("categoryId"));
                category.setName(rs.getString("name"));
                categories.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    @Override
    public boolean edit(Long id, Category category) {
        try {
            if (id <= 0 || category == null || category.getName().isEmpty()) {
                return false;
            }

            String sql = "UPDATE categories SET name=? WHERE categoryId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category.getName());
            pstmt.setLong(2, id);
            pstmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            if (id <= 0) {
                return false;
            }

            String sql = "DELETE FROM categories WHERE categoryId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Category findById(Long id) {
        try {
            String sql = "SELECT * FROM categories WHERE categoryId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                Category category = new Category();
                category.setCategoryId(res.getLong("categoryId"));
                category.setName(res.getString("name"));
                return category;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private void initDatabase() {
        try {
            createCategoryTable();
            createProductTable();
            createRelationTable();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void createCategoryTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS categories ("
                + "categoryId INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL"
                + ")";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    private void createProductTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS products ("
                + "productId INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL,"
                + "description TEXT NULL,"
                + "stock INTEGER NOT NULL,"
                + "price REAL NOT NULL,"
                + "urlImagen TEXT NOT NULL"
                + ")";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    private void createRelationTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS product_category ("
                + "productId INTEGER,"
                + "categoryId INTEGER,"
                + "FOREIGN KEY (productId) REFERENCES products(productId),"
                + "FOREIGN KEY (categoryId) REFERENCES categories(categoryId),"
                + "PRIMARY KEY (productId, categoryId)"
                + ")";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
