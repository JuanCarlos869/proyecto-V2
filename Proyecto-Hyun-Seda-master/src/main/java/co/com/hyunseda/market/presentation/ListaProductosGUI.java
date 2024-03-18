/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.com.hyunseda.market.presentation;

import co.com.hyunseda.market.entities.Category;
import co.com.hyunseda.market.entities.Product;
import co.com.hyunseda.market.infra.Observer;
import co.com.hyunseda.market.infra.Utilities;
import co.com.hyunseda.market.service.CategoryService;
import co.com.hyunseda.market.service.ProductService;
import co.com.hyunseda.market.service.ShoppingCartService;
import java.awt.Cursor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author JUAN CARLOS MELO
 */
public class ListaProductosGUI extends javax.swing.JFrame implements Observer {

    private List<Product> products;
    ProductService productService;
    CategoryService categoryService;
    ShoppingCartService shoppingCartService;

    public ListaProductosGUI(CategoryService categoryService,ProductService productService, ShoppingCartService shoppingCartService) {
        initComponents();
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
        this.categoryService=categoryService;
        loadCategories();
        loadAllProducts();
        btnAniadir.setVisible(false);
        setLocationRelativeTo(null);
        setSize(1000, 500);
    }

    private void loadCategories() {

        cboCategories.addItem("<Todas>");
        for (Category category : categoryService.findAllCategories()) {
            cboCategories.addItem(category.getCategoryId()+"-"+category.getName());
        }
    }

    private void loadAllProducts() {
        try {
            products = productService.findAllProducts();
            DefaultListModel listModel = new DefaultListModel();

            for (Product product : products) {
                listModel.addElement(product.getName());
            }
            lstProductos.setModel(listModel);
        } catch (Exception ex) {
            Logger.getLogger(ListaProductosGUI.class.getName()).log(Level.SEVERE, "Error al cargar platos", ex);
        }
    }

    private void loadProductsByCategory(Long category) {
        try {
            products = productService.findProductsByCategory(category);
            DefaultListModel listModel = new DefaultListModel();

            for (Product product : products) {
                listModel.addElement(product.getName());
            }
            lstProductos.setModel(listModel);
        } catch (Exception ex) {
            Logger.getLogger(ListaProductosGUI.class.getName()).log(Level.SEVERE, "Error al cargar platos", ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAniadirProducto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboCategories = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProductos = new javax.swing.JList<>();
        lbImagen = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbDescripcion = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnAniadir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAniadirProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anadir-a-la-cesta.png"))); // NOI18N
        btnAniadirProducto.setText("Añadir Producto");
        btnAniadirProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAniadirProducto);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.jpg"))); // NOI18N
        jPanel1.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Cambria", 3, 18)); // NOI18N
        jLabel2.setText("Hyun Seda");
        jPanel1.add(jLabel2);

        jLabel3.setText("   Categoria: ");
        jPanel1.add(jLabel3);

        cboCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriesActionPerformed(evt);
            }
        });
        jPanel1.add(cboCategories);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrar);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        lstProductos.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));
        lstProductos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstProductos);

        jPanel3.add(jScrollPane1);

        lbImagen.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagen"));
        jPanel3.add(lbImagen);

        jPanel4.setLayout(new java.awt.BorderLayout());

        lbDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripcion"));
        jPanel4.add(lbDescripcion, java.awt.BorderLayout.CENTER);

        btnAniadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anadirProducto.png"))); // NOI18N
        btnAniadir.setText("Añadir");
        btnAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirActionPerformed(evt);
            }
        });
        jPanel5.add(btnAniadir);

        jPanel4.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jPanel3.add(jPanel4);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstProductosMouseClicked
        int i = lstProductos.getSelectedIndex();
        if (i >= 0) {
            // Coloca la descripción
            StringBuilder sb = new StringBuilder(64);
            sb.append("<html>" + products.get(i).getDescription()
                    + "<br><br>Precio: " + products.get(i).getPrice()
                    + "<br><br>Stock: " + products.get(i).getStock()
                    + "<br><br>Categorías: " + products.get(i).obtenerCategoriasConFormato()
                    + "</html>");
            lbDescripcion.setText(sb.toString());
            // Coloca el titulo de la imagen
            lbImagen.setBorder(javax.swing.BorderFactory.createTitledBorder(products.get(i).getName()));
            // Coloca la imagen
            String nameString = products.get(i).getUrlImagen();
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            ImageIcon imageIcon = Utilities.loadImageFromCloud(nameString);
            if (imageIcon != null) {
                lbImagen.setIcon(imageIcon);
            }
            setCursor(Cursor.getDefaultCursor());
            btnAniadir.setVisible(true);
        }
    }//GEN-LAST:event_lstProductosMouseClicked

    private void cboCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriesActionPerformed
        if (cboCategories.getSelectedIndex() == 0) {
            loadAllProducts();
        } else {
            String[] partes = cboCategories.getSelectedItem().toString().split("-");
            loadProductsByCategory(Long.parseLong(partes[0]));
        }
    }//GEN-LAST:event_cboCategoriesActionPerformed

    private void btnAniadirProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirProductoActionPerformed
        AgregarProductoGUI instance = new AgregarProductoGUI(categoryService,productService);
        instance.setVisible(true);
    }//GEN-LAST:event_btnAniadirProductoActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnAniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirActionPerformed
        if(products.get(lstProductos.getSelectedIndex()).getStock()>0){
            Long id = products.get(lstProductos.getSelectedIndex()).getProductId();
            StockProductoGUI instance = new StockProductoGUI(id,productService, shoppingCartService);
            instance.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "No se puede aniadir, no tiene stock el producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnAniadirActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadir;
    private javax.swing.JButton btnAniadirProducto;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JComboBox<String> cboCategories;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbImagen;
    private javax.swing.JList<String> lstProductos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Object o) {
        loadAllProducts();
        lbImagen.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagen"));
        lbImagen.setIcon(null);
        lbDescripcion.setText("");
        btnAniadir.setVisible(false);
    }
}
