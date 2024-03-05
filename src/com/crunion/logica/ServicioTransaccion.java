package com.crunion.logica;

import com.crunion.dominio.Cliente;
import com.crunion.dominio.Transaccion;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para proveer los métodos necesarios para soportar guardar transacciones por cliente,
 * asi como obtener las transacciones de un cliente.
 * 
 * @author Mayarling Martinez
 */
public class ServicioTransaccion {
    
    /**
     * Metodo para guardar una transaccion asociada a un cliente.
     * 
     * @param cliente El cliente que realizo la transacción.
     * @param transaccion La transaccion como tal.
     * @throws Exception En caso de que pase algún error.
     */
    public void agregarTransaccion(Cliente cliente, Transaccion transaccion) throws Exception {
        Archivo archivoDeCliente = new Archivo(Integer.toString(cliente.getIdCliente()) + ".dat");
        archivoDeCliente.agregar(transaccion.toString());
    }
    
    /**
     * Metodo para obtener todas las transacciones de un cliente es especifico.
     * 
     * @param cliente El cliente
     * @return Una lista de objetos Transaccion asociados al cliente, o una lista vacia si no hay transacciones.
     */
    public List<Transaccion> obtenerTransacciones(Cliente cliente) {
        List<Transaccion> transaccionesDelCliente = new ArrayList<>();
        Archivo archivoDeCliente = new Archivo(Integer.toString(cliente.getIdCliente()) + ".dat");
        try {
            List<String> transaccionesEnTexto = archivoDeCliente.leer();
            for(String transaccionEnTexto : transaccionesEnTexto) {
                Transaccion transaccion = new Transaccion(transaccionEnTexto);
                transaccionesDelCliente.add(transaccion);
            }
        } catch(Exception e) {
            System.out.println("Error al leer las transaciones del cliente " + cliente.getIdCliente() + "(" + e.getMessage() + ")");
        }
        return transaccionesDelCliente;
    }
    
    /**
     * Metodo para obtener TODAS las transacciones de TODOS los clientes.
     * 
     * @return Una lista de objetos transaccion de todos los clientes, o una lista vacia si no hay transacciones.
     */
    public List<Transaccion> obtenerTransacciones() {
        List<Transaccion> transacciones = new ArrayList<>();
        ServicioCliente servicioCliente = new ServicioCliente();
        List<Cliente> clientes = servicioCliente.obtenerClientes();
        try {
            for(Cliente cliente : clientes){
                Archivo archivoDeCliente = new Archivo(Integer.toString(cliente.getIdCliente()) + ".dat");
                List<String> transaccionesEnTexto = archivoDeCliente.leer();
                for(String transaccionEnTexto : transaccionesEnTexto) {
                    Transaccion transaccion = new Transaccion(transaccionEnTexto);
                    transacciones.add(transaccion);
                }
            }
        } catch(Exception e) {
            System.out.println("Error al leer las transaciones (" + e.getMessage() + ")");
        }
        return transacciones;
    }
}
