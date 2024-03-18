/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.unicauca.pago.plugins.googlepay;

import co.unicauca.pago.common.entities.Pago;
import co.unicauca.pago.common.interfaces.IPagoPlugin;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GooglepayPagoPlugin implements IPagoPlugin{
    String filePath;
    @Override
    public boolean paySimulated(Pago pago) {
        this.filePath = "datosCuentasGooglePay.txt"; // Nombre del archivo sin la ruta completa

        double saldo=obtenerSaldoCuenta(pago.getCodigoCuenta()); // Código de cuenta buscado
        if(saldo>pago.getTotalPago()){
            actualizarSaldo(pago.getCodigoCuenta(),saldo-pago.getTotalPago());
            return true;
        }else{
            return false;
        }
        
        
    }
    
    private double obtenerSaldoCuenta(String codigoBuscado){
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";"); // Dividir la línea en partes usando el punto y coma como separador
                if (partes.length == 2) { // Asegurarse de que hay dos partes (código de cuenta y saldo)
                    String codigoCuenta = partes[0].trim(); // Código de cuenta (primera parte)
                    if (codigoCuenta.equals(codigoBuscado)) {
                        String saldo = partes[1].trim(); // Saldo asociado al código de cuenta (segunda parte)
                        return Double.parseDouble(saldo);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    void actualizarSaldo(String codigoBuscado, double nuevoSaldo){
        // Lee todo el contenido del archivo
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reemplaza el saldo antiguo con el nuevo saldo
        String contenidoActualizado = contenido.toString().replaceAll(codigoBuscado + ";.*", codigoBuscado + ";" + nuevoSaldo);

        // Escribe el contenido actualizado de vuelta al archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(contenidoActualizado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}