package com.crunion.gui;

import com.crunion.dominio.Equivalencia;
import static com.crunion.dominio.Equivalencia.equivalencias;
import com.crunion.dominio.Equivalencias_Nuevas;
import javax.swing.JOptionPane;

/**
 * Clase para editar moneda exisitente
 * @author Mayarling Martinez
 */
public class ActualizarEquivalencia extends javax.swing.JFrame {
    
    private CRUnion ventanaPrincipal;

    /**
     * Creates new form ActualizarEquivalencia
     */
    public ActualizarEquivalencia(CRUnion ventanaPrincipalP) {
        initComponents();
        this.ventanaPrincipal = ventanaPrincipalP;
        this.cargarMonedas();
    }
    
    /**
     * Metodo para validar si el código exisiste.
     * @param codigo
     * @return 
     */
    private boolean validarExistenciaDeCodigo(String codigo){
        boolean existe = false;
        
        for(int i = 0; i < equivalencias.size(); i++){
            Equivalencia equivalenciap = equivalencias.get(i);
            if(equivalenciap.getCodigo().equalsIgnoreCase(codigo) ){
                existe = true;
                break;    
            }  
        }
        return existe;
    }
    
    /**
     * Cargamos las diferentes monedas que estan agregagas.
     */
    private void cargarMonedas(){
        comboMoneda.removeAllItems();
        for(int i = 0; i < Equivalencia.equivalencias.size(); i++){
            Equivalencia equivalencia = Equivalencia.equivalencias.get(i);
            comboMoneda.addItem(equivalencia.toString());    
        }   
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaTitulo = new javax.swing.JLabel();
        etiquetaCodigo = new javax.swing.JLabel();
        etiquetaPrecioCompra = new javax.swing.JLabel();
        campoNuevoPrecio = new javax.swing.JTextField();
        etiquetaPrecioVenta = new javax.swing.JLabel();
        campoPrecioVenta = new javax.swing.JTextField();
        botonguardar = new javax.swing.JButton();
        comboMoneda = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizar moneda");
        setResizable(false);

        etiquetaTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiquetaTitulo.setText("Editar Moneda Existente");

        etiquetaCodigo.setText("Código de la moneda:");

        etiquetaPrecioCompra.setText("Nuevo precio compra:");

        campoNuevoPrecio.setToolTipText("Agregue el nuevo precio de la moneda");
        campoNuevoPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNuevoPrecioActionPerformed(evt);
            }
        });

        etiquetaPrecioVenta.setText("Nuevo precio Venta:");

        campoPrecioVenta.setToolTipText("Agregue el nuevo precio de la moneda");
        campoPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPrecioVentaActionPerformed(evt);
            }
        });

        botonguardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonguardar.setText("Guardar");
        botonguardar.setToolTipText("Click para Guardar");
        botonguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonguardarActionPerformed(evt);
            }
        });

        comboMoneda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboMonedaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(etiquetaCodigo)
                                .addComponent(etiquetaPrecioCompra))
                            .addComponent(etiquetaPrecioVenta))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboMoneda, 0, 115, Short.MAX_VALUE)
                            .addComponent(campoNuevoPrecio)
                            .addComponent(campoPrecioVenta)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(botonguardar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 89, Short.MAX_VALUE)
                .addComponent(etiquetaTitulo)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(etiquetaTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCodigo)
                    .addComponent(comboMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNuevoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaPrecioCompra))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiquetaPrecioVenta)
                    .addComponent(campoPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(botonguardar)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPrecioVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPrecioVentaActionPerformed

    private void botonguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonguardarActionPerformed
        // Bandera para saber si los datos son validos, se asume por defecto que es true
        // y si se encuentra 1 dato invalido se actualiza el valor a false
        boolean datosValidos = true;
        
        // Obtenemos y validamos el codigo de moneda
        String codigoMoneda = equivalencias.get(this.comboMoneda.getSelectedIndex()).getCodigo();
        if(codigoMoneda == null || codigoMoneda.equals("")){
            JOptionPane.showMessageDialog(this, "El código de la moneda es requerido.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        } else if(codigoMoneda.length() != 3) {
            JOptionPane.showMessageDialog(this, "El código de la moneda debe ser de 3 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }
        
        // Obtenemos y validamos el njuevo precio de compra
        String textoPrecioCompra = this.campoNuevoPrecio.getText();
        double precioCompra = 0;
        try{
            precioCompra = Double.parseDouble(textoPrecioCompra);
            if(precioCompra <= 0) {
                JOptionPane.showMessageDialog(this, "El precio de compra no puede ser menor o igual a cero.", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            } else if (precioCompra > 100_000) {
                JOptionPane.showMessageDialog(this, "El precio de compra no puede ser mayor a 100,000.", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "El precio de compra debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }
        
        // Obtenemos y validamos el precio de venta
        String textoPrecioVenta = this.campoPrecioVenta.getText();
        double precioVenta = 0;
        try{
            precioVenta = Double.parseDouble(textoPrecioVenta);
            if(precioVenta <= 0) {
                JOptionPane.showMessageDialog(this, "El precio de venta no puede ser menor o igual a cero.", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            } else if (precioVenta > 100_000) {
                JOptionPane.showMessageDialog(this, "El precio de venta no puede ser mayor a 100,000.", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "El precio de venta debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }
        
        if(validarExistenciaDeCodigo(codigoMoneda) == false){
            JOptionPane.showMessageDialog(this, "El código no existe", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }
        
        // Si los datos son validos, intentamos guardar.
        if(datosValidos) {
            Equivalencias_Nuevas objetoEquivalencias = new Equivalencias_Nuevas();
            objetoEquivalencias.Actualizar_Valores_Equivalenciad(codigoMoneda, precioCompra, precioVenta);
            this.ventanaPrincipal.cargarEquivalencias();
            this.dispose();
        }
    }//GEN-LAST:event_botonguardarActionPerformed

    private void campoNuevoPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNuevoPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNuevoPrecioActionPerformed

    private void comboMonedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboMonedaItemStateChanged
        this.campoNuevoPrecio.setText(Double.toString(equivalencias.get(this.comboMoneda.getSelectedIndex()).getPrecioCompra()));
        this.campoPrecioVenta.setText(Double.toString(equivalencias.get(this.comboMoneda.getSelectedIndex()).getPrecioVenta()));        
    }//GEN-LAST:event_comboMonedaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonguardar;
    private javax.swing.JTextField campoNuevoPrecio;
    private javax.swing.JTextField campoPrecioVenta;
    private javax.swing.JComboBox<String> comboMoneda;
    private javax.swing.JLabel etiquetaCodigo;
    private javax.swing.JLabel etiquetaPrecioCompra;
    private javax.swing.JLabel etiquetaPrecioVenta;
    private javax.swing.JLabel etiquetaTitulo;
    // End of variables declaration//GEN-END:variables
}
