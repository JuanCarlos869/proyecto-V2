/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.pago.common.interfaces;


import co.unicauca.pago.common.entities.Pago;

/**
 *
 * @author usuario
 */
public interface IPagoPlugin {
    /**
     * Establece el costo de envío en dólares.
     *
     * @param pago envío
     * @return costo del envío
     */
    boolean paySimulated(Pago pago);
}
