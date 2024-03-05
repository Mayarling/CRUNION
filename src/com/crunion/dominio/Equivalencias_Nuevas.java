package com.crunion.dominio;

import static com.crunion.dominio.Equivalencia.equivalencias;

/**
 * Esta clase se crea para aplicar la herencia como se solicita en la tarea #2.
 * @author Mayarling Martinez
 */
public class Equivalencias_Nuevas extends Equivalencia {

    public Equivalencias_Nuevas() {
        super();
    }
    
    /**
     * Constructor por parametro.
     * 
     * @param cantidadPaises La cantidad de paises
     */
    public Equivalencias_Nuevas(int cantidadPaises) {
        super(cantidadPaises);
    }
    
    /**
     * Método para agregar nueva equivalencia.
     * @param nuevaEquivalencia nueva equivalencia.
     */
    public void Agregar_Nueva_Equivalencia (Equivalencia nuevaEquivalencia) throws Exception {
        //falta por implentar
        for(int i = 0; i < equivalencias.size(); i++){
            Equivalencia equivalenciaExistente = equivalencias.get(i);
            // Verificamos que el codigo de la nueva equivalencia no exista
            if(equivalenciaExistente.getCodigo().equalsIgnoreCase(nuevaEquivalencia.getCodigo())) {
                throw new Exception("El código " + nuevaEquivalencia.getCodigo() + " ya existe.");
            }
            // Verificamos que la descripción de la nueva equivalencia no exista.
            if(equivalenciaExistente.getDescripcionMoneda().equalsIgnoreCase(nuevaEquivalencia.getDescripcionMoneda())) {
                throw new Exception("La descripción " + nuevaEquivalencia.getDescripcionMoneda() + " ya existe.");
            }
        }
        // Si a este momento no ha tirado ninguna exception, la nueva equivalencia
        // ES VALIDA ya que no hay ninguna equivalencia existente con el mismo codigo
        // ni descripción
        equivalencias.add(nuevaEquivalencia);
    }
    
    /**
     * Método para actualizar los valores de equivalencia.
     * 
     * @param codigo El código de la equivalencia que se va a actualizar.     
     * @param precioCompraNuevo El nuevo precio de compra.
     * @param precioVentaNuevo El nuevo precio de venta.
     */
    public void Actualizar_Valores_Equivalenciad(String codigo, double precioCompraNuevo, double precioVentaNuevo){
        for(int i = 0; i < equivalencias.size(); i++) {
            Equivalencia equivalenciaExistente = equivalencias.get(i);
            // Si el codigo es el correspondiente, actualizamos la des
            if(equivalenciaExistente.getCodigo().equalsIgnoreCase(codigo)){
                equivalenciaExistente.setPrecioCompra(precioCompraNuevo);
                equivalenciaExistente.setPrecioVenta(precioVentaNuevo);
            }
        }
    }
}
