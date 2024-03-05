package com.crunion.logica;

import com.crunion.logica.Conversion;
import com.crunion.dominio.Equivalencias_Nuevas;
import com.crunion.dominio.Equivalencia;

/**
 * Esta clase se crea para heredar de la clase conversion según lo solicitado en la tarea #2
 * @author Mayarling Martinez
 */
public class Conversion_Nueva extends Conversion {

    /**
     * se cobra un impuesto sobre la cantidad final de dólares a vender, según
     * la siguiente tabla
     * 1% si la cantidad de dólares a vender es mayor o igual a 3000 y menor
     * a 6000
     * 2% si la cantidad de dólares a vender es mayor o igual a 6000 y menor
     * a 9000
     * 3% si la cantidad de dólares a vender es mayor o igual a 9000
     * 
     * @param moneda_origen
     * @param montoOrigen
     * @return 
     */
    @Override
    public double VentaDolares(String moneda_origen, double montoOrigen) {
        Equivalencia equivalenciaObjeto = new Equivalencias_Nuevas(100);
        Equivalencia equivalencia = Equivalencia.equivalencias.get(equivalenciaObjeto.PosicionMoneda(moneda_origen));
        double totalEDolares = montoOrigen / equivalencia.getPrecioVenta();
        if(totalEDolares >= 3000 && totalEDolares < 6000){
            totalEDolares = totalEDolares + (totalEDolares * 0.01);   
        } else if(totalEDolares >= 6000 && totalEDolares < 9000){
            totalEDolares = totalEDolares + (totalEDolares * 0.02);   
        } else if(totalEDolares >= 9000){
            totalEDolares = totalEDolares + (totalEDolares * 0.03);
        }
        return totalEDolares;
    }
    
    
    /**
     * El precio de compra de los dólares puede aumentar de forma proporcional a la siguiente tabla
     * 15% de la diferencia entre el precio de compra y precio de venta si la cantidad
     * de dólares a comprar es mayor o igual a 3000 y menor a 6000
     * 25% de la diferencia entre el precio de compra y precio de venta si la
     * cantidad de dólares a comprar es mayor o igual a 6000 y menor a 9000
     * 35% de la diferencia entre el precio de compra y precio de venta si la
     * cantidad de dólares a comprar es mayor o igual a 9000
     * 
     * @param moneda_destino
     * @param montoEnDolares
     * @return 
     */
    @Override
    public double CompraDolares(String moneda_destino, double montoEnDolares) {
        Equivalencia equivalenciaObjeto = new Equivalencias_Nuevas(100);
        Equivalencia equivalencia = Equivalencia.equivalencias.get(equivalenciaObjeto.PosicionMoneda(moneda_destino));
        double precioCompra = equivalencia.getPrecioCompra();
        double diferencia = 0;
        if(equivalencia.getPrecioVenta() >= equivalencia.getPrecioCompra()){
            diferencia = equivalencia.getPrecioVenta() - equivalencia.getPrecioCompra();   
        }else{
            diferencia = equivalencia.getPrecioCompra() - equivalencia.getPrecioVenta();
        }
        
        if(montoEnDolares >= 3000 && montoEnDolares < 6000){
            precioCompra = precioCompra + (diferencia * 0.15);  
        } else if (montoEnDolares >= 6000 && montoEnDolares < 9000){
            precioCompra = precioCompra + (diferencia * 0.25);   
        } else if(montoEnDolares >= 9000){
            precioCompra = precioCompra + (diferencia * 0.35);
        }
        return montoEnDolares * precioCompra;
    }
    
}
