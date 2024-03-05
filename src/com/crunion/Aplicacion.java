package com.crunion;

import com.crunion.gui.CRUnion;

/**
 *Esta clase es para el metodo principal del programa
 * @author Mayarling Martinez
 */
public class Aplicacion {
    /**
     * Método principal del programa
     * @param args los argumentos del programa
     */
    public static void main(String[] args) {
        CRUnion ventana = new CRUnion();
        ventana.setBounds(0,0,380,510);
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
    }
}
