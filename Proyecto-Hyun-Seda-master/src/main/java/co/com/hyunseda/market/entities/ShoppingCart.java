/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.entities;

import java.util.ArrayList;

/**
 *
 * @author JUAN CARLOS MELO
 */
public class ShoppingCart {
    private User user;
    private ArrayList<Product> carro;

    public ShoppingCart() {
    }
    

    public ShoppingCart(User user, ArrayList<Product> carro) {
        this.user = user;
        this.carro = carro;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Product> getCarro() {
        return carro;
    }

    public void setCarro(ArrayList<Product> carro) {
        this.carro = carro;
    }
    
    
}
