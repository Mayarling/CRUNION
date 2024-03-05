package com.crunion.logica;

import com.crunion.dominio.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase es para agregar, editar y borrar datos de un cliente.
 * 
 * @author Mayarling Martínez.
 */
public class ServicioCliente {
    private Archivo archivoDeClientes;
    
    /**
     * Constructor para el objeto ServicioCliente
     */
    public ServicioCliente(){
        this.archivoDeClientes = new Archivo("clientes.dat");
    }
    
    /**
     * Método para agregar nuevo cliente.
     * 
     * @param nuevoCliente El objeto que representa el nuevo cliente.
     * 
     * @throws Exception En caso de que haya algún error al guardar el cliente.
     */
    public void agregarCliente(Cliente nuevoCliente) throws Exception{
        this.validarCliente(nuevoCliente);
        if(!this.existeCliente(nuevoCliente)){
            this.archivoDeClientes.agregar(nuevoCliente.toString());
        } else {
            throw new Exception("Ya existe un cliente con ID: "  +nuevoCliente.getIdCliente());
        }
    }
    
    /**
     * Método para obtener todos los clientes existentes.
     * 
     * @return Una lista de tipo cliente con todos los clientes exisistentes.
     */
    public List<Cliente> obtenerClientes(){
        List<Cliente> clientes = new ArrayList<>();
        try {
            List<String> lineasDeTexto = this.archivoDeClientes.leer();
            for(String linea : lineasDeTexto){
                Cliente cliente = new Cliente(linea);
                clientes.add(cliente);
            }
        } catch(Exception e) {
            System.out.println("Error al leer los clientes ("+e.getMessage()+").");
        }
        return clientes;
    }
    
    /**
     * Método para editar cliente existente.
     * 
     * @param clienteActualizado El objeto clienet con los datos actualizados.
     * @throws0 Exception En caso de que haya algún error al editar el cliente.
     */
    public void editarCliente(Cliente clienteActualizado) throws Exception{
        this.validarCliente(clienteActualizado);
        if(this.existeCliente(clienteActualizado)){
            // PENDIENTE VALIDAR SI TIENE CONVERSIONES EXISTENTES PARA SABER SI SE PUEDE O NO CAMBIAR EL ID
            // Obtenemos la lista de clientes
            List<Cliente> clientes = this.obtenerClientes();
            this.archivoDeClientes.reiniciarArchivo();
            for(Cliente clienteEnMemoria : clientes) {
                if(clienteEnMemoria.getIdCliente() == clienteActualizado.getIdCliente()) {
                    this.archivoDeClientes.agregar(clienteActualizado.toString());
                } else {
                    this.archivoDeClientes.agregar(clienteEnMemoria.toString());
                }
            }
        } else {
            throw new Exception("El cliente con ID: " + clienteActualizado.getIdCliente() + " no existe.");
        }
    }
    
    /**
     * Método para borrar un cliente dado su ID.
     * 
     * @param idCliente El ID del cliente que se quiere eliminar.
     * @throws java.lang.Exception.
     */
    public void borrarCliente(int idCliente) throws Exception{
        // PENDIENTE VALIDAR EN EL BORRADO QUE NO SE PUEDE BORRAR SI TIENE CONVERSIONES REGISTRADAS
        if(this.existeCliente(idCliente)) {
            List<Cliente> clientesEnMemoria = this.obtenerClientes();
            this.archivoDeClientes.reiniciarArchivo();
            for(Cliente clienteEnMemoria : clientesEnMemoria) {
                if(clienteEnMemoria.getIdCliente() != idCliente) {
                    this.archivoDeClientes.agregar(clienteEnMemoria.toString());
                }
            }
        }
    }
    
    /**
     * Método para validar un objeto de tipo Cliente.
     * 
     * @param cliente El cliente a validar
     * @throws Exception En caso de que haya un error de validación.
     */
    private void validarCliente(Cliente cliente) throws Exception {
        if(cliente.getIdCliente() <= 0 || cliente.getIdCliente() > 999999999) {
            throw new Exception("El id es invalido. Debe estar en el rango entre 1 y 999999999");
        }
        if(cliente.getEdad() < 18) {
            throw new Exception("El cliente debe ser mayor de 18 años.");
        }
        if(cliente.getEdad() > 120) {
            throw new Exception("Que buena salud tiene ud, sin embargo por su avanzada edad, tampoco se le permite el registro.");
        }
        if(cliente.getNombre() == null || cliente.getNombre().trim().equals("")) {
            throw new Exception("El nombre del cliente es requerido.");
        }
        if(cliente.getApellidos() == null || cliente.getApellidos().trim().equals("")) {
            throw new Exception("Los apellidos del cliente son requeridos.");
        }
        if(cliente.getNacionalidad() == null || cliente.getNacionalidad().trim().equals("")) {
            throw new Exception("La nacionalidad del cliente es requerida.");
        }
    }
    
    /**
     * Método para verificar si un cliente ya existe o no.
     * 
     * @param cliente El cliente a verificar.
     * @return true si el cliente ya existe en el archivo de clientes, false si no.
     */
    private boolean existeCliente(Cliente cliente) {
        return this.existeCliente(cliente.getIdCliente());
    }
    
    /**
     * Método para verificar si un cliente ya existe o no.
     * 
     * @param idCliente El ID del cliente a verificar.
     * @return true si el cliente ya existe en el archivo de clientes, false si no.
     */
    public boolean existeCliente(int idCliente) {
        boolean clienteExiste = false;
        List<Cliente> clientes = this.obtenerClientes();
        for(Cliente clienteDelArchivo : clientes) {
            if(clienteDelArchivo.getIdCliente() == idCliente) {
                clienteExiste = true;
                break;
            }
        }
        return clienteExiste;
    }
    
    /**
     * Método para obtener un cliente por su ID.
     * @param idCliente El ID del cliente.
     * @return Retorna el objeto cliente asociado al Id o null si no existe ningún cliente para ese ID.
     */
    public Cliente obtenerCliente(int idCliente){
        Cliente cliente = null;
        List<Cliente> clientes = this.obtenerClientes();
        for(Cliente clienteDelArchivo : clientes) {
            if(clienteDelArchivo.getIdCliente() == idCliente) {
                cliente = clienteDelArchivo;
                break;
            }
        }
        return cliente;
    }
}
