package co.com.hyunseda.market.access;

import co.com.hyunseda.market.infra.Utilities;

public class Factory {

    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta del repositorio
     *
     * @return una clase hija del repositorio
     */
    
    public IProductRepository getRepository() {

        IProductRepository result = null;
        String type = Utilities.loadProperty("ProductRepository");
        switch (type) {
            case "default":
                result = new ProductRepository();
                break;
        }
        return result;
    }
}
