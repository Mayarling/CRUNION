package com.crunion.logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase es para soportar leer y escribir datos a un archivo.
 * 
 * @author Mayarling Martinez
 */
public class Archivo {
    private String nombre;
    private File archivo;
   
    /**
     * Se crea un nuevo objeto de tipo Archivo.
     * @param nombre El nombre del archivo.
     */
    public Archivo(String nombre){
        this.nombre = nombre; 
        this.archivo = new File(nombre);
    }
   
    /**
     * Método para agregar una linea de texto a un archivo.
     * 
     * @param lineaDeTexto Linea de texto.
     * 
     * @throws Exception Exception en caso de que haya algun error al guardar los datos.
     */
    public void agregar(String lineaDeTexto) throws Exception{
        try {
             PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
             salida.println(lineaDeTexto);
             salida.close();
        } catch(IOException ioe){
            ioe.printStackTrace();
            throw new Exception("Error al guardar los datos: "+ioe.getMessage(), ioe);
        }
    }
   
    /**
     * Método que lee de un archivo y devuelve una lista de String que representa las linea de contenido del archivo.
     * 
     * @return Retorna una lista con las linea de texto del archivo.
     * 
     */
    public List<String> leer() {
        List<String> lineasDeTexto = new ArrayList<>();
        String linea = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            do{
                linea = entrada.readLine();
                if(linea != null){
                    lineasDeTexto.add(linea); 
                }
             } while(linea != null);
            entrada.close();
        } catch(IOException ioe){
            System.out.println("Error al leer los datos: "+ioe.getMessage());
        }
        return lineasDeTexto;
    }
   
    /**
     * Permite reiniciar el archivo, de manera que se borra todo su contenido.
     * 
     * @throws Exception Exception en caso de que haya algun error al reiniciar el archivo.
     */
    public void reiniciarArchivo() throws Exception{
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.print("");
            salida.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
            throw new Exception("Error al reiniciar el archivo: "+ioe.getMessage(), ioe);
        }
    }
}
