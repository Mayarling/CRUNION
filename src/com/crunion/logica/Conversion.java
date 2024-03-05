package com.crunion.logica;

import com.crunion.dominio.Equivalencia;

/**
 * La clase conversion tiene los métodos para covertir de una Equivalencia a otra
 * 
 * @author Mayarling Martinez.
 */
public class Conversion {
    
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
     * monto a su equivalencia de monedaDestino.
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
    
    /**
     * metodo para comprar dolares de acuerdo con el enunciado de la tarea
     * @param moneda_destino moneda de destino
     * @param montoEnDolares monto en dolares
     * @return total en moneda destino
     */
    public double CompraDolares(String moneda_destino, double montoEnDolares){
        double total = 0;
        Equivalencia objeto1 = new Equivalencia(100);
        total = this.convertirDolarAEquivalencia(montoEnDolares, Equivalencia.equivalencias.get(objeto1.PosicionMoneda(moneda_destino)));
        return total;
    }
    
    /**
     * metodo para vender dolares de una moneda de origen de acuerdo con el enunciado de la tarea
     * @param moneda_origen Moneda de origen
     * @param montoOrigen monto origen
     * @return total en dolares
     */
    public double VentaDolares(String moneda_origen, double montoOrigen){
        double total = 0;
        Equivalencia objeto1 = new Equivalencia(100);
        total = this.convertirEquivalenciaADolares(montoOrigen, Equivalencia.equivalencias.get(objeto1.PosicionMoneda(moneda_origen)));
        return total;
    }
    
    /**
     * Metodo para tomar el monto de dinero que viene en la moneda origen y devolver
     * el monto correspondiente en la moneda destino de acuerdo con el enunciado de la tarea
     * @param moneda_origen Moneda origen
     * @param moneda_destino Moneda destino
     * @param montoInicial Monto inicial
     * @return Total de la moneda destino
     */
    public double Conversion_monedas(String moneda_origen, String moneda_destino, double montoInicial){
        double total = 0;
        Equivalencia objeto1 = new Equivalencia(100);
        Equivalencia equivalenciaOrigen = Equivalencia.equivalencias.get(objeto1.PosicionMoneda(moneda_origen));
        Equivalencia equivalenciaDestino = Equivalencia.equivalencias.get(objeto1.PosicionMoneda(moneda_destino));
        total = this.convertirEntreEquivalencias(montoInicial, equivalenciaOrigen, equivalenciaDestino);
        return total;
    }
}
