package co.com.hyunseda.market.access;

import co.com.hyunseda.market.entities.Category;
import co.com.hyunseda.market.entities.Product;
import co.com.hyunseda.market.service.ProductService;
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
 * @author JUAN CARLOS MELO
 */
public class ProductRepository implements IProductRepository {

    private Connection conn;

    public ProductRepository() {
        try {
            conn = DatabaseConnection.getConnection();
            initDatabase();
            productosIniciales();
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void productosIniciales() {

        ArrayList<Category> categories = new ArrayList<Category>();

        Product product = new Product();
        product.setName("aretes hilos negros");
        product.setPrice(35000);
        product.setDescription("bonitos");
        product.setUrlImagen("https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/thumbnail_IMG_20240223_121702-8d263f7f-fa97-445f-ad96-d57d02ca0e98.jpg");
        product.setStock(5);
        categories.add(new Category(1L, "Aretes"));
        categories.add(new Category(7L, "Aretes"));
        product.setCategory(categories);
        save(product);

        categories.clear();

        product.setName("aretes blanco cafe");
        product.setPrice(35000);
        product.setDescription("brillantes");
        product.setUrlImagen("https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/thumbnail_IMG_20240221_123043-abe3d9f4-0738-4a8f-868d-08256a3c7f5f.jpg");
        product.setStock(10);
        categories.add(new Category(1L, "Aretes"));
        categories.add(new Category(6L, "Aretes"));
        product.setCategory(categories);
        save(product);

        categories.clear();

        product.setName("aretes rosado y blanco");
        product.setPrice(35000);
        product.setDescription("hechos a mano");
        product.setUrlImagen("https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/thumbnail_IMG_20240221_120750-dea3a843-207d-4b4c-a82f-55689fd1a9a7.jpg");
        product.setStock(7);
        categories.add(new Category(1L, "Aretes"));
        categories.add(new Category(7L, "Aretes"));
        product.setCategory(categories);
        save(product);

        categories.clear();

        product.setName("aretes blancos");
        product.setPrice(35000);
        product.setDescription("Baratos");
        product.setUrlImagen("https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/thumbnail_IMG_20240223_121045-16a5e407-e839-4433-9a86-e1aa3a2f4f6f.jpg");
        product.setStock(3);
        categories.add(new Category(1L, "Aretes"));
        categories.add(new Category(6L, "Aretes"));
        product.setCategory(categories);
        save(product);

    }

    @Override
    public boolean save(Product newProduct) {
        try {
            if (newProduct == null || newProduct.getName().isEmpty() || newProduct.getCategory() == null || newProduct.getStock() <= 0 || newProduct.getPrice() <= 0 || newProduct.getUrlImagen().isEmpty()) {
                return false;
            }

            String sql = "INSERT INTO products (name, description, stock, price, urlImagen) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newProduct.getName());
            pstmt.setString(2, newProduct.getDescription());
            pstmt.setInt(3, newProduct.getStock());
            pstmt.setDouble(4, newProduct.getPrice());
            pstmt.setString(5, newProduct.getUrlImagen());
            pstmt.executeUpdate();
            long idProductoInsertado = obtenerMaximoIdProducto();
            agregarCategoria(newProduct.getCategory(), idProductoInsertado);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public long obtenerMaximoIdProducto() {
        String sql = "SELECT productId FROM products";
        long maxId = Long.MIN_VALUE;

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                long productId = rs.getLong("productId");
                if (productId > maxId) {
                    maxId = productId;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return maxId;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT * "
                    + "FROM products";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // Crear un objeto Product y agregarlo a la lista
                Product product = new Product();
                Long idProducto = rs.getLong("productId");
                product.setProductId(idProducto);
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setUrlImagen(rs.getString("urlImagen"));
                product.setStock(rs.getInt("stock"));
                product.setPrice(rs.getDouble("price"));
                // Crear un objeto Category y establecer su ID y nombre
                ArrayList<Category> category;
                category = traerCategoriasProducto(idProducto);
                // Establecer la categoría del producto
                product.setCategory(category);
                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public ArrayList<Category> traerCategoriasProducto(Long id) {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            String sql = "SELECT c.categoryId, c.name "
                    + "FROM categories c "
                    + "INNER JOIN product_category pc ON c.categoryId = pc.categoryId "
                    + "WHERE pc.productId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
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
    public boolean edit(Long id, Product product) {
        try {
            if (id <= 0 || product == null || product.getName().isEmpty() || product.getStock() < 0 || product.getPrice() <= 0 || product.getUrlImagen().isEmpty()) {
                return false;
            }

            String sql = "UPDATE products SET name=?, description=?, stock=?, price=?,urlImagen=? WHERE productId = ?";
            String sql2 = "DELETE FROM product_category WHERE productId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getDescription());
            pstmt.setInt(3, product.getStock());
            pstmt.setDouble(4, product.getPrice());
            pstmt.setString(5, product.getUrlImagen());
            pstmt.setLong(6, id);
            pstmt.executeUpdate();

            pstmt = conn.prepareStatement(sql2);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            agregarCategoria(product.getCategory(), id);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void agregarCategoria(ArrayList<Category> category, Long id) {
        try {
            if (id <= 0 || category == null) {
                return;
            }

            String sql = "INSERT INTO product_category (productId, categoryId) VALUES (?, ?)";

            for (Category c : category) {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setLong(1, id);
                pstmt.setLong(2, c.getCategoryId());
                pstmt.executeUpdate();
            }

        } catch (Exception ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            //Validate product
            if (id <= 0) {
                return false;
            }
            //this.connect();

            String sql = "DELETE FROM products "
                    + "WHERE productId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Product findById(Long id) {
        try {
            String sql = "SELECT * FROM products WHERE productId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                Product product = new Product();
                Long idProducto = res.getLong("productId");
                product.setProductId(idProducto);
                product.setName(res.getString("name"));
                product.setDescription(res.getString("description"));
                product.setUrlImagen(res.getString("urlImagen"));
                product.setStock(res.getInt("stock"));
                product.setPrice(res.getDouble("price"));
                // Obtener el nombre de la categoría del producto
                ArrayList<Category> category;
                category = traerCategoriasProducto(idProducto);
                // Establecer la categoría del producto
                product.setCategory(category);
                return product;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Product findByName(String name) {
        try {
            String sql = "SELECT * WHERE p.name = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                Product product = new Product();
                Long idProducto = res.getLong("productId");
                product.setProductId(idProducto);
                product.setName(res.getString("name"));
                product.setDescription(res.getString("description"));
                product.setUrlImagen(res.getString("urlImagen"));
                product.setStock(res.getInt("stock"));
                product.setPrice(res.getDouble("price"));
                // Obtener el nombre de la categoría del producto
                ArrayList<Category> category;
                category = traerCategoriasProducto(idProducto);
                // Establecer la categoría del producto
                product.setCategory(category);
                return product;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Product> findByCategory(Long categoryId) {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT p.* "
                    + "FROM products p "
                    + "JOIN product_category pc ON p.productId = pc.productId "
                    + "WHERE pc.categoryId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, categoryId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                Long idProducto = rs.getLong("productId");
                product.setProductId(idProducto);
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setUrlImagen(rs.getString("urlImagen"));
                product.setStock(rs.getInt("stock"));
                product.setPrice(rs.getDouble("price"));
                // Obtener el nombre de la categoría del producto
                ArrayList<Category> category;
                category = traerCategoriasProducto(idProducto);
                // Establecer la categoría del producto
                product.setCategory(category);

                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    private void initDatabase() {
        try {
            createCategoryTable();
            createProductTable();
            createRelationTable();
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
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

    /*
    private void producto_Categoria() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS products ("
                + "productId INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL,"
                + "description TEXT NULL,"
                + "categoryId INTEGER NOT NULL,"
                + "stock INTEGER NOT NULL,"
                + "price REAL NOT NULL,"
                + ")";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }
     */
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
