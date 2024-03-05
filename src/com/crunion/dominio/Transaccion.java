package com.crunion.dominio;

/**
 * Clase que representa un registro de una transacción de una conversión.
 * 
 * @author Mayarling Martinez
 */
public class Transaccion {
    // Atributos de la clase Transaccion
    private String codigoMonedaOrigen;
    private String descripcionMonedaOrigen;
    private double montoOrigen;
    
    private String codigoMonedaDestino;
    private String descripcionMonedaDestino;
    private double montoDestino;
    
    /**
     * Constructor por parametros. Permite crear un nuevo objeto transacción con
     * base en la equivalencia de origen y su monto, y la equivalencia de destino y su monto.
     * 
     * @param origen La equivalencia de origen.
     * @param montoOrigen El monto de origen.
     * @param destino La equivalencia de destino.
     * @param montoDestino El monto de destino.
     */
    public Transaccion(Equivalencia origen, double montoOrigen, Equivalencia destino, double montoDestino) {
        this.codigoMonedaOrigen = origen.getCodigo();
        this.descripcionMonedaOrigen = origen.getDescripcionMoneda();
        this.montoOrigen = montoOrigen;
        
        this.codigoMonedaDestino = destino.getCodigo();
        this.descripcionMonedaDestino = destino.getDescripcionMoneda();
        this.montoDestino = montoDestino;
    }
    
    /**
     * Constructor por parametros. Permite crear un nuevo objeto Transacción con base
     * en una representación String de la transacción.
     * 
     * @param representacionDeTransaccion Representación en String de la transacción en formato: 
     * codigoOrigen|descripciónOrigen|montoOrigen|codigoDestino|descripciónDestino|montoDestino
     * 
     * @throws Exception En caso de que haya algún error al intentar crear el objeto.
     */
    public Transaccion(String representacionDeTransaccion) throws Exception {
        String[] partes = representacionDeTransaccion.split("\\|");
        if(partes.length != 6) {
            throw new Exception("El formato de la transacción es invalido.");
        }
        this.codigoMonedaOrigen = partes[0];
        this.descripcionMonedaOrigen = partes[1];
        try {
            this.montoOrigen = Double.parseDouble(partes[2]);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            throw new Exception("El formato del monto de origen no tiene un formato valido.", nfe);
        }
        this.codigoMonedaDestino = partes[3];
        this.descripcionMonedaDestino = partes[4];
        try {
            this.montoDestino = Double.parseDouble(partes[5]);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            throw new Exception("El formato del monto de destino no tiene un formato valido.", nfe);
        }
    }

    public String getCodigoMonedaOrigen() {
        return codigoMonedaOrigen;
    }

    public void setCodigoMonedaOrigen(String codigoMonedaOrigen) {
        this.codigoMonedaOrigen = codigoMonedaOrigen;
    }

    public String getDescripcionMonedaOrigen() {
        return descripcionMonedaOrigen;
    }

    public void setDescripcionMonedaOrigen(String descripcionMonedaOrigen) {
        this.descripcionMonedaOrigen = descripcionMonedaOrigen;
    }

    public double getMontoOrigen() {
        return montoOrigen;
    }

    public void setMontoOrigen(double montoOrigen) {
        this.montoOrigen = montoOrigen;
    }

    public String getCodigoMonedaDestino() {
        return codigoMonedaDestino;
    }

    public void setCodigoMonedaDestino(String codigoMonedaDestino) {
        this.codigoMonedaDestino = codigoMonedaDestino;
    }

    public String getDescripcionMonedaDestino() {
        return descripcionMonedaDestino;
    }

    public void setDescripcionMonedaDestino(String descripcionMonedaDestino) {
        this.descripcionMonedaDestino = descripcionMonedaDestino;
    }

    public double getMontoDestino() {
        return montoDestino;
    }

    public void setMontoDestino(double montoDestino) {
        this.montoDestino = montoDestino;
    }

    /**
     * Metodo para obtener una representación en String de la transacción, que pueda ser guardada en un archivo de texto.
     * 
     * @return Un String que representa la trasacción en el siguiente formato:
     * codigoOrigen|descripciónOrigen|montoOrigen|codigoDestino|descripciónDestino|montoDestino
     */
    @Override
    public String toString() {
        return this.codigoMonedaOrigen + "|" + this.descripcionMonedaOrigen + "|" + this.montoOrigen + "|" + this.codigoMonedaDestino + "|" + this.descripcionMonedaDestino + "|" + this.montoDestino;
    }
}
