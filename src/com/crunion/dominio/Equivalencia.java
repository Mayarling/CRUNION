package com.crunion.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * El objeto Equivalencia tiene una descripcionMoneda que la identifica y un precio de compra
 * y un precio de venta, codigo, cantidadPaises y los atributos requerdios por la tarea que son
 * descrpciones_monedas y tabla_conversiones.
 * 
 * @author Mayarling Martinez.
 */
public class Equivalencia {
    // Aqui se indican los atributos del objeto Equivalencia.
    private String codigo;
    private String descripcionMoneda;
    private double precioCompra;
    private double precioVenta;
    private int cantidadPaises;
    
    // Atributos que son requeridos por la tarea 1
    private String[] Descripciones_moneda;
    private double[][] Tabla_conversiones;
    
    /**
     * Arreglo estatico que contiene todas las equivalencias del programa
     */
    public static final List<Equivalencia> equivalencias = new ArrayList<>();
    
    static {
        equivalencias.add(new Equivalencia("Dólar Estado Unidense", 1, 1, "USD"));
        equivalencias.add(new Equivalencia("Euro", 0.85, 0.91, "EUR"));
        equivalencias.add(new Equivalencia("Colon", 660, 670, "CRC"));
        equivalencias.add(new Equivalencia("Peso Mexicano", 20, 20.5, "MXN"));
        equivalencias.add(new Equivalencia("Córdoba oro", 33, 36, "NIO"));
        equivalencias.add(new Equivalencia("Peso Argentino", 110, 112.5,"ARS"));
        equivalencias.add(new Equivalencia("Libra esterlina", 0.70, 0.76, "GBP"));
        equivalencias.add(new Equivalencia("Yen", 119, 122.5, "JPY"));
    }
    
    /**
     * Se crea un nuevo objeto de tipo Equivalencia
     */
    public Equivalencia(){
        this.codigo = "";
        this.descripcionMoneda = "No indicado";
        this.precioCompra = 1;
        this.precioVenta = 1;
        this.cantidadPaises = 8;
    }
    
    /**
     * Constructor cantidadDePaises.
     * @param cantidadDePaises 
     */
    public Equivalencia(int cantidadDePaises){
        this.codigo = "";
        this.descripcionMoneda = "No indicado";
        this.precioCompra = 1;
        this.precioVenta = 1;
        this.cantidadPaises = cantidadDePaises;
        
    }
    
    /**
     * Se crea un nuevo objeto de tipo Equivalencia.
     * @param descripcionMoneda El descripcionMoneda del objeto equivalencia.
     * @param precioCompra Este es el precio de compra de la Equivalencia.
     * @param precioVenta Este es el precio de venta de la Equivalencia.
     * @param codigo  El código de país.
     */
    public Equivalencia(String descripcionMoneda, double precioCompra, double precioVenta, String codigo){
        this.codigo = codigo;
        this.descripcionMoneda = descripcionMoneda;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cantidadPaises = 8;
    }
    
    /**
     * Se crea un nuevo objeto de tipo Equivalencia.
     * @param descripcionMoneda El descripcionMoneda del objeto equivalencia.
     * @param precioCompra Este es el precio de compra de la Equivalencia.
     * @param precioVenta Este es el precio de venta de la Equivalencia.
     * @param codigo  El código de país.
     * @param cantidadPaises cantidad de paises.
     */
    public Equivalencia(String descripcionMoneda, double precioCompra, double precioVenta, String codigo, int cantidadPaises){
        if (cantidadPaises < 8 || cantidadPaises > 25){
            throw new IllegalArgumentException("La cantidad de paises es invalida");
        }
        this.codigo = codigo;
        this.descripcionMoneda = descripcionMoneda;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cantidadPaises = cantidadPaises;
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
    
    /**
     * Método accesor de las descripciones de moneda.
     * @return descripciones de moneda.
     */
    public String[] getDescripciones_moneda() {
        if (this.Descripciones_moneda == null){
            //inicializamos el atributo que se solicito.
            this.Descripciones_moneda = new String[this.cantidadPaises];
            for(int i = 0; i < equivalencias.size(); i++){
                Equivalencia equivalencia1 = equivalencias.get(i);
                this.Descripciones_moneda[i] = equivalencia1.getDescripcionMoneda();
            }
        }
        return Descripciones_moneda;
    }

    public void setDescripciones_moneda(String[] Descripciones_moneda) {
        this.Descripciones_moneda = Descripciones_moneda;
    }
    
    /**
     * Método accesor de tabla conversiones.
     * @return tabla conversion.
     */
    public double[][] getTabla_conversiones() {
        if(this.Tabla_conversiones == null){
            // inicializamos el atributo Tabla_conversiones
            this.Tabla_conversiones = new double[this.cantidadPaises][2];
            for(int i = 0; i < equivalencias.size(); i++){
                Equivalencia equivalencia2 = equivalencias.get(i);
                this.Tabla_conversiones[i][0] = equivalencia2.getPrecioCompra();
                this.Tabla_conversiones[i][1] = equivalencia2.getPrecioVenta();
            }
        }
        return Tabla_conversiones;
    }

    public void setTabla_conversiones(double[][] Tabla_conversiones) {
        this.Tabla_conversiones = Tabla_conversiones;
    }
    
    /**
     * Sobre escribimos el metodo toString.
     * @return una representación en string de la equivalencia.
     */
    @Override
    public String toString (){
        return "("+this.codigo+") "+ this.descripcionMoneda;
    }
    
    /**
     * Este método recibe el tipo de moneda origen y devuelve la fila en la que se encuentra la misma.
     * @param moneda_origen la descripcion de la moneda de origen.
     * @return la fila en la que se encuentra el precio de venta y compra la moneda de origen.
     * @throws NoSuchElementException En caso en que no exista la moneda de origen.
     */
    public int PosicionMoneda(String moneda_origen) throws NoSuchElementException{
        int posicion = -1;
        for(int i = 0; i < this.getDescripciones_moneda().length; i++){
            String nombreMoneda = this.getDescripciones_moneda()[i];
            if(nombreMoneda.equals(moneda_origen)){
                posicion = i;
                break;
            }        
        }
        if (posicion >= 0){
            return posicion;
        } else {
            throw new NoSuchElementException("La moneda " + moneda_origen + " no existe.");
        }
    }
    
    /**
     * Este método recibe el tipo de moneda origen y devuelve el valor del precio de compra.
     * @param moneda_origen La descrpción de la moneda de origen.
     * @return El precio de compra o cero si la moneda no exisiste.
     */
    public double PrecioCompra(String moneda_origen){
        double precioCompra = 0;
        try {
            int posicionMoneda = this.PosicionMoneda(moneda_origen);
            precioCompra = this.getTabla_conversiones()[posicionMoneda][0];
        } catch(NoSuchElementException error){
            error.printStackTrace();
        }
        return precioCompra;
    }
    
    /**
     * Este método recibe el tipo de moneda origen y devuelve el valor del precio de dicha moneda.
     * @param moneda_origen la descripción de la moneda de origen.
     * @return el precio de venta o cero si la moneda no exisiste
     */
    public double PrecioVenta(String moneda_origen){
        double precioVenta = 0;
        try{
            int posicionMoneda = this.PosicionMoneda(moneda_origen);
            precioVenta = this.getTabla_conversiones()[posicionMoneda][1];
        } catch(NoSuchElementException error){
            error.printStackTrace();
        }
        return precioVenta;
    }
}
