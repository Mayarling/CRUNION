package com.crunion.forex;

/**
 * El objeto Equivalencia tiene un descripcionMoneda que la identifica y un precio de compra
 y un precio de venta.
 * 
 * @author Mayarling Martinez.
 */
public class Equivalencia {
    // Aqui se indican los atributos del objeto Equivalencia.
    private String codigo;
    private String descripcionMoneda;
    private double precioCompra;
    private double precioVenta;
    
    public static final Equivalencia[] equivalencias = new Equivalencia[]{
        new Equivalencia("Dólar Estado Unidense", 1, 1, "USD"),
        new Equivalencia("Euro", 0.85, 0.91, "EUR"),
        new Equivalencia("Colon", 660, 670, "CRC"),
        new Equivalencia("Peso Mexicano", 20, 20.5, "MXN"),
        new Equivalencia("Córdoba oro", 33, 36, "NIO"),
        new Equivalencia("Peso Argentino", 110, 112.5,"ARS"),
        new Equivalencia("Libra esterlina", 0.70, 0.76, "GBP"),
        new Equivalencia("Yen", 119, 122.5, "JPY")
    };
   
    
    /**
     * Se crea un nuevo objeto de tipo Equivalencia
     */
    public Equivalencia(){
        this.codigo = "";
        this.descripcionMoneda = "No indicado";
        this.precioCompra = 1;
        this.precioVenta = 1;
    }
    
    /**
     * Se crea un nuevo objeto de tipo Equivalencia
     * @param descripcionMoneda El descripcionMoneda del objeto equivalencia
     * @param precioCompra Este es el precio de compra de la Equivalencia
     * @param precioVenta Este es el precio de venta de la Equivalencia
     */
    public Equivalencia(String descripcionMoneda, double precioCompra, double precioVenta, String codigo){
        this.codigo = codigo;
        this.descripcionMoneda = descripcionMoneda;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcionMoneda() {
        return descripcionMoneda;
    }

    public void setDescripcionMoneda(String descripcionMoneda) {
        this.descripcionMoneda = descripcionMoneda;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    @Override
    public String toString (){
        return "("+this.codigo+") "+ this.descripcionMoneda;
    }
}
