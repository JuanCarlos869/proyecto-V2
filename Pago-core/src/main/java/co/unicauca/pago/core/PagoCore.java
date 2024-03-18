/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.unicauca.pago.core;

import co.unicauca.pago.business.PagoService;
import co.unicauca.pago.common.entities.Pago;
import co.unicauca.pago.plugin.manager.PagoPluginManager;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class PagoCore {
    
    public boolean pagar(String codigoCuenta, double totalPago, String plataformaPago,String filepath) {
        //Inicializar el plugin manager con la ruta base de la aplicación.
        String basePath = filepath;
        try {
            PagoPluginManager.init(basePath);
            PagoService pagoService = new PagoService();
            //Creamos el objeto que será pasado a la capa de dominio para que se haga el cálculo.
            Pago pagoEntity = new Pago(codigoCuenta, totalPago, plataformaPago);
            boolean pagoExitoso = pagoService.realizarPaySimulated(pagoEntity);
            return pagoExitoso;


        } catch (Exception ex) {
            Logger.getLogger("Application").log(Level.SEVERE, "Error al ejecutar la aplicación", ex);
            return false;            
        }
        
    }
    
    /**
     * Obtiene la ruta base donde está corriendo la aplicación, sin importar que
     * sea desde un archivo .class o desde un paquete .jar.
     *
     */
    /*
    private String getBaseFilePath() {
        try {
            String path = PagoCore.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            path = URLDecoder.decode(path, "UTF-8"); //This should solve the problem with spaces and special characters.
            File pathFile = new File(path);
            if (pathFile.isFile()) {
                path = pathFile.getParent();
                
                if (!path.endsWith(File.separator)) {
                    path += File.separator;
                }
            }

            return path;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PagoCore.class.getName()).log(Level.SEVERE, "Error al eliminar espacios en la ruta del archivo", ex);
            return null;
        }
    }*/
}
