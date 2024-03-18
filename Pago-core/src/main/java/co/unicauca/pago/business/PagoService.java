/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.pago.business;

import co.unicauca.pago.common.entities.Pago;
import co.unicauca.pago.common.interfaces.IPagoPlugin;
import co.unicauca.pago.plugin.manager.PagoPluginManager;

/**
 *
 * @author usuario
 */
public class PagoService {
    public boolean realizarPaySimulated(Pago pagoData) throws Exception {

        String metodoPago = pagoData.getPlataformaPago();
        PagoPluginManager manager = PagoPluginManager.getInstance();
        IPagoPlugin plugin = manager.getDeliveryPlugin(metodoPago);

        if (plugin == null) {
            throw new Exception("No hay un plugin disponible para el metodo de pago indicado: " + metodoPago);
        }

        return plugin.paySimulated(pagoData);
    }
}
