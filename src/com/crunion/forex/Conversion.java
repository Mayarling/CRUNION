package com.crunion.forex;

/**
 * La clase conversion tiene los métodos para covertir de una Equivalencia a otra
 * @author Mayarling Martinez.
 */
public class Conversion {
    /**
     * Aquí iniciamos el constructor de Conversion
     */
    public Conversion(){
        
    }
    
    /**
     * Este método convierte dolares a la cantidad deseada de la moneda de destino.
     * @param montoDolares El monto en dolares
     * @param equivalencia La equivalencia de una moneda a dolares.
     * @return El monto en la equivalencia
     */
    public double convertirDolarAEquivalencia(double montoDolares, Equivalencia equivalencia){
        return montoDolares * equivalencia.getPrecioCompra();
    }
    
    /**
     * Este método convierte un monto de una equivalencia especifica a dolares.
     * @param montoEquivalencia El monto en moneda equivalente
     * @param equivalencia La equivalencia del monto
     * @return El monto en dolares de la equivalencia indicada.
     */
    public double convertirEquivalenciaADolares(double montoEquivalencia, Equivalencia equivalencia){
        return montoEquivalencia / equivalencia.getPrecioVenta();
    }
    
    /**
     * Este método convierte un monto determinado de una equivalencia a su correspondiente 
 monto a su equivalencia de monedaDestino.
     * @param monto Es el monto de equivalencia de monedaOrigen
     * @param monedaOrigen Es la equivalencia de monedaOrigen.
     * @param monedaDestino Equivalencia de monedaDestino
     * @return El monto en la equivalencia de monedaDestino
     */
    public double convertirEntreEquivalencias(double monto, Equivalencia monedaOrigen, Equivalencia monedaDestino){
        double montoEnDolares = 0;
        double montoDestino = 0;
        if (monedaOrigen.getCodigo().equals("USD")){
            montoEnDolares = monto;
        } else {
            montoEnDolares = convertirEquivalenciaADolares(monto, monedaOrigen);
        }
        if (monedaDestino.getCodigo().equals("USD")){
            montoDestino = montoEnDolares;
        } else{
            montoDestino = convertirDolarAEquivalencia(montoEnDolares, monedaDestino);
        }
        return montoDestino;
    }
}
