/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.service;

import co.com.hyunseda.market.entities.Product;
import co.com.hyunseda.market.entities.ShoppingCart;
import co.com.hyunseda.market.entities.User;
import co.com.hyunseda.market.infra.Subject;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author JUAN CARLOS MELO
 */
public class ShoppingCartService extends Subject{
    private ShoppingCart cart;
   
    public ShoppingCartService(User user) {
        ShoppingCart aux = new ShoppingCart();
        aux.setUser(user);
        aux.setCarro(new ArrayList<Product>());
        this.cart = aux;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }
    
    public void aniadirProducto(Product producto){
        ArrayList<Product> auxiliar = cart.getCarro();
        auxiliar.add(producto);
        cart.setCarro(auxiliar);
        this.notifyAllObserves();
    }
    
    public void eliminarProducto(Long idEliminar){
        ArrayList<Product> auxiliar = cart.getCarro();
        int i;
        for(i = 0; i<auxiliar.size();i++){
            if(Objects.equals(auxiliar.get(i).getProductId(), idEliminar)){
                auxiliar.remove(i);
                break;
            }
        }
        cart.setCarro(auxiliar);
        this.notifyAllObserves();
    }
    
    public boolean verificarExistencia(Long buscado){

        for(Product p : cart.getCarro()){
            if(Objects.equals(p.getProductId(), buscado)){
                return true;
            }
        }
        return false;
    }
    
    public void vaciarCarrito(){
        this.cart.setCarro(new ArrayList<Product>());
        this.notifyAllObserves();
    }
    
}

