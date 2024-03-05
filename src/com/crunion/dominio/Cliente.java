package com.crunion.dominio;

/**
 * Clase cliente solicitada en en la tarea, esta clase tiene la función de administrar archivo.
 * 
 * @author Mayarling Martinez
 */
public class Cliente {
    // Aqui declaramos los atributos de la clase cliente.
    private int idCliente;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private int edad;
    
    /**
     * Constructor por defecto.
     */
    public Cliente(){
        this.idCliente = 0;
        this.nombre = null;
        this.apellidos = null;
        this.nacionalidad = null;
        this.edad = 0;
    }
    
    /**
     * Se crea un nuevo objeto de tipo Cliente.
     * @param idCliente el id del cliente.
     * @param nombre El nombre del cliente.
     * @param apellidos Los appelidos del cliente.
     * @param nacionalidad La nacionalidad del cliente.
     * @param edad La edad del cliente.
     */
    public Cliente(int idCliente, String nombre, String apellidos, String nacionalidad, int edad){
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
    }
    
    /**
     * Se crea un nuevo objeto de tipo Cliente con base en una representación String del mismo.
     * 
     * La representación debe ser como el valor retornado por el metodo toString.
     * 
     * @param representacionDeCliente Representación del Cliente en formato id|nombre|apellidos|nacionalidad|edad.
     */
    public Cliente(String representacionDeCliente) throws Exception{
        String[] partes = representacionDeCliente.split("\\|");
        if(partes.length != 5) {
            throw new Exception("El formato del cliente es invalido.");
        }
        try {
            this.idCliente = Integer.parseInt(partes[0]);
        } catch(NumberFormatException nfe){
            nfe.printStackTrace();
            throw new Exception("El ID del registro del cliente no tiene un formato valido.", nfe);
        }
        this.nombre = partes[1];
        this.apellidos = partes[2];
        this.nacionalidad = partes[3];
        try {
            this.edad = Integer.parseInt(partes[4]);
        } catch(NumberFormatException nfe){
            nfe.printStackTrace();
            throw new Exception("La edad del cliente no tiene un formato valido.", nfe);
        }
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getNombreCompleto(){
        return this.nombre + " " + this.apellidos;
    }

    /**
     * Sobreescribimos el metodo toString para poder obtener una representación del objeto
     * cliente de manera que pueda ser guardado en una linea de texto en un archivo.
     * 
     * El formato es: id|nombre|apellidos|nacionalidad|edad.
     * 
     * @return Un String que representa a este objeto Cliente.
     */
    @Override
    public String toString() {
        return this.idCliente+"|"+this.nombre+"|"+this.apellidos+"|"+this.nacionalidad+"|"+this.edad;
    }
}
