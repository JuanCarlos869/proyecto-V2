/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.pago.common.entities;

/**
 *
 * @author usuario
 */
public class Pago {
    private String codigoCuenta;
    private double totalPago;
    /**
     * Código del país donde será entregado el producto.
     * */
    private String plataformaPago;

    public Pago(String codigoCuenta, double totalPago, String plataformaPago) {
        this.codigoCuenta = codigoCuenta;
        this.totalPago = totalPago;
        this.plataformaPago = plataformaPago;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

    public String getPlataformaPago() {
        return plataformaPago;
    }

    public void setPlataformaPago(String plataformaPago) {
        this.plataformaPago = plataformaPago;
    }
    
}
